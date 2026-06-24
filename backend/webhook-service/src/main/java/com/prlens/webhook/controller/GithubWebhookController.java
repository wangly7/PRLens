package com.prlens.webhook.controller;

import com.prlens.webhook.service.GitHubWebHookService;
import com.prlens.webhook.model.GitHubPullRequestEvent;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhooks/github")
public class GithubWebhookController {
    private final GitHubWebHookService gitHubWebHookService;

    public GithubWebhookController(GitHubWebHookService gitHubWebHookService) {
        this.gitHubWebHookService = gitHubWebHookService;
    }

    @PostMapping
    public String receiveWebhook(@RequestBody GitHubPullRequestEvent event) {
        gitHubWebHookService.handlePullRequestEvent(event);
        return "ok";
    }
}
