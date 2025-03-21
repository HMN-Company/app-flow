package org.example.flow.services.impl;

import org.example.flow.models.Order;
import org.example.flow.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void save(Order entity) {

    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public Collection<Order> getAll() {
        return List.of();
    }
}
