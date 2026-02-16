package com.university.portal.contoller;

import com.university.portal.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService service;

    @GetMapping
    public Map<String, Object> stats() {
        return service.stats();
    }
}
