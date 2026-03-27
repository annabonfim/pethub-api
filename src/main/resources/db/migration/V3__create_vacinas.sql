CREATE TABLE vacinas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_aplicacao DATE NOT NULL,
    proxima_dose DATE,
    observacoes TEXT,
    pet_id BIGINT NOT NULL REFERENCES pets(id)
);