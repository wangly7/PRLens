package com.prlens.common.events;

import com.prlens.common.enums.AnalysisJobType;

public record AnalysisJobEvent(
        String repository,
        Integer pullRequestNumber,
        AnalysisJobType jobType
) {
}
