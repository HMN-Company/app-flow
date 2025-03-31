package org.example.flow.repositories;

import org.example.flow.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
    Collection<Media> findMediaByProductId(String id);
}
