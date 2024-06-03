package com.team13.route;

import com.team13.model.ReportModel;
import com.team13.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ReportHandler {

    @Autowired
    private ReportService reportService;

    public Mono<ServerResponse> getAllReports(ServerRequest request) {
        List<ReportModel> reports = reportService.getAllReports();
        return ServerResponse.ok().bodyValue(reports);
    }

    public Mono<ServerResponse> getReportById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        ReportModel report = reportService.getReportById(id);
        return report != null ? ServerResponse.ok().bodyValue(report) : ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createReport(ServerRequest request) {
        Mono<ReportModel> reportMono = request.bodyToMono(ReportModel.class);
        return reportMono.flatMap(report -> {
            ReportModel createdReport = reportService.createReport(report);
            return ServerResponse.ok().bodyValue(createdReport);
        });
    }

    public Mono<ServerResponse> updateReport(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<ReportModel> reportMono = request.bodyToMono(ReportModel.class);
        return reportMono.flatMap(report -> {
            ReportModel updatedReport = reportService.updateReport(id, report);
            return ServerResponse.ok().bodyValue(updatedReport);
        });
    }

    public Mono<ServerResponse> deleteReport(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        reportService.deleteReport(id);
        return ServerResponse.ok().build();
    }
}
