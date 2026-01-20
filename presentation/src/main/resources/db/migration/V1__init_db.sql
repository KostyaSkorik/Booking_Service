-- 1. Создание таблицы коворкингов
CREATE TABLE coworkings (
                            id UUID PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            capacity INTEGER NOT NULL,
                            type VARCHAR(50) NOT NULL, -- Для Enum Type (например, OFFICE, OPEN_SPACE)
                            image_key VARCHAR(255),
                            is_active BOOLEAN DEFAULT TRUE,
                            price_per_hour NUMERIC(19, 2) NOT NULL, -- BigDecimal мапится в NUMERIC
                            version BIGINT DEFAULT 0 NOT NULL
);

-- 2. Добавление 10 тестовых коворкингов
INSERT INTO coworkings (id, name, description, capacity, type, is_active, price_per_hour, version)
VALUES
    (gen_random_uuid(), 'Smart Space', 'Quiet office in the city center', 10, 'OFFICE', true, 500.00, 0),
    (gen_random_uuid(), 'Open Minds', 'Creative hub for freelancers', 25, 'OPEN_SPACE', true, 200.00, 0),
    (gen_random_uuid(), 'Tech Bunker', 'High-speed internet and dark theme', 15, 'OFFICE', true, 450.00, 0),
    (gen_random_uuid(), 'Green Garden', 'Eco-friendly coworking with plants', 30, 'OPEN_SPACE', true, 300.00, 0),
    (gen_random_uuid(), 'Sky Lounge', 'Panoramic view on the 50th floor', 12, 'LOUNGE', true, 800.00, 0),
    (gen_random_uuid(), 'Focus Pod', 'Small pods for deep work', 5, 'POD', true, 150.00, 0),
    (gen_random_uuid(), 'Meeting Point', 'Best for team meetings', 20, 'CONFERENCE_ROOM', true, 1000.00, 0),
    (gen_random_uuid(), 'Startup Hub', 'Networking and coffee included', 40, 'OPEN_SPACE', true, 250.00, 0),
    (gen_random_uuid(), 'Cyber Zone', 'Perfect for developers', 18, 'OFFICE', true, 400.00, 0),
    (gen_random_uuid(), 'Quiet Corner', 'Library-like atmosphere', 10, 'OPEN_SPACE', true, 180.00, 0);