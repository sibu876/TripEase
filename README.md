🚖 TripEase – Cab Booking Backend System

TripEase is a RESTful backend application built using Spring Boot and MySQL that allows customers to book available cabs based on their destination. The system automatically assigns drivers, manages cab availability, stores booking records, and sends email confirmations upon successful booking.

This project demonstrates clean architecture, layered design, DTO usage, exception handling, and SMTP email integration.

📌 Table of Contents

Overview

Features

Tech Stack

Architecture

Project Structure

Database Design

API Endpoints

Email Integration

Installation & Setup

Environment Variables

How It Works

Future Improvements

Author

📖 Overview

TripEase is a backend cab booking system that simulates real-world ride booking functionality.

It manages:

Customers

Drivers

Cabs

Bookings

Email notifications

The application ensures:

Only available cabs are assigned

Drivers are linked to bookings

Customers receive booking confirmation emails

✅ Features

✔ Customer registration and management

✔ Cab booking based on destination

✔ Automatic driver assignment

✔ Cab availability tracking

✔ Booking persistence using JPA

✔ Email confirmation using SMTP

✔ Custom exception handling

✔ Layered architecture implementation

✔ DTO & Transformer pattern

🛠 Tech Stack
Technology	Purpose
Java	Programming Language
Spring Boot	Backend Framework
Spring Data JPA	ORM
Hibernate	Persistence
MySQL	Database
JavaMailSender	Email Service
Maven	Dependency Management
🏗 Architecture

TripEase follows a layered architecture:

Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database (MySQL)
Design Principles Used:

Dependency Injection

Separation of Concerns

DTO Pattern

Transformer Pattern

Custom Exception Handling

📂 Project Structure
TripEase
│── controller
│── services
│── repository
│── entity
│── dtos
│── transformer
│── exceptions
│── application.properties
│── pom.xml
🗄 Database Design
Main Entities:

Customer

Driver

Cab

Booking

Relationships:

One Customer → Many Bookings

One Driver → Many Bookings

One Cab → One Driver

One Booking → Linked to Customer, Driver, and Cab

🌐 API Endpoints (Example)
📍 Book a Cab
POST /booking/book/{customerId}
📍 Add Customer
POST /customer/add
📍 Add Driver
POST /driver/add
📍 Add Cab
POST /cab/add

(Modify based on your actual controller mappings if different.)

📧 Email Integration

After a successful booking:

A confirmation email is sent to the customer.

Configured using Gmail SMTP.

Implemented using Spring’s JavaMailSender.

⚙ Installation & Setup
1️⃣ Clone Repository
git clone https://github.com/yourusername/TripEase.git
cd TripEase
2️⃣ Create MySQL Database
CREATE DATABASE tripease;
3️⃣ Configure Environment Variables

Create a .env file in the root directory:

DB_USERNAME=root
DB_PASSWORD=your_mysql_password
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_gmail_app_password

⚠ Never push .env to GitHub.
Add this to .gitignore:

.env
4️⃣ Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/tripease
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
5️⃣ Run Application

Using IDE
OR

mvn spring-boot:run

Application runs at:

http://localhost:8080
🔄 How It Works

Customer sends booking request.

System verifies customer exists.

System checks for available cab.

If cab is available:

Driver is assigned

Booking is saved

Cab availability is updated

Confirmation email is sent to the customer.

Booking response is returned.

🚀 Future Improvements

Payment gateway integration

JWT authentication & authorization

Admin dashboard

Ride tracking system

Swagger API documentation
