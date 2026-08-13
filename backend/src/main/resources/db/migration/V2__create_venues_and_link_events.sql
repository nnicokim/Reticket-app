CREATE TABLE venue (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       city VARCHAR(255) NOT NULL,
                       capacity INTEGER NOT NULL
);

ALTER TABLE event
    ADD COLUMN venue_id BIGINT;

ALTER TABLE event
    ADD CONSTRAINT fk_event_venue
        FOREIGN KEY (venue_id)
            REFERENCES venue(id);