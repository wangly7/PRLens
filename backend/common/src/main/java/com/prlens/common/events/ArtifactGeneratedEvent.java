package com.prlens.common.events;

import com.prlens.common.enums.ArtifactType;
import com.prlens.common.enums.PullRequestSource;

public record ArtifactGeneratedEvent(
        String eventId,
        String artifactId,
        String issueId,
        String repository,
        ArtifactType artifactType,
        String storagePath,
        PullRequestSource source
) {

}
