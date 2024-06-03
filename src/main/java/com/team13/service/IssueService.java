package com.team13.service;

import com.team13.model.IssueModel;
import com.team13.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<IssueModel> getAllIssues() {
        return issueRepository.findAll();
    }

    public IssueModel getIssueById(Long id) {
        return issueRepository.findById(id).orElse(null);
    }

    public IssueModel createIssue(IssueModel issue) {
        return issueRepository.save(issue);
    }

    public IssueModel updateIssue(Long id, IssueModel issue) {
        if (issueRepository.existsById(id)) {
            issue.setId(id);
            return issueRepository.save(issue);
        } else {
            return null;
        }
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    public List<IssueModel> getIssuesByStatus(String status) {
        return issueRepository.findByStatus(status);
    }

    public List<IssueModel> getIssuesByAssignee(String assignee) {
        return issueRepository.findByAssignee(assignee);
    }

    public List<IssueModel> getIssuesByReporter(String reporter) {
        return issueRepository.findByReporter(reporter);
    }
}
