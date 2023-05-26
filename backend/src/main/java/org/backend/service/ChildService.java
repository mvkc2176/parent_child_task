package org.backend.service;

import java.util.List;
import org.backend.model.Child;

public interface ChildService {
    // Retrieves a list of all children
    List<Child> getChildren();
    
    // Retrieves a list of children based on the parent ID
    // parent_id: the ID of the parent
    List<Child> getChildrenByParentId(Long parent_id);
}
