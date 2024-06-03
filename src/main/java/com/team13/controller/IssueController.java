package com.team13.controller;

import com.team13.model.IssueModel;
import com.team13.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping
    public List<IssueModel> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}")
    public IssueModel getIssueById(@PathVariable Long id) {
        return issueService.getIssueById(id);
    }

    @PostMapping
    public IssueModel createIssue(@RequestBody IssueModel issue) {
        issue.setStatus("new");
        issue.setReporter(issue.getCreator());
        return issueService.createIssue(issue);
    }

    @PutMapping("/{id}")
    public IssueModel updateIssue(@PathVariable Long id, @RequestBody IssueModel issue) {
        return issueService.updateIssue(id, issue);
    }

    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
    }

    @GetMapping("/status/{status}")
    public List<IssueModel> getIssuesByStatus(@PathVariable String status) {
        return issueService.getIssuesByStatus(status);
    }

    @GetMapping("/assigned/{assignee}")
    public List<IssueModel> getIssuesByAssignee(@PathVariable String assignee) {
        return issueService.getIssuesByAssignee(assignee);
    }

    @GetMapping("/reporter/{reporter}")
    public List<IssueModel> getIssuesByReporter(@PathVariable String reporter) {
        return issueService.getIssuesByReporter(reporter);
    }
}
