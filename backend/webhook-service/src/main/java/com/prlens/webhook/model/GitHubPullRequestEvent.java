package com.prlens.webhook.model;

public record GitHubPullRequestEvent(
        String repository,
        Integer pullRequestNumber,
        String action,
        String author
) {
}
