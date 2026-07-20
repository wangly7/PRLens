package com.prlens.issue.controller;

import com.prlens.common.events.IssueCreatedEvent;
import com.prlens.issue.dto.CreateIssueRequest;
import com.prlens.issue.dto.CreateIssueResponse;
import com.prlens.issue.service.IssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<CreateIssueResponse> createIssue(
        @RequestBody CreateIssueRequest request
    ){
        CreateIssueResponse response = issueService.createIssue(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
