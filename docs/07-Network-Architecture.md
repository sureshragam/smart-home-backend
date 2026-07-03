# Network Architecture

---

# 1. Introduction

The Smart Home IoT Platform consists of multiple network-connected components that communicate over both local and cloud networks.

The network architecture is designed to provide secure communication between IoT devices, the backend server, the frontend dashboard, and administrators while maintaining scalability for future expansion.

---

# 2. Network Overview

The platform currently consists of the following network components:

- React Frontend
- Spring Boot Backend
- MySQL Database
- ESP32 Devices
- ESP32-CAM
- Home Wi-Fi Network
- AWS EC2 Server

Future enhancements include:

- Mini PC Home Server
- Local DNS
- MQTT Broker
- Monitoring Stack

---

# 3. Current Network Topology

The overall network topology is illustrated in the Network Topology Diagram.

> **Diagram:** `docs/diagrams/network-topology.png`

---

# 4. Cloud Infrastructure

The cloud infrastructure hosts the backend application.

Current components include:

- AWS EC2
- Apache Tomcat
- Nginx Reverse Proxy
- Let's Encrypt SSL Certificate

Responsibilities include:

- Hosting REST APIs
- HTTPS termination
- Request routing
- Secure internet access

---

# 5. Home Network

The home network hosts all IoT devices.

Current components include:

- Wi-Fi Router
- ESP32 Devices
- ESP32-CAM
- Development Laptop
- Mobile Devices

All IoT devices communicate with the backend over Wi-Fi.

---

# 6. IP Address Management

IoT devices use static IP addresses within the home network.

Benefits include:

- Stable device communication
- Easier troubleshooting
- Simplified backend configuration
- Predictable network management

Future versions may use local DNS to resolve device hostnames instead of IP addresses.

---

# 7. Communication Flow

The following communication paths are currently supported.

## Frontend → Backend

- HTTPS
- REST APIs
- JSON

---

## ESP32 → Backend

- HTTP
- REST APIs
- JSON

Used for:

- Device heartbeat
- Motion events
- Sensor readings

---

## Backend → Database

- Spring Data JPA
- Hibernate
- MySQL

---

# 8. Security

Network communication follows the following principles:

- HTTPS for public APIs
- Secure reverse proxy
- Input validation
- Firewall configuration
- Restricted backend access

Future versions will introduce JWT authentication for protected APIs.

---

# 9. Future Network Enhancements

The following improvements are planned:

- Mini PC Home Server
- Local DNS
- MQTT Broker
- WebSocket Communication
- Centralized Monitoring
- VLAN Support (Optional)
- VPN Remote Access (Optional)

These enhancements will improve scalability, reliability, and maintainability while keeping IoT devices within the private home network.

---

# Conclusion

The Smart Home IoT Platform network architecture provides secure and reliable communication between cloud services and local IoT devices.

Its modular design supports future expansion while maintaining a clear separation between internet-facing services and the private home network.
