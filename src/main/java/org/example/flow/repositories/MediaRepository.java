package org.example.flow.repositories;

import org.example.flow.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
    @Query("SELECT m.url FROM Media m WHERE m.product.id = :id")
    Collection<String> findMediaUrlByProductId(String id);

    List<Media> findAllByProduct_Id(String id);
}
