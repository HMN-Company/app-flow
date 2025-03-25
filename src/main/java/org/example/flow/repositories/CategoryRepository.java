package org.example.flow.repositories;

import org.example.flow.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Page<Category> findAll(Pageable pageable);
    Optional<Category> findByName(String name);

}
