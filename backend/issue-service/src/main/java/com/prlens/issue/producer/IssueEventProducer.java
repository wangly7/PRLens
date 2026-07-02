package com.prlens.issue.producer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.IssueCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class IssueEventProducer {

    private final KafkaTemplate<String, IssueCreatedEvent> kafkaTemplate;

    public IssueEventProducer(KafkaTemplate<String, IssueCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(IssueCreatedEvent event) {
        kafkaTemplate.send(KafkaTopics.ISSUE_EVENTS, event.issueId(), event);
    }
}
