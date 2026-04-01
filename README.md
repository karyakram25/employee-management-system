# Employee Management System (EMS)

A Spring Boot based REST API project that manages employee data with secure authentication and well-documented endpoints.

---

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Spring Security (JWT Authentication)
* Swagger (OpenAPI Documentation)

---

## ✨ Features

* Create, Read, Update, Delete (CRUD) Employee
* DTO Layer for clean architecture
* Pagination and Sorting
* Logging using SLF4J
* Secure APIs using JWT Authentication
* Interactive API testing using Swagger UI

---

## 🔐 Authentication Flow (JWT)

1. User logs in using `/api/auth/login`
2. Receives JWT token
3. Token is used in Authorization header:

   ```
   Authorization: Bearer <token>
   ```
4. Access secured endpoints

---

## 📌 API Endpoints

### 🔓 Public APIs

* `POST /api/auth/login` → Generate JWT Token

### 🔐 Protected APIs

* `GET /api/v1/employees` → Get all employees (with pagination)
* `GET /api/v1/employees/{id}` → Get employee by ID
* `POST /api/v1/employees` → Create employee
* `PUT /api/v1/employees/{id}` → Update employee
* `DELETE /api/v1/employees/{id}` → Delete employee

---

## 📄 Pagination Example

```
GET /api/v1/employees?page=0&size=5&sortBy=firstName&sortDir=asc
```

---

## 📘 Swagger UI

Access API documentation here:

```
http://localhost:8080/swagger-ui/index.html
```

👉 Use **Authorize button** and enter JWT token (without "Bearer")

---

## ⚙️ How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the application
4. Use Postman or Swagger to test APIs

---
