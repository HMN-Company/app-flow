package org.example.flow.repositories;

import org.example.flow.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
}
