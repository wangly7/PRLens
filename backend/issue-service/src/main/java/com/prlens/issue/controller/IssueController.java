package com.prlens.issue.controller;

import com.prlens.common.events.IssueCreatedEvent;
import com.prlens.issue.dto.CreateIssueRequest;
import com.prlens.issue.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<IssueCreatedEvent> createIssue(
        @RequestBody CreateIssueRequest request
    ){
        IssueCreatedEvent event = issueService.createdEvent(request);
        return  ResponseEntity.accepted().body(event);
    }
}
