# SalesSavvy Backend Project Documentation

## 1. Project Overview
SalesSavvy is a sales management application designed to help businesses track sales, manage products, and analyze performance through a user-friendly interface. The backend provides APIs to handle user authentication, product management, sales tracking, and reporting functionalities.

## 2. Technology Stack
- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Token)
- **Server**: Apache Tomcat
- **Version Control**: Git & GitHub
- **Build Tool**: Maven
- **Deployment**: AWS (EC2, RDS)

## 3. Architecture
SalesSavvy follows a **RESTful API** architecture with the following components:
- **Controller Layer**: Handles API requests.
- **Service Layer**: Business logic implementation.
- **Repository Layer**: Database interactions using JPA/Hibernate.
- **Security Layer**: Handles authentication and authorization.

## 4. API Endpoints

### Authentication
- **POST /api/auth/register** - Register a new user
- **POST /api/auth/login** - Authenticate user and return JWT

### User Management
- **GET /api/users/profile** - Get user profile
- **PUT /api/users/profile** - Update user profile

### Product Management
- **POST /api/products** - Add a new product
- **GET /api/products** - Retrieve all products
- **GET /api/products/{id}** - Retrieve product details
- **PUT /api/products/{id}** - Update product details
- **DELETE /api/products/{id}** - Delete a product

### Sales Management
- **POST /api/sales** - Record a sale
- **GET /api/sales** - Retrieve all sales records
- **GET /api/sales/{id}** - Retrieve specific sales record
- **PUT /api/sales/{id}** - Update sales record
- **DELETE /api/sales/{id}** - Delete a sales record

### Reporting
- **GET /api/reports/sales-summary** - Get sales summary report
- **GET /api/reports/top-products** - Get top-selling products

## 5. Database Schema
### Tables:
- **Users** (id, name, email, password, role)
- **Products** (id, name, description, price, stock_quantity)
- **Sales** (id, product_id, user_id, quantity, total_price, timestamp)

## 6. Security Implementation
- **JWT-based Authentication**: Users must authenticate to access protected routes.
- **Role-based Authorization**: Different roles (Admin, Salesperson) control access to resources.
- **Password Hashing**: User passwords are securely stored using BCrypt.

## 7. Error Handling
- Standardized error responses with HTTP status codes.
- Custom exceptions for validation, authentication, and database errors.

## 8. Deployment and Environment Configuration
- **Development**: Local setup using Spring Boot and MySQL.
- **Production**: Hosted on AWS EC2, database on AWS RDS.
- **Environment Variables**: API keys, database credentials managed securely.

## 9. Future Enhancements
- Implement AI-based sales insights.
- Integrate third-party payment gateways.
- Develop a mobile app integration.

## 10. Conclusion
SalesSavvy's backend is designed for scalability, security, and maintainability. It provides a structured API to manage sales efficiently while ensuring a smooth user experience.

---

**Author**: SalesSavvy Development Team  
**Version**: 1.0  
**Date**: February 2025

Structure of the File 
![Screenshot (194)](https://github.com/user-attachments/assets/e7533789-e8f0-4456-a402-4ab683abf393)
