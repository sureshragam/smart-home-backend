# API Documentation

---

# 1. Introduction

The Smart Home IoT Platform exposes RESTful APIs that enable communication between the frontend dashboard, IoT devices, and backend services.

All APIs follow REST principles and exchange data using JSON.

The API layer is designed to provide a consistent, secure, and scalable interface for managing smart home devices, monitoring activities, collecting sensor data, tracking project investments, and retrieving system health information.

---

# 2. API Standards

The backend follows the following API conventions.

## Protocol

- HTTPS

## Data Format

- JSON

## Character Encoding

- UTF-8

## API Version

```
v1
```

## Base URL

Production

```
https://api.smarthome.sureshragam.in
```

Development

```
http://localhost:8080
```

---

# 3. Request Headers

Current headers:

```http
Content-Type: application/json
Accept: application/json
```

Future authenticated requests:

```http
Authorization: Bearer <JWT Token>
```

---

# 4. Dashboard APIs

## Get Dashboard Summary

### Endpoint

```
GET /api/dashboard
```

### Description

Returns dashboard statistics including:

- Device summary
- Health metrics
- Recent activities
- Project investment summary *(Future)*

### Response

- 200 OK
- 500 Internal Server Error

---

# 5. Device APIs

## Get All Devices

```
GET /api/devices
```

Returns all registered devices.

---

## Get Device By ID

```
GET /api/devices/{id}
```

Returns a specific device.

---

## Create Device

```
POST /api/devices
```

Registers a new device.

---

## Update Device

```
PUT /api/devices/{id}
```

Updates an existing device.

---

## Delete Device

```
DELETE /api/devices/{id}
```

Deletes a device.

---

## Device Heartbeat

```
POST /api/devices/heartbeat
```

Receives heartbeat information from ESP32 devices.

Updates:

- Device Status
- Last Seen
- Wi-Fi Strength
- IP Address

---

# 6. Activity APIs

## Get Activities

```
GET /api/activities
```

Returns recent activities.

---

## Record Motion Event

```
POST /api/activities/motion
```

Receives motion detection events from ESP32 devices.

---

# 7. Sensor APIs

## Submit Sensor Reading

```
POST /api/sensors/readings
```

Stores:

- Temperature
- Humidity
- Battery
- Signal Strength

---

## Get Sensor Readings

```
GET /api/sensors/readings
```

Returns historical sensor readings.

---

# 8. Health APIs

## Get Health Metrics

```
GET /api/health
```

Returns:

- Memory Usage
- CPU Usage
- Database Status

---

# 9. Project Investment APIs *(Sprint 5)*

## Get Investments

```
GET /api/investments
```

Returns all recorded project investments.

---

## Get Investment By ID

```
GET /api/investments/{id}
```

Returns investment details.

---

## Create Investment

```
POST /api/investments
```

Creates a new investment record.

---

## Update Investment

```
PUT /api/investments/{id}
```

Updates an investment.

---

## Delete Investment

```
DELETE /api/investments/{id}
```

Deletes an investment.

---

## Investment Summary

```
GET /api/investments/summary
```

Returns:

- Total Investment
- Investment by Category
- Monthly Spending
- Total Purchased Items

---

# 10. Authentication APIs *(Sprint 4)*

Future endpoints include:

```
POST /api/auth/login

POST /api/auth/logout

POST /api/auth/refresh

POST /api/auth/register
```

---

# 11. HTTP Status Codes

| Code | Description |
|------|-------------|
| 200 | Success |
| 201 | Resource Created |
| 204 | Resource Deleted |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Resource Not Found |
| 409 | Conflict |
| 422 | Validation Failed |
| 500 | Internal Server Error |

---

# 12. Error Response Format

All API errors follow a standardized response format.

Example:

```json
{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "Device not found",
  "path": "/api/devices/1"
}
```

---

# 13. Pagination *(Future)*

Endpoints returning collections may support:

```
?page=0

&size=20

&sort=name,asc
```

Example:

```
GET /api/devices?page=0&size=10&sort=name,asc
```

---

# 14. Filtering *(Future)*

Examples:

```
GET /api/devices?status=ONLINE

GET /api/activities?type=MOTION

GET /api/investments?category=HARDWARE
```

---

# 15. Rate Limiting *(Future)*

To protect backend resources, rate limiting may be introduced.

Example:

```
100 requests/minute
```

---

# 16. Future APIs

Additional APIs planned include:

- User Management
- Role Management
- Automation
- Notifications
- Camera
- Analytics
- OTA Firmware Updates

---

# Conclusion

The Smart Home IoT Platform REST APIs provide a secure, consistent, and scalable communication interface between the frontend application, IoT devices, and backend services.

The API design follows REST principles, standardized response formats, and modular endpoint organization to support both current functionality and future platform expansion while maintaining backward compatibility.
