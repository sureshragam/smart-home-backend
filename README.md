# 🏠 Smart Home Backend

A production-style IoT backend built with **Spring Boot** for managing smart home devices, motion events, health monitoring, and future ESP32 integrations.

## 🚀 Features

- Device Management
- Dashboard Summary
- Motion Event Processing
- Device Heartbeat API
- Health Monitoring
- Global Exception Handling
- Request Validation
- Layered Architecture
- RESTful APIs

---

## 🛠 Tech Stack

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

---

## 📂 Project Structure

```
src/main/java/com/suresh/smarthome

├── activity
├── common
├── config
├── dashboard
├── device
├── health
└── SmartHomeBackendApplication.java
```

---

## 🏗 Architecture

```
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
MySQL Database
```

---

## 📡 REST APIs

### Dashboard

| Method | Endpoint |
|---------|----------|
| GET | `/api/dashboard` |

### Devices

| Method | Endpoint |
|---------|----------|
| GET | `/api/devices` |
| POST | `/api/devices/heartbeat` |

### Activities

| Method | Endpoint |
|---------|----------|
| GET | `/api/activities` |
| POST | `/api/activities/motion` |

### Health

| Method | Endpoint |
|---------|----------|
| GET | `/api/health` |

---

## 📊 Current Progress

### ✅ Completed

- Spring Boot Setup
- MySQL Integration
- JPA & Hibernate
- Device APIs
- Dashboard API
- Activity APIs
- Health APIs
- Device Heartbeat
- Motion Event Processing
- Validation
- Exception Handling

### 🚧 In Progress

- Sensor Reading API
- ESP32 Integration
- Camera Upload API
- WebSocket Notifications
- OTA Updates

---

## 🔮 Future Enhancements

- ESP32 Device Registration
- Temperature & Humidity Sensors
- ESP32-CAM Image Upload
- Real-time Dashboard (WebSocket)
- Push Notifications
- Alexa Integration
- Device Scheduling
- Role-based Authentication
- Docker Deployment

---

## ▶️ Running the Project

Clone the repository:

```bash
git clone https://github.com/<your-username>/smart-home-backend.git
```

Navigate to the project:

```bash
cd smart-home-backend
```

Run the application:

```bash
./mvnw spring-boot:run
```

---

## 📄 License

This project is for learning, experimentation, and portfolio purposes.
