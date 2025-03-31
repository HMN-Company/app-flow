package org.example.flow.controllers.admin;


import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Category;
import org.example.flow.models.Product;
import org.example.flow.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin-manager/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public ModelAndView product() {
        List<ProductDTO> productPage = productService.findAllProductDTO();
        ModelAndView modelAndView = new ModelAndView("admin/product");
        modelAndView.addObject("products", productPage);

        return modelAndView;
    }
}
