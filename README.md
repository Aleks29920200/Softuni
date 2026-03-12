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

🛒 Shopping List Web Application
A full-stack Java web application built with Spring Boot, designed to manage household shopping lists. This project was developed as part of the Spring Fundamentals course at SoftUni, focusing on CRUD operations, database relationships, and web security.

🚀 Features
User Authentication: * Secure Registration and Login functionality.

Access control logic to protect shopping list data.

Product Management:

Add new products with specific details (Name, Price, Category, Expiration Date).

Products are categorized into types like Food, Drink, Household, and Other.

Live Dashboard:

View all current items in the shopping list.

Real-time calculation of the Total Price of all items in the list.

Shopping Actions:

"Buy" items to remove them from the list once purchased.

"Buy All" functionality to clear the entire list at once.

Database Seeding: * Automatically populates the database with essential categories upon the first startup.

🛠️ Tech Stack
Backend: Java 11/17, Spring Boot

Data Access: Spring Data JPA, Hibernate, MySQL

Template Engine: Thymeleaf, HTML5, CSS3

Validation: Hibernate Validator (Bean Validation API)

Security: Custom Session-based Authentication / Interceptors

🏗️ Architecture
The project follows a clean Layered Architecture pattern:

web: Controllers responsible for handling HTTP requests, form submissions, and view navigation.

service: The business logic layer where product processing and user authentication logic reside.

repository: Data access layer using JpaRepository for MySQL communication.

model:

Entities: Persistent objects mapping to the database (User, Product, Category).

DTOs/BindingModels: Objects used for data validation and transfer between the front-end and back-end.

init: Contains the CommandLineRunner used for initial database seeding.

🔧 Setup & Installation
Clone the repository:

Bash
git clone https://github.com/Aleks29920200/Softuni.git
cd Softuni/PrepForSpringFundamentals/shopping_list
Configure Database:

Create a MySQL database named shopping_list.

Open src/main/resources/application.properties.

Update spring.datasource.username and spring.datasource.password with your MySQL credentials.

Build and Run:

Use your preferred IDE (IntelliJ/Eclipse) or run via terminal:

Bash
mvn spring-boot:run
Access the application:

Open your browser and navigate to http://localhost:8080.

📋 Database Requirements
Users: Unique username and email required.

Products: Must have a name (3-20 characters), price (positive), and a category.

Categories: Predefined values (Food, Drink, Household, Other).
🎵 Spotify Playlist Web Application
A full-stack Java web application built with Spring Boot, designed to help users discover and organize music by creating personal playlists. This project was developed as a practice exercise for the Spring Fundamentals course at SoftUni, showcasing skills in user session management, relational database mapping, and dynamic web rendering.

🚀 Features
User Authentication: * Secure Registration and Login with server-side validation.

Protection of private routes using custom session-based security logic.

Song Management:

Add new songs to the global database with details: Performer, Title, Release Date, Duration, and Style.

Songs are classified by Style (Pop, Rock, Jazz, etc.).

Personal Playlists:

Users can add any song from the global list to their own "Playlist".

View the total duration (minutes and seconds) of the user's personal playlist on the dashboard.

Remove songs from the playlist or clear the entire collection.

Global Discovery:

A public dashboard showing all available songs uploaded by the community.

Database Seeding: * Automatically populates the Styles table upon application startup to ensure consistency.

🛠️ Tech Stack
Backend: Java 11/17, Spring Boot

Data Access: Spring Data JPA, Hibernate, MySQL

Template Engine: Thymeleaf, HTML5, CSS3

Validation: Hibernate Validator (Bean Validation)

Security: Custom Session-based Authentication (Interceptors)

🏗️ Architecture
The project implements the MVC (Model-View-Controller) pattern with a clear separation of concerns:

web: Controllers handling user navigation, song submissions, and playlist management.

service: The "brain" of the app, managing business logic like song filtering and playlist calculations.

repository: Interfaces for data persistence using JpaRepository.

model:

Entities: Database tables (User, Song, Style).

DTOs/BindingModels: Objects used for input validation and securing the application's internal data.

init: Database initialization logic to seed song styles.

🔧 Setup & Installation
Clone the repository:

Bash
git clone https://github.com/Aleks29920200/Softuni.git
cd Softuni/PrepForSpringFundamentals/spotify_playlist
Configure Database:

Create a MySQL database named spotify_playlist.

Open src/main/resources/application.properties.

Update spring.datasource.username and spring.datasource.password with your local credentials.

Build and Run:

Run the application via your IDE or terminal:

Bash
mvn spring-boot:run
Access the application:

Open your browser and navigate to http://localhost:8080.

📋 Data Constraints
Songs: Performer and Title must be between 3 and 20 characters. Release date cannot be in the future.

Styles: The system supports predefined styles like Pop, Rock, and Jazz.

Users: Unique usernames and emails are required for registration.
