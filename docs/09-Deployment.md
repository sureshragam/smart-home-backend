# Deployment

---

# 1. Introduction

The Smart Home IoT Platform backend is deployed as a production-ready Spring Boot application running on AWS EC2.

The deployment architecture is designed to provide secure, reliable, and scalable access to REST APIs used by the frontend dashboard and IoT devices.

---

# 2. Deployment Overview

The deployment consists of:

- GitHub Repository
- AWS EC2
- Apache Tomcat
- Spring Boot Application
- MySQL Database
- Nginx Reverse Proxy
- Let's Encrypt SSL

---

# 3. Deployment Workflow

The deployment process follows these steps:

1. Source code is committed to GitHub.
2. The project is built using Maven.
3. A WAR file is generated.
4. The WAR file is deployed to Apache Tomcat.
5. Tomcat hosts the backend application.
6. Nginx forwards HTTPS requests to Tomcat.
7. Clients securely access the REST APIs.

---

# 4. Infrastructure

Current infrastructure includes:

- AWS EC2
- Ubuntu Linux
- Apache Tomcat
- Nginx
- Java 21
- MySQL

---

# 5. Application Server

Apache Tomcat is responsible for:

- Hosting the Spring Boot application
- Processing HTTP requests
- Managing application lifecycle

---

# 6. Reverse Proxy

Nginx provides:

- HTTPS
- SSL termination
- Reverse proxy
- HTTP to HTTPS redirection

---

# 7. SSL

HTTPS is secured using Let's Encrypt certificates.

Benefits include:

- Secure communication
- Data encryption
- Trusted connections

---

# 8. Environment Configuration

Application configuration is externalized using Spring Boot configuration files.

Examples include:

- Database credentials
- Server ports
- Logging configuration
- Environment-specific settings

---

# 9. Monitoring

Current monitoring includes:

- Spring Boot Health APIs
- Backend Health Metrics

Future monitoring may include:

- Grafana
- Prometheus

---

# 10. Future Deployment Enhancements

Planned improvements include:

- Docker
- Docker Compose
- CI/CD Pipeline
- Kubernetes (Optional)
- Blue-Green Deployment (Optional)

---

# Conclusion

The deployment architecture provides a stable, secure, and maintainable environment for hosting the Smart Home IoT Platform while supporting future scalability and operational improvements.
