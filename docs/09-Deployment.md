# Deployment

---

# 1. Introduction

The Smart Home IoT Platform backend is deployed as a production-ready Spring Boot application running on AWS EC2.

The deployment architecture is designed to provide secure, reliable, and scalable access to REST APIs consumed by the React frontend, ESP32 devices, and future smart home services.

---

# 2. Deployment Overview

The deployment consists of the following components.

## Source Control

- GitHub Repository

## Cloud Infrastructure

- AWS EC2
- Ubuntu Linux

## Application Layer

- Java 21
- Apache Tomcat
- Spring Boot Application

## Database

- MySQL

## Reverse Proxy

- Nginx
- Let's Encrypt SSL

---

# 3. Deployment Architecture

The deployment architecture is illustrated in the Deployment Diagram.

> **Diagram:** `docs/diagrams/deployment-diagram.png`

---

# 4. Deployment Workflow

The deployment process follows these steps.

1. Source code is committed to GitHub.
2. Maven builds the project.
3. A WAR file is generated.
4. The WAR file is deployed to Apache Tomcat.
5. Tomcat starts the Spring Boot application.
6. Nginx forwards HTTPS requests to Tomcat.
7. Clients securely access the REST APIs.

---

# 5. Infrastructure

Current production infrastructure includes:

- AWS EC2
- Ubuntu Linux
- Java 21
- Apache Tomcat
- Nginx
- MySQL
- Let's Encrypt SSL

---

# 6. Application Server

Apache Tomcat is responsible for:

- Hosting the Spring Boot application
- Managing application lifecycle
- Processing HTTP requests
- Deploying WAR packages

---

# 7. Reverse Proxy

Nginx provides:

- HTTPS termination
- Reverse proxy
- HTTP to HTTPS redirection
- Request forwarding
- Security headers *(Future)*

---

# 8. SSL

HTTPS communication is secured using Let's Encrypt SSL certificates.

Benefits include:

- Secure communication
- Data encryption
- Trusted browser connections
- Protection against man-in-the-middle attacks

---

# 9. Environment Configuration

Application configuration is externalized using Spring Boot configuration files and environment-specific settings.

Typical configuration includes:

- Database connection
- Server ports
- Logging
- Active Spring Profile
- JWT Secret *(Future)*
- API Keys *(Future)*

Sensitive configuration values should never be committed to source control.

---

# 10. Deployment Environments

The project supports multiple deployment environments.

## Development

- Local Machine
- MySQL
- Spring Boot
- HTTP

---

## Production

- AWS EC2
- Nginx
- Apache Tomcat
- HTTPS
- MySQL

---

# 11. Monitoring

Current monitoring includes:

- Spring Boot Health APIs
- Backend Health Metrics

Future monitoring includes:

- Grafana
- Prometheus
- Application Logs
- Server Resource Monitoring

---

# 12. Backup & Recovery *(Future)*

Planned backup strategy:

- Database Backups
- Configuration Backups
- SSL Certificate Renewal
- Server Recovery Documentation

---

# 13. Future Deployment Enhancements

Planned improvements include:

- Docker
- Docker Compose
- CI/CD Pipeline
- GitHub Actions
- Kubernetes *(Optional)*
- Blue-Green Deployment *(Optional)*
- Mini PC Home Server Deployment
- Hybrid Cloud + Local Deployment

---

# 14. Deployment Principles

The deployment architecture follows these principles.

## Reliability

Ensure continuous availability of backend services.

---

## Security

Use HTTPS, secure SSH access, and restricted firewall rules.

---

## Maintainability

Keep deployment configuration simple, documented, and reproducible.

---

## Scalability

Support future migration to containerized and distributed deployments.

---

# Conclusion

The deployment architecture provides a secure, reliable, and maintainable environment for hosting the Smart Home IoT Platform.

Its combination of AWS EC2, Apache Tomcat, Nginx, HTTPS, and MySQL establishes a production-ready foundation that can evolve toward containerization, hybrid deployments, and automated CI/CD pipelines as the platform grows.
