# SpringBootCRUDApplication
This project is a Spring Boot-based CRUD (Create, Read, Update, Delete) application demonstrating the basic operations on a database using Spring Data JPA, Hibernate, and a RESTful web service. The application is designed to be simple yet effective for learning and implementing CRUD operations in a Spring framework.

Features
Spring Boot: Simplifies the configuration and setup of the Spring application.
Spring Data JPA: Provides easy integration with JPA repositories and database operations.
Hibernate: Handles ORM (Object-Relational Mapping) for database entities.
RESTful API: Exposes endpoints for CRUD operations.

Endpoints
GET /students/: Retrieve a list of all entities.
GET /students/{id}: Retrieve a single entity by its ID.
POST /students/addstudent: Create a new entity.
PUT /students/update/{id}: Update an existing entity by its ID.
DELETE /students/delete/{id}: Delete an entity by its ID.

Technologies Used
Java 17
Spring Boot
Spring Data JPA
Hibernate
MySQL 
Maven
