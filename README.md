# 🏠 Smart Home IoT Platform - Backend

A production-style backend application built with **Spring Boot** for managing smart home devices, processing IoT events, monitoring system health, and serving REST APIs for the Smart Home IoT Platform.

---

## ✨ Features

- 📱 Device Management
- 📊 Dashboard Summary
- 🚶 Motion Event Processing
- 📡 Device Heartbeat API
- ❤️ Health Monitoring
- 🔐 Request Validation
- ⚠️ Global Exception Handling
- 🏗 Layered Architecture
- 🌐 RESTful APIs
- ☁️ AWS EC2 Deployment

---

## 🛠 Technology Stack

### Backend

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Maven
- Lombok

### Database

- MySQL

### Deployment

- Apache Tomcat
- Nginx
- AWS EC2
- Let's Encrypt SSL

---

## 📂 Project Structure

```text
smart-home-backend
│
├── src
├── docs
├── pom.xml
└── README.md
```

Detailed project architecture is available in the **docs** directory.

---

## 🏗 Architecture

```text
                REST Client
                     │
                     ▼
              Spring Boot API
                     │
      ┌──────────────┴──────────────┐
      ▼                             ▼
 Business Services             Scheduled Tasks
      │
      ▼
 Repository Layer
      │
      ▼
    MySQL Database
```

---

## 📡 REST APIs

### Dashboard

| Method | Endpoint         |
| ------ | ---------------- |
| GET    | `/api/dashboard` |

### Devices

| Method | Endpoint                 |
| ------ | ------------------------ |
| GET    | `/api/devices`           |
| POST   | `/api/devices/heartbeat` |

### Activities

| Method | Endpoint                 |
| ------ | ------------------------ |
| GET    | `/api/activities`        |
| POST   | `/api/activities/motion` |

### Health

| Method | Endpoint      |
| ------ | ------------- |
| GET    | `/api/health` |

Complete API documentation is available in **docs/06-API-Documentation.md**.

---

## 📌 Project Status

### ✅ Completed

- Spring Boot Project Setup
- Layered Architecture
- MySQL Integration
- Spring Data JPA & Hibernate
- Dashboard APIs
- Device APIs
- Activity APIs
- Health APIs
- Device Heartbeat Processing
- Motion Event Processing
- Request Validation
- Global Exception Handling
- AWS EC2 Deployment
- Tomcat Deployment
- HTTPS Configuration

### 🚧 In Progress

- Device Management (CRUD)
- ESP32 Integration Improvements
- Sensor Data APIs

### 🔮 Planned

- Spring Security & JWT Authentication
- Home Automation Engine
- Analytics Dashboard
- Notification Service
- ESP32-CAM Support
- OTA Firmware Updates
- WebSocket Integration
- Docker Support

---

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL
- Apache Tomcat 10

### Clone Repository

```bash
git clone https://github.com/<your-username>/smart-home-backend.git
```

### Navigate to Project

```bash
cd smart-home-backend
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## 📚 Documentation

Detailed documentation is available in the **docs** directory.

- Project Overview
- Functional Requirements
- System Architecture
- Database Design
- Backend Architecture
- API Documentation
- Network Architecture
- Security
- Deployment
- Sprint Roadmap
- Architecture Decisions

---

## 🗺 Roadmap

- ✅ Sprint 1 – Foundation
- ✅ Sprint 2 – Dashboard & Device Monitoring
- 🚧 Sprint 3 – Device Management
- ⏳ Sprint 4 – Security & Authentication
- ⏳ Sprint 5 – Health Monitoring
- ⏳ Sprint 6 – Automation
- ⏳ Sprint 7 – Analytics
- ⏳ Sprint 8 – Notifications
- ⏳ Sprint 9 – Production Readiness

---

## 👨‍💻 Author

**Suresh Ragam**

GitHub: https://github.com/sureshragam

---

## 📄 License

This project is intended for learning, experimentation, and portfolio purposes.
