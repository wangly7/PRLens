package com.prlens.issue.dto;

public record CreateIssueRequest(
        String title,
        String description,
        String repository,
        String createdBy
) {
}
