package com.prlens.workflow.consumer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.ArtifactGeneratedEvent;
import com.prlens.workflow.service.WorkflowOrchestrator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArtifactGeneratedEventConsumer {
    private final WorkflowOrchestrator orchestrator;

    public ArtifactGeneratedEventConsumer(WorkflowOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @KafkaListener(
            topics = KafkaTopics.ARTIFACT_EVENTS,
            groupId = "workflow-service"
    )
    public void consume(ArtifactGeneratedEvent event) {
        log.info(
                "Received ArtifactGeneratedEvent. eventId={}, artifactId={}, issueId={}, artifactType={}",
                event.eventId(),
                event.artifactId(),
                event.issueId(),
                event.artifactType()
        );
        orchestrator.handleArtifactGenerated(event);
    }
}
