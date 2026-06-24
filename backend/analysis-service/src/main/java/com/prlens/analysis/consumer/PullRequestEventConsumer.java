package com.prlens.analysis.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import  org.springframework.stereotype.Component;
import com.prlens.analysis.model.GithubPullRequestEvent;

@Component
public class PullRequestEventConsumer {

    @KafkaListener(topics = "pr-events", groupId = "analysis-service")
    public void consume(GithubPullRequestEvent event) {
        System.out.println("Received PR event: " + event);
    }
}
