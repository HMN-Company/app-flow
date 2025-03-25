package org.example.flow.services.impl;

import org.example.flow.models.Category;
import org.example.flow.repositories.CategoryRepository;
import org.example.flow.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category entity) {
        categoryRepository.save(entity);

    }

    @Override
    public void update(Category entity) {
        categoryRepository.save(entity);

    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);

    }

    @Override
    public Category get(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }
}