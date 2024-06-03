package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReportRoute {

    @Bean(name = "ReportRoute")
    public RouterFunction<ServerResponse> route(ReportHandler handler) {
        return RouterFunctions.route()
                .GET("/reports", handler::getAllReports)
                .GET("/reports/{id}", handler::getReportById)
                .POST("/reports", handler::createReport)
                .PUT("/reports/{id}", handler::updateReport)
                .DELETE("/reports/{id}", handler::deleteReport)
                .build();
    }
}
