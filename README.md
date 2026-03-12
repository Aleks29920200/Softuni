# softuniProjects

☕ Coffee Shop Web Application
A full-stack Java web application built with Spring Boot, designed to manage orders in a small cafe environment. This project demonstrates the core principles of the Spring MVC framework, data persistence with JPA, and server-side validation.

🚀 Features
User Authentication: Secure Registration and Login system using session-based authentication.

Order Management: * Add new orders with specific categories (Coffee, Cake, Drink, Other).

Track orders by "Estimated Time" and "Price".

Mark orders as "Ready" to remove them from the active list.

Real-time Dashboard: * View all active orders categorized by type.

Total sum of all active orders displayed on the home page.

Employee-specific order tracking.

Database Seeding: Automatic population of categories upon application startup.

🛠️ Tech Stack
Backend: Java 11/17, Spring Boot 2.x

Data Access: Spring Data JPA, Hibernate, MySQL

Template Engine: Thymeleaf, HTML5, CSS3

Validation: Hibernate Validator (Bean Validation)

Security: Custom Session Interceptors / Password Hashing

🏗️ Architecture
The project follows a standard Layered Architecture to ensure clean code and separation of concerns:

web: Contains Controllers that handle HTTP requests and return Thymeleaf views.

service: Holds the business logic and coordinates data between the web and repository layers.

repository: Interfaces extending JpaRepository for database CRUD operations.

model:

Entities: Database-mapped objects (User, Order, Category).

DTOs/BindingModels: Data transfer objects for input validation and view rendering.

init: Contains CommandLineRunner for database initialization.

📋 Database Schema
The application uses a relational database structure:

Users: Stores credentials and links to orders.

Orders: Contains order details, linked to a specific category and the user who took the order.

Categories: A predefined list of types (Coffee, Cake, Drink, Other).

🔧 Setup & Installation
Clone the repository:

Bash
git clone https://github.com/Aleks29920200/Softuni.git
cd Softuni/PrepForSpringFundamentals/coffee_shop1
Configure Database:

Open src/main/resources/application.properties.

Update the spring.datasource.username and spring.datasource.password to match your local MySQL settings.

Create a schema named coffee_shop in your MySQL Workbench.

Build and Run:

Run the application through your IDE or via terminal:

Bash
mvn spring-boot:run
Access the app:

Open http://localhost:8080 in your browser.
