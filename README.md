<<<<<<< HEAD
# 📞 **Phonebook API**
**English** | **Português**

---

## 🇺🇸 **English**

### 📝 **Overview**  
The **Phonebook API** is a RESTful web service built using **Spring Boot** to manage phonebook contacts. It supports basic CRUD operations: **Create, Read, Update,** and **Delete**. The API uses **Lombok** for simplifying Java code, **Flyway** for database migrations, and **JPA/Hibernate** for database interaction. **Docker** is used to containerize the application, and **MySQL** serves as the database.

---

### 🛠️ **Technologies Used**

- **Spring Boot**: To create the REST API.
- **Lombok**: To reduce boilerplate code.
- **Flyway**: To handle database migrations.
- **JPA & Hibernate**: To manage database entities.
- **Docker**: To containerize the application.
- **MySQL**: As the relational database.

---

### 🚀 **How to Run**

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/phonebook-api.git
   cd phonebook-api

    
    mvn clean install

    docker-compose up -d

    mvn spring-boot:run


🗂️ **Endpoints**
- **GET** `/contacts`: Retrieve all contacts.
- **POST** `/contacts`: Add a new contact.
- **PUT** `/contacts/{id}`: Update an existing contact.
- **DELETE** `/contacts/{id}`: Delete a contact by ID.

🛠️ **Environment Variables**
- `DB_URL`:     The database connection URL.
- `DB_USERNAME`: The username for the database.
- `DB_PASSWORD`: The password for the database.

🔧 **Database Migration**
The project uses **Flyway** to manage database versioning and migrations. Any new database changes can be added to the `src/main/resources/db/migration` folder as `.sql` files, and Flyway will automatically apply them on application startup.


🇧🇷 **Português**

📝 **Visão Geral**  
A **Phonebook API** é um serviço web RESTful construído com **Spring Boot** para gerenciar contatos de uma lista telefônica. Suporta operações básicas de CRUD: Criar, Ler, Atualizar e Deletar. A API usa **Lombok** para simplificar o código Java, **Flyway** para migrações de banco de dados e **JPA/Hibernate** para interações com o banco de dados. **Docker** é utilizado para containerizar a aplicação e o **MySQL** serve como banco de dados.

---

🛠️ **Tecnologias Usadas**
- **Spring Boot**: Para criar a API REST.
- **Lombok**: Para reduzir código repetitivo.
- **Flyway**: Para lidar com migrações do banco de dados.
- **JPA & Hibernate**: Para gerenciar as entidades do banco de dados.
- **Docker**: Para containerizar a aplicação.
- **MySQL**: Como banco de dados relacional.

---

🚀 **Como Executar**

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/phonebook-api.git
   cd phonebook-api

    mvn clean install

    docker-compose up -d

    mvn spring-boot:run

    🗂️ **Endpoints**
- **GET** `/contacts`: Retorna todos os contatos.
- **POST** `/contacts`: Adiciona um novo contato.
- **PUT** `/contacts/{id}`: Atualiza um contato existente.
- **DELETE** `/contacts/{id}`: Deleta um contato pelo ID.

🛠️ **Variáveis de Ambiente**
- `DB_URL`: A URL de conexão com o banco de dados.
- `DB_USERNAME`: O nome de usuário do banco de dados.
- `DB_PASSWORD`: A senha do banco de dados.

🔧 **Migração do Banco de Dados**  
O projeto usa **Flyway** para gerenciar versionamento e migrações do banco de dados. Novas alterações no banco de dados podem ser adicionadas à pasta `src/main/resources/db/migration` como arquivos `.sql`, e o Flyway aplicará automaticamente durante a inicialização da aplicação.


=======
📞 Phonebook API
English | Português

🇺🇸 English
📝 Overview
The Phonebook API is a RESTful web service built using Spring Boot to manage phonebook contacts. It supports basic CRUD operations: Create, Read, Update, and Delete. The API uses Lombok for simplifying Java code, Flyway for database migrations, and JPA/Hibernate for database interaction. Docker is used to containerize the application and MySQL serves as the database.
>>>>>>> e127eb00c0310a2ca822aed3bc94a673c9cf251a
