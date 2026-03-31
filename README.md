# Employee Management System (EMS)

A Spring Boot based Employee Management System that provides REST APIs to perform CRUD operations on employee data.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Spring Security
* Maven

## Features

* Create, Read, Update, Delete (CRUD) Employee
* DTO Layer (Clean API structure)
* Pagination & Sorting
* Logging using SLF4J
* Global Exception Handling
* Spring Security (Basic Authentication)
* Role-based Access Control (USER, ADMIN)

## API Endpoints

- GET /api/v1/employees → Get all employees
- GET /api/v1/employees/{id} → Get employee by ID
- POST /api/v1/employees → Create employee
- PUT /api/v1/employees/{id} → Update employee
- DELETE /api/v1/employees/{id} → Delete employee

## How to Run

1. Clone the repository
2. Open project in IntelliJ
3. Configure MySQL in application.properties
4. Run the main application class
