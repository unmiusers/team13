package com.team13.service;

import com.team13.model.ReportModel;
import com.team13.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<ReportModel> getAllReports() {
        return reportRepository.findAll();
    }

    public ReportModel getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public ReportModel createReport(ReportModel report) {
        return reportRepository.save(report);
    }

    public ReportModel updateReport(Long id, ReportModel report) {
        if (reportRepository.existsById(id)) {
            report.setId(id);
            return reportRepository.save(report);
        } else {
            return null;
        }
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
