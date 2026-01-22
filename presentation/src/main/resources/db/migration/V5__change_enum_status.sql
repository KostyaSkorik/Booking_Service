ALTER TABLE bookings
DROP
COLUMN status;

ALTER TABLE bookings
    ADD status VARCHAR(255) NOT NULL;