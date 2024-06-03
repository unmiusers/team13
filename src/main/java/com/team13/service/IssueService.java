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
        IssueModel existingIssue = getIssueById(id);
        if (existingIssue != null) {
            existingIssue.setTitle(issue.getTitle());
            existingIssue.setDescription(issue.getDescription());
            return issueRepository.save(existingIssue);
        }
        return null;
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}
