package com.prlens.codingagent.service;

import com.prlens.codingagent.producer.PullRequestEventProducer;
import com.prlens.common.enums.PullRequestEventType;
import com.prlens.common.events.CodingJobEvent;
import com.prlens.common.events.PullRequestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class CodingAgentService {
    private final PullRequestEventProducer pullRequestEventProducer;

    public void execute(CodingJobEvent event) {
        Path designDocPath = Path.of(event.designDocPath());

        if (!Files.exists(designDocPath)) {
            throw new IllegalStateException(
                    "Design document does not exist: " + designDocPath
            );
        }
        log.info(
                "Starting coding job. jobId={}, issueId={}, designDocPath={}, targetBranch={}",
                event.jobId(),
                event.issueId(),
                event.designDocPath(),
                event.targetBranch()
        );

        String branchName = "ai/isssue-" + event.eventId();

        PullRequestEvent pullRequestEvent = new PullRequestEvent(
                UUID.randomUUID().toString(),
                event.issueId(),
                event.repository(),
                1,
                "https://github.com/example/example/pull/1",
                branchName,
                PullRequestEventType.OPENED,
                "coding-agent"
        );
        pullRequestEventProducer.publish(pullRequestEvent);
        log.info(
                "Completed mock coding job. jobId={}, issueId={}, branchName={}",
                event.jobId(),
                event.issueId(),
                branchName
        );
    }
}
