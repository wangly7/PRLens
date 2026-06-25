package com.prlens.webhook.service;

import com.prlens.common.events.GitHubPullRequestEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GitHubWebHookService {
    private final KafkaTemplate<String, GitHubPullRequestEvent> kafkaTemplate;

    public GitHubWebHookService(KafkaTemplate<String, GitHubPullRequestEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void handlePullRequestEvent(GitHubPullRequestEvent event) {
        kafkaTemplate.send("pr-events", event.repository(), event);
    }
}
