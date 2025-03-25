package org.example.flow.repositories;

import org.example.flow.models.Category;
import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
