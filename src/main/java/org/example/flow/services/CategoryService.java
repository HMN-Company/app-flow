package org.example.flow.services;

import org.example.flow.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends BaseService<Category> {
    Page<Category> findAll(Pageable pageable);

}
