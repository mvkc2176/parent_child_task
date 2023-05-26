package org.backend.repository;

import org.backend.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child, String> {
    // Retrieves a Child entity by its ID
    Optional<Child> findById(Long id);
    
    // Retrieves all Child entities sorted by their creation date in descending order
    List<Child> findAllByOrderByCreatedAtDesc();
    
    // Retrieves all Child entities belonging to a specific parent by their parent ID
    List<Child> findChildrenByParentId(Long parentId);
}
