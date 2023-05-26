package org.backend.repository;

import org.backend.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String> {

    // Find a parent by their ID
    Parent findById(Long id);

    // Find all parents and order them by the creation date in descending order
    List<Parent> findAllByOrderByCreatedAtDesc();
}
