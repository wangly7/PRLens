package com.prlens.workflow.consumer;

import com.prlens.workflow.service.WorkflowService;
import org.springframework.kafka.annotation.KafkaListener;
import  org.springframework.stereotype.Component;
import com.prlens.common.events.GitHubPullRequestEvent;

@Component
public class PullRequestEventConsumer {

    private final WorkflowService service;

    public PullRequestEventConsumer(WorkflowService service) {
        this.service = service;
    }

    @KafkaListener(topics = "pr-events", groupId = "analysis-service")
    public void consume(GitHubPullRequestEvent event) {
        System.out.println("Received PR event: " + event);
        service.createAnalysisJob(event);
    }
}
