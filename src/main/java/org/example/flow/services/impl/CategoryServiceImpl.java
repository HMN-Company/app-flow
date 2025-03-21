package org.example.flow.services.impl;

import org.example.flow.models.Category;
import org.example.flow.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public void save(Category entity) {

    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public Category get(Long id) {
        return null;
    }

    @Override
    public Collection<Category> getAll() {
        return List.of();
    }
}
