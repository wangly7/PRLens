package com.prlens.docagent.consumer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.DocJobEvent;
import com.prlens.docagent.service.DocAgentDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocJobConsumer {
    private final DocAgentDispatcher docAgentDispatcher;

    public DocJobConsumer(DocAgentDispatcher docAgentDispatcher) {
        this.docAgentDispatcher = docAgentDispatcher;
    }

    @KafkaListener(
            topics = KafkaTopics.DOC_JOBS,
            groupId = "doc-agent"
    )
    public void consume(DocJobEvent event) {
        log.info(
                "Received DocJobEvent. jobId={}, issueId={}, jobTye={}",
                event.jobId(), event.issueId(), event.jobType()
        );

        this.docAgentDispatcher.handle(event);
    }
}