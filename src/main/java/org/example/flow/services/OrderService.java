package org.example.flow.services;

import org.example.flow.models.Order;
import org.example.flow.models.OrderDetailsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OrderService extends BaseService<Order> {
    Page<Order> findAllByStatus(String status, Pageable pageable);
    void updateOrderStatus(String id, String newStatus);
    Page<Order> findAll( Pageable pageable);
    boolean confirmOrder(String id);
    boolean deliverOrder(String id);
    boolean cancelOrder(String id);
    List<OrderDetailsLog> findByOrderId(String id);


    List<Order> findDeliveredOrdersBetween(@Param("startDate") LocalDateTime startDate,
                                           @Param("endDate") LocalDateTime endDate);

    public List<Map<String, Object>> getMonthlyRevenue();
}
