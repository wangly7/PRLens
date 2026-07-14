package com.prlens.codingagent.consumer;


import com.prlens.codingagent.service.CodingAgentService;
import com.prlens.common.constants.KafkaTopics;
import com.prlens.common.events.CodingJobEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodingJobConsumer {
    public final CodingAgentService codingAgentService;

    @KafkaListener(
            topics = KafkaTopics.CODING_JOBS,
            groupId = "coding-agent"
    )
    public void consume(CodingJobEvent event) {
        log.info(
                "Received CodingJobEvent. eventId={}, jobId={}, issueId={}, repository={}",
                event.eventId(),
                event.jobId(),
                event.issueId(),
                event.repository()
        );
        codingAgentService.execute(event);
    }

}
