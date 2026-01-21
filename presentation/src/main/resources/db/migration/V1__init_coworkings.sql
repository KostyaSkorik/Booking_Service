-- 1. Создание таблицы коворкингов
CREATE TABLE coworkings
(
    id             UUID PRIMARY KEY,
    name           VARCHAR(255)      NOT NULL,
    description    TEXT,
    capacity       INTEGER           NOT NULL,
    type           VARCHAR(50)       NOT NULL,
    image_key      VARCHAR(255),
    is_active      BOOLEAN DEFAULT TRUE,
    price_per_hour NUMERIC(19, 2)    NOT NULL,
    version        BIGINT  DEFAULT 0 NOT NULL
);

-- 2. Добавление 10 тестовых коворкингов
INSERT INTO coworkings (id, name, description, capacity, type, image_key, is_active, price_per_hour, version)
VALUES (gen_random_uuid(), 'Smart Space', 'Quiet office in the city center', 10, 'OFFICE', '1.png', true, 500.00, 0),
       (gen_random_uuid(), 'Open Minds', 'Creative hub for freelancers', 25, 'OPEN_SPACE', '2.png', true, 200.00, 0),
       (gen_random_uuid(), 'Tech Bunker', 'High-speed internet and dark theme', 15, 'OFFICE', '3.png', true, 450.00, 0),
       (gen_random_uuid(), 'Green Garden', 'Eco-friendly coworking with plants', 30, 'OPEN_SPACE', '4.png', true,
        300.00, 0),
       (gen_random_uuid(), 'Sky Lounge', 'Panoramic view on the 50th floor', 12, 'LOUNGE', '5.png', true, 800.00, 0),
       (gen_random_uuid(), 'Focus Pod', 'Small pods for deep work', 5, 'POD', '6.png', true, 150.00, 0),
       (gen_random_uuid(), 'Meeting Point', 'Best for team meetings', 20, 'CONFERENCE_ROOM', '7.png', true, 1000.00, 0),
       (gen_random_uuid(), 'Startup Hub', 'Networking and coffee included', 40, 'OPEN_SPACE', '8.png', true, 250.00, 0),
       (gen_random_uuid(), 'Cyber Zone', 'Perfect for developers', 18, 'OFFICE', '9.png', true, 400.00, 0),
       (gen_random_uuid(), 'Quiet Corner', 'Library-like atmosphere', 10, 'OPEN_SPACE', '10.png', true, 180.00, 0);