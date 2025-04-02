package org.example.flow.services.impl;

import org.example.flow.models.Order;
import org.example.flow.models.OrderDetailsLog;
import org.example.flow.models.Status;
import org.example.flow.repositories.OrderDetailsLogRepository;
import org.example.flow.repositories.OrderRepository;
import org.example.flow.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailsLogRepository orderDetailsLogRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailsLogRepository orderDetailsLogRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsLogRepository = orderDetailsLogRepository;
    }

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);


    }

    @Override
    public void update(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    @Override
    public Order get(String id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public Collection<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> findAllByStatus(String status, Pageable pageable) {
        return orderRepository.findByStatus(Status.valueOf(status.toUpperCase()), pageable);
    }

    @Override
    public void updateOrderStatus(String id, String newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng!"));

        order.setStatus(Status.valueOf(newStatus));
        orderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public boolean confirmOrder(String id) {
        try {
            Order order = orderRepository.getReferenceById(id);
            order.setStatus(Status.CONFIRMED);
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deliverOrder(String id) {
        try {
            Order order = orderRepository.getReferenceById(id);
            order.setStatus(Status.DELIVERED);
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean cancelOrder(String id) {
        try {
            Order order = orderRepository.getReferenceById(id);
            order.setStatus(Status.CANCELLED);
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<OrderDetailsLog> findByOrderId(String id) {
        return orderDetailsLogRepository.findByOrderId(id);
    }

    @Override
    public List<Order> findDeliveredOrdersBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findDeliveredOrdersBetween(startDate, endDate);
    }

    @Override
    public List<Map<String, Object>> getMonthlyRevenue() {
        List<Object[]> results = orderRepository.findMonthlyRevenue();
        List<Map<String, Object>> monthlyRevenue = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> revenue = new HashMap<>();
            revenue.put("month", result[0]);
            revenue.put("year", result[1]);
            revenue.put("totalRevenue", result[2]);
            monthlyRevenue.add(revenue);
        }

        return monthlyRevenue;
    }
}
