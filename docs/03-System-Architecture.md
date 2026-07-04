# System Architecture

---

# 1. Introduction

The Smart Home IoT Platform follows a modular, layered architecture designed to support scalability, maintainability, and future expansion.

The platform integrates a React-based web application, a Spring Boot backend, a MySQL database, and ESP32-based IoT devices to provide centralized monitoring, device management, project investment tracking, and future home automation capabilities.

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

The Smart Home IoT Platform consists of five major layers:

- Presentation Layer
- Application Layer
- Data Layer
- IoT Layer
- Infrastructure Layer

The interaction between these layers is illustrated in the System Architecture Diagram.

> **Diagram:** `docs/diagrams/system-architecture.png`

---

# 4. Presentation Layer

The Presentation Layer consists of the React-based web dashboard.

Responsibilities include:

- Dashboard overview
- Device Management
- Activity Monitoring
- Health Monitoring
- Project Investment Management
- Analytics Dashboard
- Notification Center
- Automation Management
- System Settings

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
- Project investment management
- Future authentication
- Future automation processing
- Future notification processing

The backend follows a layered architecture consisting of:

- Controllers
- Services
- DTOs
- Mappers
- Repositories
- Entities

The application is organized into independent modules:

- Dashboard
- Device
- Activity
- Sensor
- Health
- Investment
- Authentication *(Planned)*
- Automation *(Planned)*
- Notification *(Planned)*

Detailed package information is documented in **Backend Architecture**.

---

# 6. Data Layer

The Data Layer is implemented using MySQL.

It stores application data including:

- Devices
- Activities
- Health Metrics
- Sensor Readings
- Project Investments
- Future Automation Rules
- Future User Accounts
- Future Notifications

Data access is performed using Spring Data JPA and Hibernate.

---

# 7. IoT Layer

The IoT Layer consists of ESP32-based smart devices connected to the home network.

### Current Devices

- ESP32
- ESP32-CAM
- PIR Motion Sensor
- Relay Module

### Future Devices

- Temperature Sensors
- Humidity Sensors
- Door Sensors
- Water Leak Sensors
- Smart Switches
- Energy Monitoring Devices

IoT devices communicate with the backend using HTTP-based REST APIs over Wi-Fi.

Future versions may support MQTT for asynchronous communication.

---

# 8. Infrastructure Layer

The platform is deployed on cloud infrastructure.

### Current Infrastructure

- AWS EC2
- Apache Tomcat
- Nginx
- Let's Encrypt SSL
- GitHub
- GitHub Projects

### Planned Infrastructure

- Mini PC Home Server
- Local DNS
- Docker
- MQTT Broker
- Monitoring Stack
- Grafana
- Prometheus

---

# 9. Communication Flow

The platform follows a request-response communication model.

Typical communication flow:

1. ESP32 devices collect sensor data or detect events.
2. Devices send REST API requests to the backend.
3. Spring Boot validates and processes requests.
4. Business logic updates the database.
5. React Dashboard requests updated information.
6. Dashboard displays the latest system state.

Future versions will also support WebSocket-based real-time communication.

---

# 10. Architectural Principles

The platform follows the following software architecture principles.

## Layered Architecture

Each application layer has a clearly defined responsibility.

---

## Separation of Concerns

Business logic, presentation, persistence, and infrastructure are isolated from one another.

---

## Modular Design

Each feature is developed as an independent module to improve maintainability and scalability.

---

## RESTful Design

Communication between frontend, backend, and IoT devices is performed using REST APIs.

---

## Scalability

New devices, sensors, business modules, and automation capabilities can be added without major architectural changes.

---

## Maintainability

The codebase follows clean architecture principles, documentation standards, coding conventions, and Agile development practices.

---

# 11. Scalability Considerations

The architecture is designed to support future growth by allowing:

- Additional IoT devices
- Multiple sensor types
- Home automation workflows
- User authentication
- Notification services
- Analytics modules
- Project investment analytics
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
- Project Investment Analytics
- Mobile Application
- AI-powered Smart Home Features

These enhancements will extend the platform while preserving the existing layered architecture.

---

# 13. Architecture Diagrams

The following diagrams provide additional details about the system architecture.

- High-Level System Architecture
- Backend Component Diagram
- Database ER Diagram
- Deployment Diagram
- Network Topology
- Authentication Sequence Diagram
- Device Registration Sequence Diagram
- Device Heartbeat Sequence Diagram
- Motion Event Sequence Diagram
- Dashboard Request Flow Diagram

All architecture diagrams are maintained in the `docs/diagrams` directory.

---

# Conclusion

The Smart Home IoT Platform is designed as a modular, scalable, and maintainable system capable of supporting current smart home functionality while providing a strong architectural foundation for future enhancements.

Its layered architecture, standardized communication model, modular design, and extensible architecture enable continuous evolution through planned development sprints without requiring significant redesign.
