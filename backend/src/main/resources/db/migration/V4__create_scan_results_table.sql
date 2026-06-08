CREATE TABLE scan_results
(
    id UUID PRIMARY KEY,

    scan_job_id UUID NOT NULL,

    title VARCHAR(255) NOT NULL,

    description VARCHAR(2000) NOT NULL,

    severity VARCHAR(50) NOT NULL
);