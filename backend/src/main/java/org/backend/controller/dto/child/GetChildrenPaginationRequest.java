package org.backend.controller.dto.child;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class GetChildrenPaginationRequest {
    @NotBlank
    @NotNull
    private Long parentId;
	
	public Long getParentId() {
		return parentId;
	}
}
