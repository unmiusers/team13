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
        if (timeTrackingRepository.existsById(id)) {
            timeTracking.setId(id);
            return timeTrackingRepository.save(timeTracking);
        } else {
            return null;
        }
    }

    public void deleteTimeTracking(Long id) {
        timeTrackingRepository.deleteById(id);
    }
}
