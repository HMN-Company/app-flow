package org.example.flow.controllers;

import org.example.flow.models.Product;
import org.example.flow.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

    @Autowired
    private ProductService productService; // Assuming ProductService is injected here

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/shop-grid")
    public String shopGrid() {
        return "shop-grid";
    }

    @GetMapping("/shop-grid-sidebar")
    public String shopGridSidebar() {
        return "shop-grid-sidebar";
    }



    @GetMapping("/shop-list")
    public String getAllBlogs(@RequestParam(required = false, defaultValue = "0") int page,
                              @RequestParam(required = false, defaultValue = "") String searchName,
                              Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "price").and(Sort.by(Sort.Direction.DESC, "name"));
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<Product> products  = productService.findAllAndSearch( searchName,  pageable);
        model.addAttribute("products", products);
        return "shop-list";

    }



    @GetMapping("/product-detail")
    public String productDetail() {
        return "product-detail";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/wishlist")
    public String wishlist() {
        return "wishlist";
    }

    @GetMapping("/track-order")
    public String trackOrder() {
        return "track-order";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/blogs")
    public String blogs() {
        return "blogs";
    }

    @GetMapping("/blogs-sidebar")
    public String blogsSidebar() {
        return "blogs-sidebar";
    }

    @GetMapping("/blog-detail")
    public String blogDetail() {
        return "blog-detail";
    }
    
    @GetMapping("/login/user")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }

    @GetMapping("/coming-soon")
    public String comingSoon() {
        return "coming-soon";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
} 