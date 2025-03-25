package org.example.flow.repositories;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Category;
import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    @Query(value = """
        SELECT p.id, p.name, p.description, p.price, p.discount, 
               COALESCE(m.urls, '') AS imageUrls, 
               COALESCE(c.names, '') AS categoryNames, 
               p.created_at, p.updated_at 
        FROM Product p 
        LEFT JOIN ( 
            SELECT m.product_id, GROUP_CONCAT(m.url SEPARATOR ', ') AS urls 
            FROM Media m 
            GROUP BY m.product_id 
        ) m ON p.id = m.product_id 
        LEFT JOIN ( 
            SELECT pc.product_id, GROUP_CONCAT(c.name SEPARATOR ', ') AS names 
            FROM product_category pc 
            JOIN Category c ON pc.category_id = c.id 
            GROUP BY pc.product_id 
        ) c ON p.id = c.product_id;
    """, nativeQuery = true)
    List<Object[]> findAllProductDTO();
}
