package com.team13.service;

import com.team13.model.TimeTrackingModel;
import com.team13.repository.TimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTrackingService {

    @Autowired
    private TimeTrackingRepository timeTrackingRepository;

    public List<TimeTrackingModel> getAllTimeTrackings() {
        return timeTrackingRepository.findAll();
    }

    public TimeTrackingModel getTimeTrackingById(Long id) {
        return timeTrackingRepository.findById(id).orElse(null);
    }

    public TimeTrackingModel createTimeTracking(TimeTrackingModel timeTracking) {
        return timeTrackingRepository.save(timeTracking);
    }

    public TimeTrackingModel updateTimeTracking(Long id, TimeTrackingModel timeTracking) {
        TimeTrackingModel existingTimeTracking = getTimeTrackingById(id);
        if (existingTimeTracking != null) {
            existingTimeTracking.setTaskName(timeTracking.getTaskName());
            existingTimeTracking.setHoursSpent(timeTracking.getHoursSpent());
            return timeTrackingRepository.save(existingTimeTracking);
        }
        return null;
    }

    public void deleteTimeTracking(Long id) {
        timeTrackingRepository.deleteById(id);
    }
}
