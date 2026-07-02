package com.prlens.common.events;

public record IssueCreatedEvent(
    String eventId,
    String issueId,
    String title,
    String description,
    String repository,
    String createdBy
) {
}
