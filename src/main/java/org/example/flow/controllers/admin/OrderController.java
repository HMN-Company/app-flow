package org.example.flow.controllers.admin;

import org.example.flow.models.Order;
import org.example.flow.models.OrderDetailsLog;
import org.example.flow.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin-manager/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable String id, RedirectAttributes redirectAttributes) {
        boolean confirm = orderService.confirmOrder(id);
        if(confirm){
            redirectAttributes.addFlashAttribute("confirmSuccess", true);
        }
        else {
            redirectAttributes.addFlashAttribute("confirmError", true);
        }
        return "redirect:/dashboard";
    }
    @GetMapping("/deliver/{id}")
    public String deliver(@PathVariable String id, RedirectAttributes redirectAttributes) {
        boolean deliver = orderService.deliverOrder(id);
        if(deliver){
            redirectAttributes.addFlashAttribute("deliverSuccess", true);
        }
        else {
            redirectAttributes.addFlashAttribute("deliverError", true);
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable String id, RedirectAttributes redirectAttributes) {
        boolean cancel = orderService.cancelOrder(id);
        if(cancel){
            redirectAttributes.addFlashAttribute("cancelSuccess", true);
        }
        else {
            redirectAttributes.addFlashAttribute("cancelError", true);
        }
        return "redirect:/dashboard";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model ) {
        List<OrderDetailsLog> orderDetailsLogs = orderService.findByOrderId(id);
        Order order = orderService.get(id);
        model.addAttribute("orderDetailsLogs", orderDetailsLogs);
        model.addAttribute("totalAmount", order.getTotalPrice());
        return "admin/order-view";


    }


}

