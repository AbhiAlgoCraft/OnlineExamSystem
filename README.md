# 🎓 Online Examination System (Java Swing)

## 📌 Description

A desktop-based **Online Examination System** developed using **Java Swing, JDBC, and MySQL**.
The system allows users to register, login, take timed exams, and view results. Admin can manage questions.

---

## 🚀 Features

* 🔐 User Registration & Login
* 👥 Role-based Access (Admin / Student)
* 🛠️ Admin Panel (Add Questions)
* 🧪 Exam Interface with Multiple Choice Questions
* ⏱️ Timer-based Exam System
* 📊 Automatic Result Calculation
* 💾 Result Stored in MySQL Database

---

## 🛠️ Tech Stack

* Java (Swing)
* MySQL
* JDBC

---

## ▶️ How to Run

### 🔹 Step 1: Requirements

* Java installed (JDK 8 or above)
* MySQL installed and running

---

### 🔹 Step 2: Setup Database

Open MySQL and run:

```sql
CREATE DATABASE online_exam;
USE online_exam;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(10)
);

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question TEXT,
    opt1 VARCHAR(100),
    opt2 VARCHAR(100),
    opt3 VARCHAR(100),
    opt4 VARCHAR(100),
    correct VARCHAR(100)
);

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    exam_id INT NOT NULL,
    score INT NOT NULL
);
```

---

### 🔹 Step 3: Add Sample User

```sql
INSERT INTO users(name, email, password, role)
VALUES ('Abhi', 'abhi@gmail.com', '1234', 'student');
```

👉 Login using:

* **Email:** [abhi@gmail.com](mailto:abhi@gmail.com)
* **Password:** 1234

---

### 🔹 Step 4: Run Application

#### Option 1 (Simple)

```bash
java -jar OnlineExamSystem.jar
```

#### Option 2 (Recommended)

```bash
java -cp "OnlineExamSystem.jar;lib/mysql-connector-j.jar" LoginUI
```

---

## 📦 Project Files

* `OnlineExamSystem.jar` → Main application
* `lib/` → Contains MySQL Connector JAR
* `src/` → Source code

---

## 📸 Screenshots

### 🔐 Login Screen
![Login](images/login.png)

### 📝 Registration
![Register](images/register.png)

### 🛠️ Admin Panel
![Admin](images/admin-2.png)

### 🧪 Exam Screen
![Exam](images/examscreen.png)

### 📊 Result
![Result](images/resultpopup.png)

---

## 🔮 Future Improvements

* Result history dashboard
* Better UI design
* Web-based version (Spring Boot)
* Charts & analytics

---

## 💡 Author

**Abhinandan Salunke**
