package org.example.flow.repositories;

import org.example.flow.models.Category;
import org.example.flow.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    List<ProductCategory> findAllByProduct_Id(String productId);
}
