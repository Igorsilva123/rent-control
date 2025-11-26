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

src/main/java
├── com.example.aluguel
│ ├── controller # Endpoints REST
│ ├── dto # Data Transfer Objects
│ ├── entities # Entidades JPA (User, House, Tenant)
│ ├── repository # Interfaces de repositório JPA
│ ├── infra/security # Configuração de JWT e SecurityFilter
│ ├── service # Lógica de negócio
│ └── Application.java # Classe principal 


## Configuração do Banco de Dados

- O projeto utiliza MySQL.
- Configuração no `application.properties` ou `application.yml`:
  
properties
spring.datasource.url=jdbc:mysql://localhost:3306/aluguel_db
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

Flyway é utilizado para versionamento do banco de dados e criação automática das tabelas.


Endpoints Principais
Usuários
Método	Endpoint	Descrição
POST	/auth/register	Registro de usuário
POST	/auth/login	Login com JWT
Casas
Método	Endpoint	Descrição
POST	/houses	Criar uma nova casa (Owner only)
GET	/houses	Listar casas cadastradas
POST	/houses/{id}/tenants	Associar inquilino à casa


JWT expira em 2 horas (configurável em TokenService).

Senhas são armazenadas de forma segura usando BCrypt.

Diferencie perfis de usuário (Owner e Tenant) para restringir funcionalidades.
