package org.example.flow.repositories;


import org.example.flow.models.EventSpecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSpecialRepository extends JpaRepository<EventSpecial, String> {


}
