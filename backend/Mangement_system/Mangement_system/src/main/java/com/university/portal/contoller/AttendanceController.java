package com.university.portal.contoller;

import com.university.portal.model.Attendance;
import com.university.portal.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public Attendance save(@RequestBody Attendance a) {
        return service.save(a);
    }

    @GetMapping("/{courseId}")
    public List<Attendance> get(@PathVariable Long courseId) {
        return service.get(courseId);
    }
}
