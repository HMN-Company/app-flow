package org.example.flow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    
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
    public String shopList() {
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