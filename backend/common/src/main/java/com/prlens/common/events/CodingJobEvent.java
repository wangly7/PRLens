package com.prlens.common.events;

public record CodingJobEvent(
        String eventId,
        String jobId,
        String issueId,
        String repository,
        String designDocPath,
        String targetBranch
) {
}
