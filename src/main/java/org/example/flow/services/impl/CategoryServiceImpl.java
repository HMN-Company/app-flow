package org.example.flow.services.impl;

import org.example.flow.models.Category;
import org.example.flow.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Category get(String id) {
        return null;
    }

    @Override
    public Collection<Category> getAll() {
        return List.of();
    }


    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }
}
