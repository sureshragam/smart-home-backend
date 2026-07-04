# Architecture Decision Records (ADR)

---

# Introduction

This document records significant architectural decisions made during the development of the Smart Home IoT Platform.

Each Architecture Decision Record (ADR) documents:

- The architectural decision
- The rationale behind the decision
- Any future considerations

Maintaining ADRs helps preserve the reasoning behind technical choices and provides guidance for future development.

---

# ADR-001

## Decision

Use Spring Boot as the backend framework.

## Reason

Spring Boot provides a mature ecosystem, dependency injection, REST API support, validation, Spring Data JPA integration, production-ready features, and excellent long-term maintainability.

---

# ADR-002

## Decision

Use React with TypeScript for the frontend.

## Reason

React offers a component-based architecture, while TypeScript improves type safety, maintainability, scalability, and developer productivity.

---

# ADR-003

## Decision

Use Material UI as the frontend component library.

## Reason

Material UI provides enterprise-grade UI components, responsive layouts, accessibility support, and seamless integration with React.

---

# ADR-004

## Decision

Use MySQL as the primary relational database.

## Reason

MySQL is reliable, well-supported by Spring Boot, easy to administer, and suitable for the relational nature of the Smart Home IoT Platform.

---

# ADR-005

## Decision

Deploy the backend as a WAR file on Apache Tomcat.

## Reason

Deploying as a WAR aligns with enterprise deployment practices, simplifies migration to existing infrastructure, and matches previous deployment experience.

---

# ADR-006

## Decision

Use Nginx as the reverse proxy.

## Reason

Nginx provides HTTPS termination, request forwarding, improved security, and simplified routing while keeping the application server isolated.

---

# ADR-007

## Decision

Use AWS EC2 for production deployment.

## Reason

AWS EC2 provides a flexible, scalable, and cost-effective environment suitable for hosting backend services and future platform expansion.

---

# ADR-008

## Decision

Adopt a Layered Architecture.

## Reason

Separating Controllers, Services, Repositories, and the Database Layer improves maintainability, testability, and separation of concerns.

---

# ADR-009

## Decision

Use Feature-Based Package Structure.

## Reason

Organizing code by business capability (Device, Activity, Health, Sensor, etc.) improves modularity, readability, and long-term scalability.

---

# ADR-010

## Decision

Use Static IP Addresses for IoT Devices.

## Reason

Static IPs provide predictable device communication, simplify backend integration, reduce troubleshooting effort, and improve network reliability.

Future versions may introduce Local DNS for hostname-based device discovery.

---

# ADR-011

## Decision

Use REST APIs for communication.

## Reason

REST is simple, widely supported, easy to debug, and appropriate for the current scale of the Smart Home IoT Platform.

Future versions may introduce MQTT and WebSocket for event-driven and real-time communication.

---

# ADR-012

## Decision

Track project investments within the platform.

## Reason

Managing hardware, infrastructure, networking, and software expenses provides better visibility into project costs and demonstrates real-world asset management capabilities.

---

# ADR-013

## Decision

Manage development using GitHub Projects.

## Reason

GitHub Projects provides integrated sprint planning, issue tracking, roadmap visualization, and development progress management.

---

# ADR-014

## Decision

Use HTTPS for all public communication.

## Reason

HTTPS encrypts data in transit, protects API communication, and is essential for production-grade security.

---

# ADR-015

## Decision

Design the platform as a hybrid cloud architecture.

## Reason

Cloud infrastructure enables secure remote access, while a future Mini PC will provide local automation, MQTT services, monitoring, and AI processing with lower latency.

---

# Future Architecture Decisions

Future ADRs may include decisions regarding:

- Spring Security
- JWT Authentication
- MQTT Broker
- Docker
- Kubernetes
- Home Assistant Integration
- OTA Firmware Updates
- Grafana & Prometheus
- AI-Based Automation
- Mobile Application

---

# Conclusion

These Architecture Decision Records document the major technical decisions made throughout the development of the Smart Home IoT Platform.

Recording architectural decisions preserves the rationale behind technology choices, supports long-term maintainability, and provides valuable context for future development and contributors.
