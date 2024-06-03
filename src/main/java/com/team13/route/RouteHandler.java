package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouteHandler {

    @Bean(name = "RouteHandler")
    public RouterFunction<ServerResponse> route(UserHandler userHandler, ProjectHandler projectHandler,
                                                IssueHandler issueHandler, CommentHandler commentHandler,
                                                TimeTrackingHandler timeTrackingHandler, NotificationHandler notificationHandler,
                                                ReportHandler reportHandler, MilestoneHandler milestoneHandler, VersionHandler versionHandler) {
        return RouterFunctions.route()
                .GET("/api/users", userHandler::getAllUsers)
                .GET("/api/users/{id}", userHandler::getUserById)
                .POST("/api/users", userHandler::createUser)
                .PUT("/api/users/{id}", userHandler::updateUser)
                .DELETE("/api/users/{id}", userHandler::deleteUser)
                .GET("/api/projects", projectHandler::getAllProjects)
                .GET("/api/projects/{id}", projectHandler::getProjectById)
                .POST("/api/projects", projectHandler::createProject)
                .PUT("/api/projects/{id}", projectHandler::updateProject)
                .DELETE("/api/projects/{id}", projectHandler::deleteProject)
                .GET("/api/issues", issueHandler::getAllIssues)
                .GET("/api/issues/{id}", issueHandler::getIssueById)
                .POST("/api/issues", issueHandler::createIssue)
                .PUT("/api/issues/{id}", issueHandler::updateIssue)
                .DELETE("/api/issues/{id}", issueHandler::deleteIssue)
                .GET("/api/comments", commentHandler::getAllComments)
                .GET("/api/comments/{id}", commentHandler::getCommentById)
                .POST("/api/comments", commentHandler::createComment)
                .PUT("/api/comments/{id}", commentHandler::updateComment)
                .DELETE("/api/comments/{id}", commentHandler::deleteComment)
                .GET("/api/timetracking", timeTrackingHandler::getAllTimeTrackings)
                .GET("/api/timetracking/{id}", timeTrackingHandler::getTimeTrackingById)
                .POST("/api/timetracking", timeTrackingHandler::createTimeTracking)
                .PUT("/api/timetracking/{id}", timeTrackingHandler::updateTimeTracking)
                .DELETE("/api/timetracking/{id}", timeTrackingHandler::deleteTimeTracking)
                .GET("/api/notifications", notificationHandler::getAllNotifications)
                .GET("/api/notifications/{id}", notificationHandler::getNotificationById)
                .POST("/api/notifications", notificationHandler::createNotification)
                .PUT("/api/notifications/{id}", notificationHandler::updateNotification)
                .DELETE("/api/notifications/{id}", notificationHandler::deleteNotification)
                .GET("/api/reports", reportHandler::getAllReports)
                .GET("/api/reports/{id}", reportHandler::getReportById)
                .POST("/api/reports", reportHandler::createReport)
                .PUT("/api/reports/{id}", reportHandler::updateReport)
                .DELETE("/api/reports/{id}", reportHandler::deleteReport)
                .GET("/api/milestones", milestoneHandler::getAllMilestones)
                .GET("/api/milestones/{id}", milestoneHandler::getMilestoneById)
                .POST("/api/milestones", milestoneHandler::createMilestone)
                .PUT("/api/milestones/{id}", milestoneHandler::updateMilestone)
                .DELETE("/api/milestones/{id}", milestoneHandler::deleteMilestone)
                .GET("/api/versions", versionHandler::getAllVersions)
                .GET("/api/versions/{id}", versionHandler::getVersionById)
                .POST("/api/versions", versionHandler::createVersion)
                .PUT("/api/versions/{id}", versionHandler::updateVersion)
                .DELETE("/api/versions/{id}", versionHandler::deleteVersion)
                .build();
    }
}
