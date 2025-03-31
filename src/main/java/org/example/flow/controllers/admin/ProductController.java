package org.example.flow.controllers.admin;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Category;
import org.example.flow.models.Product;
import org.example.flow.services.CategoryService;
import org.example.flow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("admin-manager/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;


    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("")
    public String searchProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDTO> productPage = productService.searchProducts(name, category, pageable);
        List<Category> categories = (List<Category>) categoryService.getAll();

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("name", name);
        model.addAttribute("category", category);
        model.addAttribute("categories", categories);

        return "admin/product"; // Trả về template Thymeleaf
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            redirectAttributes.addFlashAttribute("deleteSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("deleteError", true);
        }
        return "redirect:/admin-manager/product"; // Chuyển hướng về danh sách sản phẩm
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categories = (List<Category>) categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDTO());
        return "admin/product-create";
    }


    // Xử lý lưu sản phẩm (kèm hình ảnh)
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") ProductDTO productDTO,
                                @RequestParam("imageFiles") MultipartFile[] imageFiles,
                                RedirectAttributes redirectAttributes) {
        boolean created = productService.createProduct(productDTO, imageFiles);
        if (created) {
            redirectAttributes.addFlashAttribute("addSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("addError", true);
        }
        return "redirect:/admin-manager/product/create"; // Chuyển hướng về danh sách sản phẩm
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable String id, Model model) {
        ProductDTO productDTO = productService.getProductById(id); // Trả về DTO thay vì entity
        model.addAttribute("product", productDTO);
        model.addAttribute("categories", categoryService.getAll());
        return "admin/product-edit"; // Trả về trang chỉnh sửa
    }


    // Xử lý lưu sản phẩm (kèm hình ảnh)
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") ProductDTO productDTO,
                                @RequestParam("imageFiles") MultipartFile[] imageFiles,
                                RedirectAttributes redirectAttributes) {
        boolean update = productService.updateProduct(productDTO, imageFiles);
        if (update) {
            redirectAttributes.addFlashAttribute("editSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("editError", true);
        }
        return "redirect:/admin-manager/product"; // Chuyển hướng về danh sách sản phẩm
    }



}
