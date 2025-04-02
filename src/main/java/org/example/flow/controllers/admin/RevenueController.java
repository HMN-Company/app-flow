package org.example.flow.controllers.admin;


import org.example.flow.models.Order;
import org.example.flow.services.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin-manager/revenue")
public class RevenueController {
    private final OrderService orderService;

    public RevenueController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("")
    public String getDeliveredOrders(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate,
            Model model) {

        // Lấy danh sách các đơn hàng từ service
        List<Order> orders = orderService.findDeliveredOrdersBetween(startDate, endDate);
        double totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();

        // Thêm danh sách đơn hàng vào model để gửi qua Thymeleaf
        model.addAttribute("orders", orders);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("totalRevenue", totalRevenue);

        return "admin/revenue";

}
    @GetMapping("/month")
    public String getMonthlyRevenue(Model model) {
        List<Map<String, Object>> monthlyRevenue = orderService.getMonthlyRevenue();
        Map<Integer, List<Map<String, Object>>> groupedByYear = monthlyRevenue.stream()
                .collect(Collectors.groupingBy(data -> (Integer) data.get("year")));

// Duyệt qua từng năm và thêm dữ liệu cho các tháng thiếu
        groupedByYear.forEach((year, monthData) -> {
            // Tạo một mảng cho 12 tháng
            Map<Integer, Double> revenueByMonth = new HashMap<>();
            for (int i = 1; i <= 12; i++) {
                revenueByMonth.put(i, 0.0); // Khởi tạo tất cả doanh thu tháng là 0
            }

            // Cập nhật doanh thu cho các tháng có dữ liệu
            for (Map<String, Object> data : monthData) {
                int month = (Integer) data.get("month");
                double revenue = (Double) data.get("totalRevenue");
                revenueByMonth.put(month, revenue); // Cập nhật doanh thu cho tháng cụ thể
            }

            // Chuyển đổi map thành list cho Thymeleaf
            List<Map<String, Object>> updatedMonthData = revenueByMonth.entrySet().stream()
                    .map(entry -> {
                        Map<String, Object> entryMap = new HashMap<>();
                        entryMap.put("month", entry.getKey());
                        entryMap.put("totalRevenue", entry.getValue());
                        return entryMap;
                    }).collect(Collectors.toList());

            // Cập nhật lại dữ liệu cho năm đó
            groupedByYear.put(year, updatedMonthData);
        });

        model.addAttribute("groupedByYear", groupedByYear);
        return "admin/revenue-month";

    }


}


