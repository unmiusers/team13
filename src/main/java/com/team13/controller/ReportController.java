package com.team13.controller;

import com.team13.model.ReportModel;
import com.team13.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportModel> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ReportModel getReportById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    public ReportModel createReport(@RequestBody ReportModel report) {
        return reportService.createReport(report);
    }

    @PutMapping("/{id}")
    public ReportModel updateReport(@PathVariable Long id, @RequestBody ReportModel report) {
        return reportService.updateReport(id, report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}
