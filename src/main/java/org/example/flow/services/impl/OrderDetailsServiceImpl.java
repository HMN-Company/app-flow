package org.example.flow.services.impl;

import org.example.flow.models.OrderDetails;
import org.example.flow.services.OrderDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Override
    public void save(OrderDetails entity) {

    }

    @Override
    public void update(OrderDetails entity) {

    }

    @Override
    public void delete(OrderDetails entity) {

    }

    @Override
    public OrderDetails get(String  id) {
        return null;
    }

    @Override
    public Collection<OrderDetails> getAll() {
        return List.of();
    }
}
