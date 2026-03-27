CREATE TABLE consultas (
    id BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    veterinario VARCHAR(100),
    motivo VARCHAR(255),
    observacoes TEXT,
    peso DECIMAL(5,2),
    pet_id BIGINT NOT NULL REFERENCES pets(id)
);