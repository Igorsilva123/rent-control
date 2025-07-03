CREATE TABLE tenants (
    id_tenants BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    rented_at DATE,
    PRIMARY KEY (id_tenants)
);
