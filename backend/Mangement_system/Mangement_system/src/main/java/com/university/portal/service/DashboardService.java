package com.university.portal.service;

import com.university.portal.repository.AttendanceRepository;
import com.university.portal.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    AttendanceRepository attendanceRepo;

    @Autowired
    SubmissionRepository submissionRepo;

    public Map<String, Object> stats() {
        Map<String, Object> map = new HashMap<>();
        map.put("attendanceCount", attendanceRepo.count());
        map.put("submissionCount", submissionRepo.count());
        return map;
    }
}
