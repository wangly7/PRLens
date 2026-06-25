package com.prlens.analysis.consumer;

import com.prlens.analysis.service.AnalysisService;
import org.springframework.kafka.annotation.KafkaListener;
import  org.springframework.stereotype.Component;
import com.prlens.common.events.GitHubPullRequestEvent;

@Component
public class PullRequestEventConsumer {

    private final AnalysisService service;

    public PullRequestEventConsumer(AnalysisService service) {
        this.service = service;
    }

    @KafkaListener(topics = "pr-events", groupId = "analysis-service")
    public void consume(GitHubPullRequestEvent event) {
        System.out.println("Received PR event: " + event);
        service.createAnalysisJob(event);
    }
}
