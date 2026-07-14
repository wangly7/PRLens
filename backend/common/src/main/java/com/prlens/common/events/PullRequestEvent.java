package com.prlens.common.events;

import com.prlens.common.enums.PullRequestEventType;

public record PullRequestEvent(
        String eventId,
        String issueId,
        String repository,
        Integer prNumber,
        String prUrl,
        String branchName,
        PullRequestEventType eventType,
        String source
) {
}
