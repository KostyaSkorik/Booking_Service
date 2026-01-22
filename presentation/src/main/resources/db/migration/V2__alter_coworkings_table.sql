ALTER TABLE coworkings
ALTER
COLUMN description TYPE VARCHAR(255) USING (description::VARCHAR(255));

ALTER TABLE coworkings
    ALTER COLUMN is_active SET NOT NULL;

ALTER TABLE coworkings
ALTER
COLUMN price_per_hour TYPE DECIMAL USING (price_per_hour::DECIMAL);

ALTER TABLE coworkings
ALTER
COLUMN type TYPE VARCHAR(255) USING (type::VARCHAR(255));