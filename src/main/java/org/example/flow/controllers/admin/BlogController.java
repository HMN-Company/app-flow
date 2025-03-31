package org.example.flow.controllers.admin;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Blog;
import org.example.flow.services.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin-manager/blog")
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping
    public String listBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String title,
            Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Blog> blogPage = blogService.findByTitleContaining(title,pageable);
        List<Blog> blogs = (List<Blog>) blogService.getAll();
        model.addAttribute("blogs", blogPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", blogPage.getTotalPages());
        model.addAttribute("title", title);
        return "admin/blog";
    }

    @GetMapping("/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "admin/blog-create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute("blog") Blog blog,
                             @RequestParam(value = "backgroundMultipartFile", required = false) MultipartFile backgroundMultipartFile,
                             @RequestParam(value = "avatarAuthorMultipartFile", required = false) MultipartFile avatarAuthorMultipartFile,
                             @RequestParam(value = "image1MultipartFile", required = false) MultipartFile image1MultipartFile,
                             @RequestParam(value = "image2MultipartFile", required = false) MultipartFile image2MultipartFile,
                             RedirectAttributes redirectAttributes) {
        boolean created = blogService.createBlog(blog, backgroundMultipartFile, avatarAuthorMultipartFile, image1MultipartFile, image2MultipartFile);
        if (created) {
            redirectAttributes.addFlashAttribute("addSuccess", true);
        } else {
            redirectAttributes.addFlashAttribute("addError", true);
        }
        return "redirect:/admin-manager/blog/create";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@RequestParam String id, RedirectAttributes redirectAttributes) {
        try {
            blogService.delete(blogService.get(id));
            redirectAttributes.addFlashAttribute("deleteSuccess", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("deleteError", true);
        }
        return "redirect:/admin-manager/blog";
    }


}
