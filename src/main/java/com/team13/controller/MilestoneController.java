package com.team13.controller;

import com.team13.model.MilestoneModel;
import com.team13.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @GetMapping
    public List<MilestoneModel> getAllMilestones() {
        return milestoneService.getAllMilestones();
    }

    @GetMapping("/{id}")
    public MilestoneModel getMilestoneById(@PathVariable Long id) {
        return milestoneService.getMilestoneById(id);
    }

    @PostMapping
    public MilestoneModel createMilestone(@RequestBody MilestoneModel milestone) {
        return milestoneService.createMilestone(milestone);
    }

    @PutMapping("/{id}")
    public MilestoneModel updateMilestone(@PathVariable Long id, @RequestBody MilestoneModel milestone) {
        return milestoneService.updateMilestone(id, milestone);
    }

    @DeleteMapping("/{id}")
    public void deleteMilestone(@PathVariable Long id) {
        milestoneService.deleteMilestone(id);
    }
}
