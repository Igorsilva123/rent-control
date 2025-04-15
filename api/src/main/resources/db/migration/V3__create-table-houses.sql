create table houses(

    id_house bigint not null auto_increment,
    rent_value varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    primary key(id_house),

    owner_id BIGINT not null,
    CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES owners(id_owner),


    tenant_id BIGINT not null,
    CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES tenants(id_tenants)
);