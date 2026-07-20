package com.prlens.issue.dto;

import com.prlens.issue.entity.IssueStatus;

import java.util.UUID;

public record CreateIssueResponse(
        UUID issueId,
        IssueStatus status
) {
}
