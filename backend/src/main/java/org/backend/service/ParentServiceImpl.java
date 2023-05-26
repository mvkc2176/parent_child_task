package org.backend.service;

import org.backend.model.Parent;
import org.backend.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
	
    // Constructor injection of ParentRepository
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
	
    @Override
    public List<Parent> getParents() {
        // Retrieve a list of parents from the repository, ordered by creation date in descending order
        return parentRepository.findAllByOrderByCreatedAtDesc();
    }
}
