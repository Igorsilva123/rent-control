# 🏠 API de Controle de Aluguéis

Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar aluguéis de imóveis. O sistema permite o cadastro de donos (proprietários), inquilinos e casas, além da associação entre casas, donos e inquilinos.

## 🚀 Tecnologias Utilizadas

- Java 21+  
- Spring Boot 3.x  
- Spring Data JPA  
- Spring Web  
- Banco de Dados: Mysql (pode ser facilmente adaptado para H2/MySQL/etc)  
- Lombok  
- Flyway (opcional, para versionamento do banco)  
- Swagger/OpenAPI (para documentação)

## 📦 Funcionalidades

- **Donos**
  - Cadastro, listagem, atualização e remoção
- **Inquilinos**
  - Cadastro, listagem, atualização e remoção
- **Casas**
  - Cadastro, listagem, atualização e remoção
  - Associação a um dono
  - Associação (ou troca) de inquilino

## 🔗 Relacionamentos

- Uma **casa** pertence a **um dono**
- Uma **casa** pode ter **um inquilino** (ou nenhum)
- Um **dono** pode possuir várias casas
- Um **inquilino** pode estar associado a **uma única casa**

## 🛠️ Como Rodar o Projeto

### Pré-requisitos

- Java 21+
- Maven
- Banco de dados Mysql ou similar

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/Igorsilva123/rent-control.git
   cd rent-control
