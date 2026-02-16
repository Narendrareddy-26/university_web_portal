package com.university.portal.contoller;

import com.university.portal.model.Assignment;
import com.university.portal.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService service;

    @PostMapping
    public Assignment save(@RequestBody Assignment a) {
        return service.save(a);
    }

    @GetMapping
    public List<Assignment> getAll() {
        return service.getAll();
    }
}
