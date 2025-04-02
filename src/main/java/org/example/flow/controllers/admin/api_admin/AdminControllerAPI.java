package org.example.flow.controllers.admin.api_admin;

import org.example.flow.models.Order;
import org.example.flow.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminControllerAPI {
    private final OrderService orderService;

    public AdminControllerAPI(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<Map<String, Object>> getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String status
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Order> orderPage = orderService.findAllByStatus(status, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("orders", orderPage.getContent());
        response.put("currentPage", page);
        response.put("totalPages", orderPage.getTotalPages());
        response.put("status", status);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/delivered")
    public List<Order> getDeliveredOrders(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate) {
        return orderService.findDeliveredOrdersBetween(startDate, endDate);
    }
    @GetMapping("/month")
    public List<Map<String, Object>> getMonthlyRevenue() {
        return orderService.getMonthlyRevenue();
    }
}
