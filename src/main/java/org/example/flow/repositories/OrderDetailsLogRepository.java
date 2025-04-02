package org.example.flow.repositories;

import org.example.flow.models.OrderDetailsLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsLogRepository extends JpaRepository<OrderDetailsLog, String> {
    List<OrderDetailsLog> findByOrderId(String orderId);

}
