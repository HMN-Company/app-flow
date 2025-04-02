package org.example.flow.controllers.admin;


import org.example.flow.models.Order;
import org.example.flow.models.OrderDetailsLog;
import org.example.flow.models.Status;
import org.example.flow.repositories.OrderRepository;
import org.example.flow.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class AdminController {
    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping()
    public String admin(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size,
                        @RequestParam(name = "status", required = false) Status statusSearch,
                        Model model
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Order> orderPage;
        if (statusSearch != null) {
            orderPage = orderService.findAllByStatus(statusSearch.toString(), pageable);
        }
        else {
            orderPage = orderService.findAll(pageable);

        }
        model.addAttribute("statuses", Status.values()); // Truyền danh sách Enum xuống View

        model.addAttribute("orders", orderPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", orderPage.getTotalPages());
        model.addAttribute("statusSearch", statusSearch);

        return "admin/index";
    }



}
