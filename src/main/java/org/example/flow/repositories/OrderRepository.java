package org.example.flow.repositories;

import org.example.flow.models.Order;
import org.example.flow.models.OrderDetailsLog;
import org.example.flow.models.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

        Page<Order> findByStatus(Status status, Pageable pageable);

        @Query("SELECT o FROM Order o WHERE o.status = 'DELIVERED' " +
                "AND (:startDate IS NULL OR o.updatedAt >= :startDate) " +
                "AND (:endDate IS NULL OR o.updatedAt <= :endDate) " +
                "ORDER BY o.updatedAt DESC")
        List<Order> findDeliveredOrdersBetween(
                @Param("startDate") LocalDateTime startDate,
                @Param("endDate") LocalDateTime endDate);

        @Query("SELECT EXTRACT(MONTH FROM o.updatedAt) AS month, EXTRACT(YEAR FROM o.updatedAt) AS year, SUM(o.totalPrice) AS totalRevenue " +
                "FROM Order o WHERE o.status = 'DELIVERED' " +
                "GROUP BY EXTRACT(MONTH FROM o.updatedAt), EXTRACT(YEAR FROM o.updatedAt) " +
                "ORDER BY EXTRACT(YEAR FROM o.updatedAt) DESC, EXTRACT(MONTH FROM o.updatedAt) DESC ")
        List<Object[]> findMonthlyRevenue();


}
