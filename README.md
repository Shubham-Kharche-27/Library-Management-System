# 📚 Library Management System (Spring Boot)

A comprehensive Library Management System built with Spring Boot that handles books, authors, publishers, and categories. This application demonstrates the use of entity relationships, DTOs with ModelMapper, global exception handling, and full CRUD operations.

---

## 🚀 Features

- 📘 Manage Books (CRUD)
- ✍️ Manage Authors and their books (One-to-Many)
- 🏢 Manage Publishers and their books (One-to-Many)
- 🏷️ Manage Categories (Many-to-Many with Books)
- 🧩 Entity relationships mapped using JPA
- 🔁 DTOs with ModelMapper for clean API responses
- ❌ Custom and Global Exception Handling
- 🧪 Fully tested CRUD operations

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- ModelMapper
- MySQL
- Maven
- RESTful APIs

---

## 🧱 Entity Relationships

- **Author - Book**: One-to-Many
- **Publisher - Book**: One-to-Many
- **Book - Category**: Many-to-Many

---
## 📁 API Endpoints (Sample)

### 📘 Book
- `POST /book/post`
- `GET /book/get`
- `GET /book/get/byId{bookId}`
- `PUT /book/{bookId}`
- `DELETE /books/{bookId}`

### ✍️ Author
- `POST /author/post`
- `GET /author/get`
- `GET /author/get/byId/{bookId}`
- `PUT /author/{bookId}`
- `DELETE /author/{bookId}`

### 🏢 Publisher
- `POST /publisher/post`
- `GET /publisher/get`
- `GET /publisher/get/byId/{bookId}`
- `PUT /publisher/{bookId}`
- `DELETE /publisher/{bookId}`

### 🏷️ Category
- `POST /category/post`
- `GET /category/get`
- `GET /category/get/byId/{bookId}`
- `PUT /category/{bookId}`
- `DELETE /category/{bookId}`

---
## 🛠️ Setup Instructions

```bash
# 1️⃣ Clone the Repository
git clone https://github.com/your-username/library-management-system.git
cd library-management-system

# 2️⃣ Configure MySQL
# Open MySQL and run:
CREATE DATABASE library_management_system;

# Then update src/main/resources/application.properties:
# ----------------------------------------
# spring.datasource.url=jdbc:mysql://localhost:3306/library_management_system
# spring.datasource.username=your_mysql_username
# spring.datasource.password=your_mysql_password
# spring.jpa.hibernate.ddl-auto=update
# spring.jpa.show-sql=true
# spring.jpa.properties.hibernate.format_sql=true
# ----------------------------------------

# 3️⃣ Build the Project
mvn clean install

# 4️⃣ Run the Application
mvn spring-boot:run

# ✅ App will start on: http://localhost:8080
