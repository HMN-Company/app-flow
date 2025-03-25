package org.example.flow.controllers.admin;


import org.example.flow.models.Category;
import org.example.flow.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin-manager/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ModelAndView category(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Category> categoryPage = categoryService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("admin/category");
        modelAndView.addObject("categories", categoryPage.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", categoryPage.getTotalPages());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView categoryCreate(){
        ModelAndView modelAndView = new ModelAndView("admin/category-create");
        Category category = new Category();
        modelAndView.addObject("category", category);
        return modelAndView;
    }
    @PostMapping("/create")
    public String categoryCreate(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        try{
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("addSuccess", true);
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("addError", true);
        }
        return "redirect:/admin-manager/category/create";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") String id,
                               @ModelAttribute("category") Category category,
                               RedirectAttributes redirectAttributes) {
        try {
            Category existingCategory = categoryService.get(id);
            if (existingCategory != null) {
                existingCategory.setName(category.getName());
                categoryService.save(existingCategory);
                redirectAttributes.addFlashAttribute("editSuccess", true);
            } else {
                redirectAttributes.addFlashAttribute("editErrorNotFound", true);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("editError", true);
        }
        return "redirect:/admin-manager/category";
    }





    @PostMapping("/delete/{id}")
    public String deleteCategory(@RequestParam String id, RedirectAttributes redirectAttributes) {
        try {
            categoryService.deleteById(id);
            redirectAttributes.addFlashAttribute("deleteSuccess", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("deleteError", true);
        }
        return "redirect:/admin-manager/category";
    }
}
