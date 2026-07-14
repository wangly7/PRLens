package com.prlens.workflow.service;

import com.prlens.common.enums.DocJobType;
import com.prlens.common.events.*;
import com.prlens.workflow.producer.CodingJobProducer;
import com.prlens.workflow.producer.DocJobProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class WorkflowOrchestrator {
    public final DocJobProducer docJobProducer;
    public final CodingJobProducer codingJobProducer;

    public WorkflowOrchestrator(
            DocJobProducer docJobProducer,
            CodingJobProducer codingJobProducer) {
        this.docJobProducer = docJobProducer;
        this.codingJobProducer = codingJobProducer;
    }

    public void handleIssueCreated(IssueCreatedEvent event) {
        DocJobEvent job = new DocJobEvent(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                event.issueId(),
                event.title(),
                event.description(),
                event.repository(),
                DocJobType.DESIGN_DOC
        );
        this.docJobProducer.publish(job);
    }

    public void handleArtifactGenerated(ArtifactGeneratedEvent event) {
        CodingJobEvent codingJobEvent = new CodingJobEvent(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                event.issueId(),
                event.repository(),
                event.storagePath(),
                "main"
        );
        log.info(
                "Dispatching coding job. eventId={}, jobId={}, issueId={}, designDocPath={}",
                codingJobEvent.eventId(),
                codingJobEvent.jobId(),
                codingJobEvent.issueId(),
                codingJobEvent.designDocPath()
        );
        codingJobProducer.publish(codingJobEvent);
    }

    public void handlePullRequestEvent(PullRequestEvent event) {

    }
}
