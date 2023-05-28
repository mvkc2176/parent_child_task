package org.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.backend.controller.dto.child.GetChildrenPaginationRequest;
import org.backend.model.Child;
import org.backend.service.ChildService;
import org.springframework.web.bind.annotation.*;
import org.json.JSONException;
import org.json.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

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

	@PostMapping("/{page_num}")
	public ResponseEntity<?> getChildrenByParentId(@PathVariable String page_num, @RequestBody GetChildrenPaginationRequest childrenPaginationRequest ) throws JSONException {
		Long parentId = childrenPaginationRequest.getParentId();
		int pageNum = Integer.valueOf(page_num);
		
		// Retrieve a list of children by parent ID from the childService
		JSONObject jsonObject = childService.getChildrenByParentId(parentId, pageNum);

		return ResponseEntity.ok(jsonObject.toString());
    }
}
