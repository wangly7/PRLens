package com.prlens.docagent.service;

import com.prlens.common.enums.DocJobType;
import com.prlens.common.events.DocJobEvent;
import com.prlens.docagent.agents.DesignDocAgent;
import org.springframework.stereotype.Service;

@Service
public class DocAgentDispatcher {
    private final DesignDocAgent designDocAgent;

    public DocAgentDispatcher(DesignDocAgent designDocAgent) {
        this.designDocAgent = designDocAgent;
    }

    public void handle(DocJobEvent event) {
        if (event.jobType() == DocJobType.DESIGN_DOC) {
            this.designDocAgent.generate(event);
        }
    }
}
