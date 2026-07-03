# System Architecture

---

# 1. Introduction

The Smart Home IoT Platform follows a modular, layered architecture designed to support scalability, maintainability, and future expansion.

The platform integrates a React-based web application, a Spring Boot backend, a MySQL database, and ESP32-based IoT devices to provide centralized monitoring and management of smart home devices.

The architecture emphasizes separation of concerns, modular development, secure communication, and extensibility for future IoT capabilities.

---

# 2. Architecture Goals

The primary architectural goals of the platform are:

- Build a scalable backend architecture.
- Maintain clear separation of responsibilities.
- Enable seamless IoT device integration.
- Support future feature expansion.
- Ensure maintainability through modular design.
- Provide secure communication between all components.
- Support cloud deployment and production environments.

---

# 3. High-Level Architecture

The Smart Home IoT Platform consists of four major layers:

- Presentation Layer
- Application Layer
- Data Layer
- IoT Layer

The interaction between these layers is illustrated in the System Architecture Diagram.

> **Diagram:** `docs/diagrams/system-architecture.png`

---

# 4. Presentation Layer

The Presentation Layer consists of the React-based web dashboard.

Responsibilities include:

- Displaying dashboard statistics
- Managing devices
- Viewing activities
- Monitoring system health
- Displaying analytics
- Managing future automation rules

The frontend communicates with the backend exclusively through REST APIs.

---

# 5. Application Layer

The Application Layer is implemented using Spring Boot.

Its responsibilities include:

- Business logic
- REST API implementation
- Request validation
- Exception handling
- Device communication
- Activity processing
- Health monitoring
- Future authentication
- Future automation processing

The backend follows a layered architecture consisting of:

- Controllers
- Services
- DTOs
- Mappers
- Repositories
- Entities

Detailed package information is documented in **Backend Architecture**.

---

# 6. Data Layer

The Data Layer is implemented using MySQL.

It stores application data including:

- Devices
- Activities
- Health metrics
- Future automation rules
- Future user accounts
- Future notifications

Data access is performed using Spring Data JPA and Hibernate.

---

# 7. IoT Layer

The IoT Layer consists of ESP32-based smart devices connected to the home network.

Current devices include:

- ESP32
- ESP32-CAM
- PIR Motion Sensor
- Relay Module

Future devices may include:

- Temperature Sensors
- Humidity Sensors
- Door Sensors
- Water Leak Sensors
- Smart Switches
- Energy Monitoring Devices

IoT devices communicate with the backend using HTTP-based REST APIs over Wi-Fi.

---

# 8. Infrastructure Layer

The platform is deployed on cloud infrastructure.

Current infrastructure includes:

- AWS EC2
- Apache Tomcat
- Nginx
- Let's Encrypt SSL
- GitHub
- GitHub Projects

Future infrastructure enhancements include:

- Mini PC Home Server
- Local DNS
- Docker
- MQTT Broker
- Monitoring Stack

---

# 9. Communication Flow

The platform follows a request-response communication model.

Typical communication flow:

1. An ESP32 device sends sensor data or heartbeat information.
2. The backend validates and processes the request.
3. Data is stored in the database.
4. The frontend retrieves updated information through REST APIs.
5. Dashboard components display the latest system status.

Future versions will also support WebSocket-based real-time communication.

---

# 10. Architectural Principles

The platform follows the following software architecture principles:

## Layered Architecture

Each application layer has a clearly defined responsibility.

---

## Separation of Concerns

Business logic, presentation, persistence, and infrastructure are isolated from one another.

---

## Modular Design

Features are organized into independent modules to simplify maintenance and future expansion.

---

## RESTful Design

Communication between frontend, backend, and IoT devices is performed using REST APIs.

---

## Scalability

The architecture supports adding new devices, sensors, and application modules without major structural changes.

---

## Maintainability

The codebase follows clean architecture principles, documentation standards, and Agile development practices.

---

# 11. Scalability Considerations

The architecture is designed to support future growth by allowing:

- Additional IoT devices
- Multiple sensor types
- Automation workflows
- User authentication
- Notification services
- Analytics modules
- Mobile applications
- AI-powered automation

without requiring significant architectural changes.

---

# 12. Future Architecture

The platform roadmap includes several architectural enhancements:

- Spring Security & JWT Authentication
- Home Automation Engine
- WebSocket Integration
- MQTT Communication
- ESP32-CAM Image Processing
- Docker Deployment
- Local DNS
- Monitoring Stack
- Mobile Application
- AI-powered Smart Home Features

These enhancements will extend the platform while preserving the existing layered architecture.

---

# 13. Architecture Diagrams

The following diagrams provide additional details about the system architecture.

- High-Level System Architecture
- Backend Component Diagram
- Database ER Diagram
- Network Topology
- Deployment Diagram
- Authentication Sequence Diagram
- Device Registration Sequence Diagram
- Dashboard Data Flow

All architecture diagrams are maintained in the `docs/diagrams` directory.

---

# Conclusion

The Smart Home IoT Platform is designed as a modular, scalable, and maintainable system capable of supporting current smart home functionality while providing a strong architectural foundation for future enhancements.

Its layered architecture, standardized communication model, and extensible design enable continuous evolution through planned development sprints without requiring significant redesign.
