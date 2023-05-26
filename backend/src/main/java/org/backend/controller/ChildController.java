package org.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.backend.model.Child;
import org.backend.service.ChildService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/children")

public class ChildController {
	private final ChildService childService;

	// Constructor injection for ChildService
	public ChildController(ChildService childService) {
		this.childService = childService;
	}
	
	
	@GetMapping
	public List<Child> getChildren() {
		// Retrieve a list of children from the childService
		List<Child> children = childService.getChildren();
		
		// Convert the list to a stream and collect it back into a list
		return children.stream().collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public List<Child> getChildrenByParentId(@PathVariable String id) {
		// Convert the ID from string to a Long value
		Long parent_id = Long.valueOf(id);
		
		// Retrieve a list of children by parent ID from the childService
		List<Child> children = childService.getChildrenByParentId(parent_id);
		
		// Convert the list to a stream and collect it back into a list
        return children.stream().collect(Collectors.toList());
    }
}
