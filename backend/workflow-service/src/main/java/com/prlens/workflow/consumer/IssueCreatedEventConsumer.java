package com.prlens.workflow.consumer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.IssueCreatedEvent;
import com.prlens.workflow.service.WorkflowOrchestrator;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class IssueCreatedEventConsumer {
    private final WorkflowOrchestrator orchestrator;

    public IssueCreatedEventConsumer(WorkflowOrchestrator orchestrator){
        this.orchestrator = orchestrator;
    }

    @KafkaListener(topics = KafkaTopics.ISSUE_EVENTS, groupId = "workflow-service")
    public void consume(IssueCreatedEvent event) {
        orchestrator.handleIssueCreated(event);
    }
}
