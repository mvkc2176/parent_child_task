package org.backend.service;

import org.backend.model.Child;
import org.backend.model.Parent;
import org.backend.repository.ChildRepository;
import org.backend.repository.ParentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository; // Repository for child entities
    private final ParentRepository parentRepository; // Repository for parent entities

    // Constructor with required arguments injection
    public ChildServiceImpl(ChildRepository childRepository, ParentRepository parentRepository) {
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Child> getChildren() {
        return childRepository.findAllByOrderByCreatedAtDesc(); // Retrieve all children entities in descending order of creation
    }

    @Override
    public List<Child> getChildrenByParentId(Long parent_id) {
        List<Child> children = childRepository.findChildrenByParentId(parent_id); // Retrieve children entities by parent ID
        Parent parent = parentRepository.findById(parent_id); // Retrieve the parent entity by ID

        for (Child child : children) {
            child.setParent(parent); // Set the parent for each child entity
        }

        return children; // Return the list of children entities with their respective parent
    }
}
