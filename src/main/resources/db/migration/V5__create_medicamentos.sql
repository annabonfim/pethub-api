CREATE TABLE medicamentos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dose VARCHAR(100),
    frequencia VARCHAR(100),
    data_inicio DATE,
    data_fim DATE,
    pet_id BIGINT NOT NULL REFERENCES pets(id)
);