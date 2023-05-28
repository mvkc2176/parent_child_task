package org.backend.controller;

import org.backend.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parents")

public class ParentController {
	private final ParentService parentService;

	public ParentController(ParentService parentService) {
		this.parentService = parentService;
	}

	@GetMapping("/{pageNum}")
	public ResponseEntity<?> getParents(@PathVariable String pageNum) throws JSONException {
		int page_num = Integer.valueOf(pageNum);

		// Get parents from the parent service
		JSONObject jsonObject = parentService.getParents(page_num);
		
		// Convert the list of parents to a stream and collect them back into a list
		return ResponseEntity.ok(jsonObject.toString());
	}
}
