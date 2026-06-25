package com.prlens.common.events;

public record GitHubPullRequestEvent(
    String repository,
    Integer pullRequestNumber,
    String action,
    String author
) {
}
