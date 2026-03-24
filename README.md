# Secure-aws-app
# 🔐 Secure AWS Application – Apache + Spring Boot

## 📌 Overview

This project implements a **secure and scalable web application deployed on AWS**, composed of two main components:

* **Frontend Server (Apache)**: Serves an asynchronous HTML + JavaScript client.
* **Backend Server (Spring Boot)**: Provides RESTful API services.

The system ensures **secure communication, authentication, and proper deployment practices** using cloud infrastructure.

---

## 🏗️ Architecture

The application follows a **multi-server architecture**:

* 🌐 Apache Server (EC2 Instance 1)

  * Hosts static files (HTML, JS, CSS)
  * Acts as the client interface

* ⚙️ Spring Boot Server (EC2 Instance 2)

  * Handles authentication and backend logic
  * Exposes REST endpoints

---

## 🔐 Security Features

* **TLS/HTTPS (Optional / Bonus)**
* **CORS Configuration**
* **Spring Security Configuration**
* **Password-based Authentication**
* **Secure API Communication**
* **AWS Security Groups Configuration**

---

## 🚀 Technologies Used

* Java 17
* Spring Boot
* Apache HTTP Server
* HTML, CSS, JavaScript (Fetch API)
* AWS EC2
* Maven

---

## 📁 Project Structure

```
secure-aws-app/
│
├── frontend/
│   ├── index.html
│   ├── app.js
│   └── styles.css
│
└── backend/
    └── secure-app/
        ├── src/main/java/escueliang/tdse/secure_app/
        │   ├── controller/
        │   ├── model/
        │   └── config/
        └── pom.xml
```

---

## ⚙️ Backend Setup (Spring Boot)

### 1. Compile project

```bash
mvn clean package
```

### 2. Run application

```bash
java -jar target/secure-app-0.0.1-SNAPSHOT.jar
```

### 3. Run in background (recommended)

```bash
nohup java -jar target/secure-app-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
```

---

## 🌐 Frontend Setup (Apache)

### 1. Install Apache

```bash
sudo dnf install httpd -y
```

### 2. Start service

```bash
sudo systemctl start httpd
sudo systemctl enable httpd
```

### 3. Deploy frontend

```bash
sudo cp -r frontend/* /var/www/html/
```

---

## 🔗 Frontend ↔ Backend Connection

Edit `app.js`:

```javascript
const BACKEND_URL = "http://<BACKEND_PUBLIC_IP>:8080";
```

---

## 🔐 API Endpoint

### Login

```
POST /login
```

### Request Body

```json
{
  "username": "admin",
  "password": "1234"
}
```

### Response

```
Login successful
```

---

## ⚠️ Common Issues & Fixes

### ❌ 401 Unauthorized

✔ Fix: Configure Spring Security (`SecurityConfig`)

### ❌ CORS Error

✔ Fix: Enable global CORS in Spring Security

### ❌ 404 Not Found

✔ Fix: Ensure `@RequestMapping("/login")`

### ❌ Port 8080 in use

✔ Fix:

```bash
pkill -9 java
```

---

## ☁️ AWS Deployment

### EC2 Instances

* Apache Server
* Spring Boot Server

### Security Groups

| Port | Purpose     |
| ---- | ----------- |
| 22   | SSH         |
| 80   | HTTP        |
| 8080 | Backend API |

---

## 🧪 Testing

* Access frontend:

```
http://<APACHE_PUBLIC_IP>
```

* Perform login using:

```
admin / 1234
```

---

## 📸 Evidences EC2

<img width="948" height="794" alt="Captura de pantalla 2026-03-22 202611" src="https://github.com/user-attachments/assets/bd8c90e8-6888-464b-bd3b-127e43367aa5" />
<img width="943" height="771" alt="Captura de pantalla 2026-03-22 202601" src="https://github.com/user-attachments/assets/c48385bb-d80d-44d3-b447-d9d749999394" />
<img width="930" height="198" alt="Captura de pantalla 2026-03-22 201840" src="https://github.com/user-attachments/assets/6c0f688b-940c-4098-a754-b067859ad792" />
<img width="930" height="739" alt="Captura de pantalla 2026-03-22 200834" src="https://github.com/user-attachments/assets/56e7e677-15d1-408b-b5d9-3cb1d2105fcf" />


---

## 📈 Future Improvements

* 🔐 HTTPS with Let's Encrypt
* 🔄 Reverse Proxy (Apache → Spring Boot)
* 🔑 JWT Authentication
* 🛡️ Role-based access control

---

## 👨‍💻 Author

Nicole Calderón
TDSE - 2026

---

