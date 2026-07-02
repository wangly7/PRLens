package com.prlens.common.events;

import com.prlens.common.enums.DocJobType;

public record DocJobEvent(
        String jobId,
        String issueId,
        String title,
        String description,
        String repository,
        DocJobType jobType
) {
}
