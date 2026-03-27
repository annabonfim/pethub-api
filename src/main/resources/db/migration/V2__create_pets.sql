CREATE TABLE pets (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(20) NOT NULL,
    raca VARCHAR(100),
    data_nascimento DATE,
    user_id BIGINT NOT NULL REFERENCES users(id)
);