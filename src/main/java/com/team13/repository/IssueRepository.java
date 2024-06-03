package com.team13.repository;

import com.team13.model.IssueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueModel, Long> {
    List<IssueModel> findByStatus(String status);
    List<IssueModel> findByAssignee(String assignee);
    List<IssueModel> findByReporter(String reporter);
}
