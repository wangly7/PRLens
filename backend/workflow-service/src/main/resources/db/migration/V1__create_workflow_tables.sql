CREATE table workflow_executions (
    id UUID PRIMARY KEY,
    issue_id UUID NOT NULL UNIQUE,
    status VARCHAR(50) NOT NULL,
    current_step VARCHAR(50) NOT NULL,
    started_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    completed_at TIMESTAMPTZ
);


CREATE table workflow_steps (
    id UUID PRIMARY KEY,
    workflow_execution_id UUID NOT NULL,
    step_type VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    started_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    completed_at TIMESTAMPTZ,
    error_message TEXT,

    constraint fk_workflow_execution
        FOREIGN KEY (workflow_execution_id)
        REFERENCES workflow_executions(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_workflow_steps_execution_status
    ON workflow_steps(workflow_execution_id, status);