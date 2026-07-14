package com.prlens.common.events;

public record ReviewJobEvent(
        String eventId,
        String jobId,
        String issueId,
        String repository,
        Integer prNumber,
        String prUrl
) {
}
