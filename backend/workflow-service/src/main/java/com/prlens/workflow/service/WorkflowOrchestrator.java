package com.prlens.workflow.service;

import com.prlens.common.enums.DocJobType;
import com.prlens.common.events.DocJobEvent;
import com.prlens.common.events.IssueCreatedEvent;
import com.prlens.workflow.producer.DocJobProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WorkflowOrchestrator {
    public final DocJobProducer producer;

    public WorkflowOrchestrator(DocJobProducer docJobProducer) {
        this.producer = docJobProducer;
    }

    public void handleIssueCreated(IssueCreatedEvent event) {
        DocJobEvent job = new DocJobEvent(
                UUID.randomUUID().toString(),
                event.issueId(),
                event.title(),
                event.description(),
                event.repository(),
                DocJobType.DESIGN_DOC
        );
        producer.publish(job);
    }
}
