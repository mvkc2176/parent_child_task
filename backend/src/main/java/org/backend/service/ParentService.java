package org.backend.service;

import java.util.List;
import org.backend.model.Parent;

public interface ParentService {
    // Retrieves a list of parents
    List<Parent> getParents();
}
