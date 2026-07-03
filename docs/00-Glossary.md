# Glossary

This glossary defines common terms, abbreviations, and concepts used throughout the Smart Home IoT Platform documentation.

---

# A

## API (Application Programming Interface)

A set of HTTP endpoints that enables communication between the frontend, backend, and IoT devices.

---

# B

## Backend

The Spring Boot application responsible for processing business logic, exposing REST APIs, managing devices, storing data, and coordinating communication between all platform components.

---

# C

## Controller

The REST layer responsible for receiving HTTP requests, validating input, and delegating processing to the service layer.

---

# D

## Dashboard

The main web interface that provides an overview of connected devices, health metrics, recent activities, and system status.

---

## Device

Any IoT hardware registered with the Smart Home Platform.

Examples include:

- ESP32
- ESP32-CAM
- Motion Sensors
- Relay Controllers

---

## Device Heartbeat

A periodic message sent from an IoT device to the backend indicating that the device is online and operational.

---

## Device Status

Represents the current availability of a device.

Possible values include:

- ONLINE
- OFFLINE

---

# E

## ESP32

A Wi-Fi and Bluetooth-enabled microcontroller used as the primary hardware platform for smart home devices.

---

## ESP32-CAM

An ESP32 development board equipped with a built-in camera module capable of image capture and video streaming.

---

# F

## Frontend

The React-based web application used to monitor and manage smart home devices through a modern graphical user interface.

---

# G

## GitHub Project

A project management board used to track sprint planning, issues, priorities, and development progress.

---

# H

## Health Monitoring

The process of monitoring system resources such as CPU usage, memory consumption, database availability, and application health.

---

## Heartbeat

A scheduled communication from an IoT device confirming that it is connected and functioning correctly.

---

# I

## IoT (Internet of Things)

A network of interconnected physical devices capable of collecting, transmitting, and receiving data over a network.

---

# J

## JWT (JSON Web Token)

A secure token-based authentication mechanism used to identify and authorize users.

---

# L

## Layered Architecture

A software architecture pattern that separates responsibilities into distinct layers such as Controller, Service, Repository, and Database.

---

# M

## Motion Event

An event generated when a PIR sensor detects movement and reports it to the backend.

---

## MySQL

The relational database management system used for storing application data.

---

# N

## Nginx

A reverse proxy server used to securely expose the backend application over HTTPS.

---

# P

## PIR Sensor

A Passive Infrared (PIR) sensor used to detect motion by measuring infrared radiation changes.

---

## Platform

The complete Smart Home IoT ecosystem consisting of the frontend, backend, database, infrastructure, and IoT devices.

---

# R

## React

The frontend JavaScript library used to build the Smart Home Dashboard.

---

## Relay Module

An electronic switching component used to control high-voltage electrical appliances from an ESP32.

---

## Repository

The data access layer responsible for communicating with the database using Spring Data JPA.

---

## REST API

An HTTP-based interface that enables communication between software components using standard HTTP methods such as GET, POST, PUT, and DELETE.

---

# S

## Scheduler

A background process responsible for executing automated tasks at predefined intervals.

---

## Service Layer

The business logic layer responsible for processing requests, applying validation, and coordinating application workflows.

---

## Sprint

A fixed development cycle during which a defined set of features or improvements is implemented following Agile development practices.

---

## Spring Boot

The backend framework used to build RESTful services for the Smart Home IoT Platform.

---

# T

## Tomcat

The application server used to deploy and run the Spring Boot application as a WAR file.

---

# W

## WebSocket

A full-duplex communication protocol enabling real-time communication between the backend and frontend.

---

# Purpose

This glossary serves as a central reference for terminology used throughout the Smart Home IoT Platform documentation, ensuring consistent language across all technical documents.