CREATE TABLE scan_jobs
(
    id UUID PRIMARY KEY,

    project_id UUID NOT NULL,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL
);