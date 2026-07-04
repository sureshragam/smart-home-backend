# Network Architecture

---

# 1. Introduction

The Smart Home IoT Platform consists of multiple network-connected components that communicate across both local and cloud networks.

The network architecture is designed to provide secure, reliable, and scalable communication between IoT devices, backend services, frontend applications, and administrators while supporting future expansion through local infrastructure and cloud-based services.

---

# 2. Network Overview

The platform currently consists of the following network components.

## Cloud Infrastructure

- AWS EC2
- Nginx Reverse Proxy
- Apache Tomcat
- Spring Boot Backend

## Home Network

- Wi-Fi Router
- ESP32 Devices
- ESP32-CAM
- Development Laptop
- Mobile Devices

## Database

- MySQL

## Future Components

- Mini PC Home Server
- Local DNS
- MQTT Broker
- Monitoring Stack (Grafana & Prometheus)
- VPN Gateway

---

# 3. Current Network Topology

The overall network topology is illustrated in the Network Topology Diagram.

> **Diagram:** `docs/diagrams/network-topology.png`

---

# 4. Cloud Infrastructure

The cloud infrastructure hosts the public backend services.

Current components include:

- AWS EC2
- Apache Tomcat
- Nginx Reverse Proxy
- Let's Encrypt SSL Certificate

### Responsibilities

- Host REST APIs
- HTTPS termination
- Reverse proxy configuration
- Request routing
- Secure internet access

---

# 5. Home Network

The home network hosts all IoT devices and development systems.

Current components include:

- Wi-Fi Router
- ESP32 Devices
- ESP32-CAM
- Development Laptop
- Mobile Devices

### Responsibilities

- Device communication
- Sensor data collection
- Local device management
- Development and testing

---

# 6. IP Address Management

All IoT devices use static IP addresses within the home network.

### Benefits

- Stable device communication
- Simplified backend configuration
- Easier troubleshooting
- Predictable network management
- Consistent camera access

Future versions may use Local DNS to resolve device hostnames instead of IP addresses.

Example:

```
esp32-livingroom.local
esp32-camera.local
```

---

# 7. Communication Flow

The platform currently supports the following communication paths.

## Frontend → Backend

Protocol:

- HTTPS

Technology:

- REST API
- JSON

---

## ESP32 → Backend

Protocol:

- HTTP *(Current)*
- HTTPS *(Future)*

Technology:

- REST API
- JSON

Used for:

- Device Heartbeat
- Motion Events
- Sensor Readings

---

## Backend → Database

Technology:

- Spring Data JPA
- Hibernate
- MySQL

---

## Administrator → Frontend

Protocol:

- HTTPS

Devices:

- Desktop Browser
- Mobile Browser

---

# 8. Security

Network communication follows the following principles.

- HTTPS for public APIs
- SSL/TLS encryption
- Nginx Reverse Proxy
- Input validation
- Firewall configuration
- Restricted backend access
- Static IP assignment for IoT devices

Future enhancements include:

- JWT Authentication
- HTTPS communication for IoT devices
- VPN remote access
- Local DNS
- Network segmentation (VLAN)

---

# 9. Future Network Enhancements

The following improvements are planned.

- Mini PC Home Server
- Local DNS
- MQTT Broker
- WebSocket Communication
- Grafana
- Prometheus
- Centralized Monitoring
- VPN Remote Access
- VLAN Support
- High Availability

These enhancements will improve scalability, maintainability, observability, and security while keeping IoT devices within the private home network.

---

# 10. Network Design Principles

The network architecture follows these design principles.

## Simplicity

Use straightforward communication paths and minimal configuration complexity.

---

## Reliability

Use static IP addressing and stable network components to reduce downtime.

---

## Security

Expose only required public services while keeping IoT devices isolated within the home network.

---

## Scalability

Support adding new IoT devices, sensors, cameras, and services without redesigning the network.

---

## Maintainability

Design the network so devices can be easily identified, monitored, and managed.

---

# 11. Future Vision

The long-term network architecture will combine cloud and local infrastructure.

Cloud services will provide secure remote access and API hosting, while a dedicated Mini PC will execute local automation, MQTT messaging, monitoring, and future AI-based processing.

This hybrid architecture ensures low-latency local control while maintaining secure remote accessibility.

---

# Conclusion

The Smart Home IoT Platform network architecture provides secure, reliable, and scalable communication between cloud services and local IoT devices.

Its hybrid architecture, static IP management, secure communication model, and modular design establish a strong foundation for future expansion into local automation, monitoring, and intelligent home management.
