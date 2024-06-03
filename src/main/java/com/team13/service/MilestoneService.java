package com.team13.service;

import com.team13.model.MilestoneModel;
import com.team13.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    public List<MilestoneModel> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    public MilestoneModel getMilestoneById(Long id) {
        return milestoneRepository.findById(id).orElse(null);
    }

    public MilestoneModel createMilestone(MilestoneModel milestone) {
        return milestoneRepository.save(milestone);
    }

    public MilestoneModel updateMilestone(Long id, MilestoneModel milestone) {
        if (milestoneRepository.existsById(id)) {
            milestone.setId(id);
            return milestoneRepository.save(milestone);
        } else {
            return null;
        }
    }

    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);
    }
}
