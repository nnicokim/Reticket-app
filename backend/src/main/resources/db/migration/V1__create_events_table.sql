CREATE TABLE event (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       venue VARCHAR(255) NOT NULL,
                       city VARCHAR(255) NOT NULL,
                       date TIMESTAMP NOT NULL,
                       category VARCHAR(50) NOT NULL
);