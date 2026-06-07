CREATE TABLE projects
(
    id UUID PRIMARY KEY,

    name VARCHAR(255) NOT NULL,

    repository_url VARCHAR(500) NOT NULL,

    owner_email VARCHAR(255) NOT NULL,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL
);