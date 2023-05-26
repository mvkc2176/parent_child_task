package org.backend.controller;

import org.backend.model.Parent;
import org.backend.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import jara.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parents")

public class ParentController {
	private final ParentService parentService;

	public ParentController(ParentService parentService) {
		this.parentService = parentService;
	}


	@GetMapping
	public List<Parent> getBlogs() {
		// Get parents from the parent service
		List<Parent> parents = parentService.getParents();
		
		// Convert the list of parents to a stream and collect them back into a list
		return parents.stream().collect(Collectors.toList());
	}
}
