package com.prlens.workflow.producer;

import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.ReviewJobEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReviewJobProducer {
    public final KafkaTemplate<String, ReviewJobEvent> kafkaTemplate;

    public void publish(ReviewJobEvent event) {
        kafkaTemplate.send(KafkaTopics.REVIEW_JOBS, event.issueId(), event);
    }
}
