package org.example.flow.repositories;

import org.example.flow.models.Category;
import org.example.flow.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
    List<Media> findAllByProduct_Id(String id);

}
