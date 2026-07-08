package com.prlens.common.events;

import com.prlens.common.enums.ArtifactType;

public record ArtifactGeneratedEvent(
        String eventId,
        String artifactId,
        String issueId,
        ArtifactType artifactType,
        String storagePath,
        String createdByAgent
) {

}
