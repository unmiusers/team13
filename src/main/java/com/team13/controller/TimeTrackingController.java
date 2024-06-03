package com.team13.controller;

import com.team13.model.TimeTrackingModel;
import com.team13.service.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetracking")
public class TimeTrackingController {

    @Autowired
    private TimeTrackingService timeTrackingService;

    @GetMapping
    public List<TimeTrackingModel> getAllTimeTrackings() {
        return timeTrackingService.getAllTimeTrackings();
    }

    @GetMapping("/{id}")
    public TimeTrackingModel getTimeTrackingById(@PathVariable Long id) {
        return timeTrackingService.getTimeTrackingById(id);
    }

    @PostMapping
    public TimeTrackingModel createTimeTracking(@RequestBody TimeTrackingModel timeTracking) {
        return timeTrackingService.createTimeTracking(timeTracking);
    }

    @PutMapping("/{id}")
    public TimeTrackingModel updateTimeTracking(@PathVariable Long id, @RequestBody TimeTrackingModel timeTracking) {
        return timeTrackingService.updateTimeTracking(id, timeTracking);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeTracking(@PathVariable Long id) {
        timeTrackingService.deleteTimeTracking(id);
    }
}
