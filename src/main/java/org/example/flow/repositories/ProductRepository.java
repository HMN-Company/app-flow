package org.example.flow.repositories;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Category;
import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    ) c ON p.id = c.product_id
    ORDER BY p.created_at DESC
    """,
            countQuery = "SELECT COUNT(*) FROM Product", // Đếm tổng số sản phẩm để hỗ trợ phân trang
            nativeQuery = true)
    Page<Object[]> findAllProductDTO(Pageable pageable);

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
    ) c ON p.id = c.product_id
    WHERE (:name IS NULL OR p.name LIKE %:name%) 
    AND (:category IS NULL OR c.names LIKE %:category%) 
    ORDER BY p.created_at DESC
    """,
            countQuery = """
    SELECT COUNT(*) FROM Product p
    LEFT JOIN ( 
        SELECT pc.product_id, GROUP_CONCAT(c.name SEPARATOR ', ') AS names 
        FROM product_category pc 
        JOIN Category c ON pc.category_id = c.id 
        GROUP BY pc.product_id 
    ) c ON p.id = c.product_id
    WHERE (:name IS NULL OR p.name LIKE %:name%) 
    AND (:category IS NULL OR c.names LIKE %:category%) 
    """,
            nativeQuery = true)
    Page<Object[]> searchProducts(@Param("name") String name, @Param("category") String category, Pageable pageable);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_category WHERE product_id = :productId", nativeQuery = true)
    void deleteProductCategories(@Param("productId") String productId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM media WHERE product_id = :productId", nativeQuery = true)
    void deleteProductImages(@Param("productId") String productId);


}
