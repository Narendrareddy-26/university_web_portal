package com.university.portal.service;

import com.university.portal.model.Attendance;
import com.university.portal.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public Attendance save(Attendance a) {
        return repo.save(a);
    }

    public List<Attendance> get(Long courseId) {
        return repo.findByCourseId(courseId);
    }
}
