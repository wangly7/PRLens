package com.prlens.workflow.producer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.DocJobEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocJobProducer {
    private final KafkaTemplate<String, DocJobEvent> kafkaTemplate;

    public DocJobProducer(KafkaTemplate<String, DocJobEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DocJobEvent event) {
        kafkaTemplate.send(
                KafkaTopics.DOC_JOBS,
                event.jobId(),
                event
        );
    }
}
