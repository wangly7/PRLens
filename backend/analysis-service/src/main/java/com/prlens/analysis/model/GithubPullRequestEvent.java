package com.prlens.analysis.model;

public record GithubPullRequestEvent(
    String repository,
    Integer pullRequestNumber,
    String action,
    String author
) {
}
