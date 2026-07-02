package com.prlens.issue.service;

import com.prlens.common.events.IssueCreatedEvent;
import com.prlens.issue.dto.CreateIssueRequest;
import com.prlens.issue.producer.IssueEventProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IssueService {

    private final IssueEventProducer issueEventProducer;

    public IssueService(IssueEventProducer issueEventProducer) {
        this.issueEventProducer = issueEventProducer;
    }

    public IssueCreatedEvent createdEvent(CreateIssueRequest request) {
        String issueId = UUID.randomUUID().toString();
        String eventId = UUID.randomUUID().toString();

        IssueCreatedEvent event = new IssueCreatedEvent(
                eventId,
                issueId,
                request.title(),
                request.description(),
                request.repository(),
                request.createdBy()
        );

        issueEventProducer.publish(event);
        return  event;
    }
}
