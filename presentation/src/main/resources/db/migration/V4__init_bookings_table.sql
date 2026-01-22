CREATE TABLE bookings
(
    id           UUID     NOT NULL,
    user_id      UUID     NOT NULL,
    coworking_id UUID     NOT NULL,
    start_time   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_time     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    status       SMALLINT NOT NULL,
    total_price  DECIMAL  NOT NULL,
    version      BIGINT   NOT NULL,
    CONSTRAINT pk_bookings PRIMARY KEY (id)
);

ALTER TABLE bookings
    ADD CONSTRAINT FK_BOOKINGS_ON_COWORKING FOREIGN KEY (coworking_id) REFERENCES coworkings (id);