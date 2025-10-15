CREATE TABLE houses (
    id BIGINT NOT NULL AUTO_INCREMENT,
    rent_value VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    uf CHAR(2) NOT NULL,
    cidade VARCHAR(100) NOT NULL,

    user_id BIGINT NOT NULL,
    tenant_id BIGINT,

    PRIMARY KEY(id),

    CONSTRAINT fk_houses_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_houses_tenant FOREIGN KEY (tenant_id) REFERENCES users(id)
);