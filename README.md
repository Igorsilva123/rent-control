# Sistema de Controle de Aluguéis

Um sistema de gerenciamento de aluguéis de imóveis, permitindo o cadastro de usuários, autenticação via JWT, criação de casas por proprietários (owners) e associação de inquilinos (tenants) às casas.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Security com JWT
- Hibernate Validator
- MySQL
- Flyway (para versionamento do banco de dados)
- Lombok
- Maven

---

## Funcionalidades

### Usuário
- Registro de usuários com validação de dados.
- Login com autenticação JWT.
- Perfis diferenciados: Owner (dono da casa) e Tenant (inquilino).

### Casas
- Criação de casas pelo Owner.
- Consulta e gerenciamento das casas cadastradas.
- Associação de inquilinos às casas.

### Segurança
- Proteção de endpoints via Spring Security.
- Tokens JWT para autenticação sem estado (stateless).
- Hash de senhas com BCrypt.

---

## Estrutura do Projeto

