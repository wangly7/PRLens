package com.prlens.workflow.service;

import com.prlens.common.events.GitHubPullRequestEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {
    private final KafkaTemplate<String, AnalysisJobEvent> kafkaTemplate;

    public WorkflowService(KafkaTemplate<String, AnalysisJobEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createAnalysisJob(GitHubPullRequestEvent event) {
        AnalysisJobEvent job = new AnalysisJobEvent(
                event.repository(),
                event.pullRequestNumber(),
                AnalysisJobType.AI_REVIEW
        );

        kafkaTemplate.send("analysis-jobs", event.repository(), job);
    }
}
