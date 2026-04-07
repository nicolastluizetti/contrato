Contrato API

API REST desenvolvida em Java com Spring Boot para gerenciamento de contratos, permitindo o cadastro, consulta, atualização e remoção de contratos e entidades relacionadas.

Este projeto foi desenvolvido com foco em boas práticas de arquitetura, organização em camadas e uso de tecnologias modernas do ecossistema Spring.

1)Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de Dados Relacional (H2/MySQL/PostgreSQL)
- Maven
- Lombok
- Jakarta Validation
- REST API
- DTO Pattern
- Exception Handling Global
- sts

2)Estrutura do Projeto

O projeto segue uma arquitetura em camadas, separando responsabilidades para facilitar manutenção e escalabilidade.

 Como Executar o Projeto

Pré-requisitos

- Java 17+
- Maven
- IDE (IntelliJ,VS Code, STS)


3)Endpoints Principais

Clientes
POST   /clientes
GET    /clientes
GET    /clientes/{id}
PUT    /clientes/{id}
DELETE /clientes/{id}

Contratos
POST   /contratos
GET    /contratos
GET    /contratos/{id}
PUT    /contratos/{id}
DELETE /contratos/{id}


```bash
#Clonar o repositório
git clone https://github.com/nicolastluizetti/contrato.git

# Acessar a pasta
cd contrato

# Executar o projeto
mvn spring-boot:run

Desenvolvedor Backend Java | Spring Boot
linkedin: www.linkedin.com/in/nicolas-thomas-luizetti
