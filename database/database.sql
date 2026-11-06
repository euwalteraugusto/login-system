-- Senhas armazenadas como hash PBKDF2WithHmacSHA256, formato "iteracoes$salt$hash".
-- Os hashes abaixo foram gerados por tools/GerarHash.java (security.PasswordHasher).
-- Para gerar o hash de um novo usuário: java -cp out GerarHash <senha>
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

INSERT INTO users (username, password)
VALUES
('admin', '600000$J+QHj74lVKJts0Hz8BUFnA==$SfC4LSdeEf472LhBsuYGHQnASqOdwYdB4d9b4i1yhXQ='),
('walter', '600000$QCvSa/Dz8KSkmmd9Iog9Eg==$W1H2pREtFP8koZHfrAKY9LFHVbFDZiOgbj66SuynZo8='),
('luana', '600000$nhqQqwAUL1rDkPQD+t5L0w==$l99I9UqoCSbyhLdwf1KG9nGlDHwOIQ8qVqafmE2XLuI='),
('pedro', '600000$Xy+JGHkBkADDSI8moD7V2A==$YVlIPdKGlihZzBwpqfj42oCqXFZgeIMAO4q85uzBrPs='),
('gabriel', '600000$KQbhGKVVOMPNFVDN+2PYHw==$JaJcZw3uLcHbMTbXUNflmDoIR3LfVl9+IFQUlgQpUKo=');
