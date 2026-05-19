CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

INSERT INTO users (username, password)
VALUES
('admin', '123456'),
('walter', 'walter123'),
('luana', 'luana123'),
('pedro', 'pedro123'),
('gabriel', 'gabriel123');