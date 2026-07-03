# Architecture Decisions

---

## ADR-001

### Decision

Use Spring Boot as the backend framework.

### Reason

Provides a mature ecosystem, excellent REST support, dependency injection, validation, JPA integration, and production-ready features.

---

## ADR-002

### Decision

Use React with TypeScript for the frontend.

### Reason

Provides a modern, component-based architecture with strong typing and maintainability.

---

## ADR-003

### Decision

Use MySQL as the primary database.

### Reason

Reliable relational database with excellent Spring Boot integration and strong community support.

---

## ADR-004

### Decision

Deploy the application as a WAR file on Apache Tomcat.

### Reason

Provides flexibility, aligns with enterprise deployment practices, and matches existing infrastructure experience.

---

## ADR-005

### Decision

Use Layered Architecture.

### Reason

Improves separation of concerns, maintainability, testing, and scalability.

---

## ADR-006

### Decision

Use Feature-Based Package Structure.

### Reason

Organizes code by business capability, making the project easier to navigate and extend.

---

## ADR-007

### Decision

Use Static IP Addresses for IoT Devices.

### Reason

Provides predictable communication, simplifies backend integration, and reduces network configuration complexity.

---

## ADR-008

### Decision

Use GitHub Projects for Sprint Management.

### Reason

Provides integrated issue tracking, sprint planning, and project visibility.

---

## ADR-009

### Decision

Use REST APIs for Communication.

### Reason

Simple, widely supported, easy to debug, and well suited for the current scale of the Smart Home IoT Platform.

MQTT may be introduced in future versions if real-time messaging requirements increase.

---

# Conclusion

These Architecture Decision Records (ADRs) document the major technical decisions made throughout the development of the Smart Home IoT Platform.

Future architectural decisions will be added as the platform evolves.
