package com.university.portal.service;

import com.university.portal.model.Assignment;
import com.university.portal.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repo;

    public Assignment save(Assignment a) {
        return repo.save(a);
    }

    public List<Assignment> getAll() {
        return repo.findAll();
    }
}
