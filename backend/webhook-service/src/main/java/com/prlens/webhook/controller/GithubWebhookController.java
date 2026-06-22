package com.prlens.webhook.controller;

import com.prlens.webhook.model.GitHubPullRequestEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook/github")
public class GithubWebhookController {
    private final KafkaTemplate<String, GitHubPullRequestEvent> kafkaTemplate;

    public GithubWebhookController(KafkaTemplate<String, GitHubPullRequestEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String receiveWebhook(@RequestBody GitHubPullRequestEvent event) {
        kafkaTemplate.send("pr-events", event.repository(), event);
        return  "ok";
    }
}
