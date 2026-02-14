# 🔐 Secure Email Analyzer

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-Educational-blue.svg)](LICENSE)

## 📌 Overview
**Secure Email Analyzer** is a full-stack Spring Boot web application designed to detect **suspicious and phishing emails**.
The project focuses on **security, clean architecture, and real-world backend practices**, making it suitable for academic evaluation and backend job applications.

The application allows authenticated users to:
- 📧 Analyze email content for suspicious patterns
- 🎯 Detect threats using an intelligent scoring system
- 📊 View a personal history of all analyses
- 🔒 Secure authentication and data protection

---

## 📑 Table of Contents
- [Why This Project Matters](#-why-this-project-matters)
- [Features](#-features)
- [Tech Stack](#️-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [How It Works](#-how-it-works)
- [Database Schema](#-database-schema)
- [API Endpoints](#-api-endpoints)
- [Testing](#-testing)
- [Security](#-security)
- [Future Improvements](#-future-improvements)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [Author](#-author)
- [License](#-license)

---

## 🎯 Why This Project Matters
Email phishing is one of the **most common cybersecurity threats**, accounting for over 90% of successful cyberattacks. This project demonstrates:
- ✅ Secure authentication with Spring Security
- ✅ Backend business logic separation
- ✅ Persistent storage of security-related data
- ✅ A scalable base for future AI / ML integration
- ✅ Production-ready code patterns and best practices

---

## 🧠 Features

### 🔑 Authentication & Security
- User registration with validation
- Secure login with session management
- Password hashing with **BCrypt**
- Password strength validation (minimum 8 characters)
- Role-based access control (RBAC)
- CSRF protection
- Session timeout management

### 📧 Email Analysis
- Keyword-based detection engine
- Multi-factor risk scoring system
- Explanation of detected risks with matched keywords
- Support for subject and body analysis
- Severity classification (Low, Medium, High, Critical)

### 🕓 History Tracking
- Each analysis is automatically saved per user
- Private access to personal analysis history
- Sorted by most recent first
- Timestamp tracking for all analyses
- Detailed view of past results

### 🧩 Clean Architecture
- MVC pattern with clear separation of concerns
- DTOs for secure data transfer
- Service layer for business logic
- Repository layer with Spring Data JPA
- Custom exception handling
- Input validation and sanitization

---

## 🛠️ Tech Stack

**Backend**
- Java 21
- Spring Boot 3.x
- Spring MVC
- Spring Security 6.x
- Spring Data JPA
- Hibernate ORM
- Maven 3.8+

**Frontend**
- Thymeleaf 3.x
- HTML5
- CSS3
- Bootstrap 5 (optional)

**Database**
- H2 Database (development/testing)
- PostgreSQL / MySQL (production-ready)

**Build & Tools**
- Maven
- Git
- Lombok (optional)

---

## 📂 Project Structure

```
email-analyzer/
├── src/
│   ├── main/
│   │   ├── java/com/secureemailanalyzer/
│   │   │   ├── controller/          # MVC Controllers
│   │   │   │   ├── UserController.java
│   │   │   │   ├── EmailAnalyzerController.java
│   │   │   │   └── HistoryController.java
│   │   │   ├── service/             # Business Logic
│   │   │   │   ├── UserService.java
│   │   │   │   ├── EmailAnalysisService.java
│   │   │   │   └── HistoryService.java
│   │   │   ├── repository/          # Data Access Layer
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── AnalysisRepository.java
│   │   │   ├── entity/              # JPA Entities
│   │   │   │   ├── User.java
│   │   │   │   └── EmailAnalysis.java
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   ├── UserRegistrationDTO.java
│   │   │   │   ├── EmailAnalysisDTO.java
│   │   │   │   └── AnalysisResultDTO.java
│   │   │   ├── security/            # Security Configuration
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── UserDetailsServiceImpl.java
│   │   │   └── SecureEmailAnalyzerApplication.java
│   │   └── resources/
│   │       ├── templates/           # Thymeleaf Templates
│   │       ├── static/              # CSS, JS, Images
│   │       └── application.properties
│   └── test/                        # Unit & Integration Tests
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- **Java 21** or higher
- **Maven 3.8+**
- **Git**
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installation & Setup

1. **Clone the repository**
```bash
git clone https://github.com/hendisantika/email-analyzer.git
cd email-analyzer
```

2. **Build the project**
```bash
mvn clean install
```

3. **Run the application**
```bash
mvn spring-boot:run
```

4. **Access the application**
```
Open your browser and navigate to:
👉 http://localhost:8080
```

### Default Configuration
- **Port**: 8080
- **Database**: H2 (in-memory)
- **H2 Console**: http://localhost:8080/h2-console
- **JDBC URL**: jdbc:h2:mem:emailanalyzer

---

## 🔄 How It Works

1. **User Registration**
   - New users create an account with username, email, and password
   - Passwords are validated and hashed using BCrypt

2. **Authentication**
   - Users log in with credentials
   - Spring Security manages sessions and authentication

3. **Email Analysis**
   - User submits email content (subject + body)
   - Analysis engine scans for suspicious keywords and patterns
   - Risk score is calculated based on detected threats

4. **Results Display**
   - Analysis results show risk level and matched keywords
   - Results are automatically saved to user's history

5. **History Access**
   - Users can view all past analyses
   - History is private and user-specific

---

## 🗄️ Database Schema

### User Table
| Column       | Type         | Constraints           |
|--------------|--------------|----------------------|
| id           | BIGINT       | PRIMARY KEY, AUTO    |
| username     | VARCHAR(50)  | UNIQUE, NOT NULL     |
| email        | VARCHAR(100) | UNIQUE, NOT NULL     |
| password     | VARCHAR(255) | NOT NULL             |
| role         | VARCHAR(20)  | DEFAULT 'USER'       |
| created_at   | TIMESTAMP    | DEFAULT CURRENT_TIME |

### EmailAnalysis Table
| Column          | Type         | Constraints           |
|-----------------|--------------|----------------------|
| id              | BIGINT       | PRIMARY KEY, AUTO    |
| user_id         | BIGINT       | FOREIGN KEY (User)   |
| email_subject   | VARCHAR(255) | NOT NULL             |
| email_body      | TEXT         | NOT NULL             |
| risk_score      | INTEGER      | NOT NULL             |
| detected_risks  | TEXT         |                      |
| analyzed_at     | TIMESTAMP    | DEFAULT CURRENT_TIME |

---

## 🌐 API Endpoints

### Authentication
| Method | Endpoint           | Description              | Access  |
|--------|-------------------|--------------------------|---------|
| GET    | `/register`        | Show registration form   | Public  |
| POST   | `/register`        | Register new user        | Public  |
| GET    | `/login`           | Show login form          | Public  |
| POST   | `/login`           | Authenticate user        | Public  |
| POST   | `/logout`          | Logout user              | Auth    |

### Email Analysis
| Method | Endpoint           | Description              | Access  |
|--------|-------------------|--------------------------|---------|
| GET    | `/analyze`         | Show analysis form       | Auth    |
| POST   | `/analyze`         | Submit email for analysis| Auth    |
| GET    | `/result`          | View analysis result     | Auth    |

### History
| Method | Endpoint           | Description              | Access  |
|--------|-------------------|--------------------------|---------|
| GET    | `/history`         | View analysis history    | Auth    |
| GET    | `/history/{id}`    | View specific analysis   | Auth    |

---

## 🧪 Testing

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=EmailAnalysisServiceTest
```

### Generate Test Coverage Report
```bash
mvn clean test jacoco:report
```

The coverage report will be available at: `target/site/jacoco/index.html`

---

## 🔒 Security

### Implemented Security Measures
- ✅ Password encryption with BCrypt (strength: 10 rounds)
- ✅ CSRF protection enabled
- ✅ SQL injection prevention via JPA parameterized queries
- ✅ XSS protection through Thymeleaf auto-escaping
- ✅ Session management and timeout
- ✅ Role-based access control
- ✅ Input validation and sanitization

### Security Configuration
The application uses Spring Security with the following configuration:
- Form-based authentication
- Custom login page
- Remember-me functionality (optional)
- Session fixation protection
- Logout with session invalidation

---

## 📈 Future Improvements

This project was intentionally built with extensibility in mind. Planned enhancements include:

### Short-term
- [ ] Email header analysis (SPF, DKIM, DMARC)
- [ ] URL reputation checking via external APIs
- [ ] Export analysis history to PDF/CSV
- [ ] Email templates for common phishing patterns

### Medium-term
- [ ] REST API version with JWT authentication
- [ ] Admin dashboard for system monitoring
- [ ] Multi-language support (i18n)
- [ ] Enhanced reporting and statistics

### Long-term
- [ ] Machine Learning integration for advanced detection
- [ ] LLM-based email content analysis
- [ ] Real-time email monitoring
- [ ] Dockerization and Kubernetes deployment
- [ ] Microservices architecture

---

## 🔧 Troubleshooting

### Common Issues

**Problem**: Application fails to start
```
Solution: Check if port 8080 is already in use
```

**Problem**: Database connection errors
```
Solution: Verify H2 configuration in application.properties
```

**Problem**: Login fails after registration
```
Solution: Check password meets minimum requirements (8+ characters)
```

**Problem**: "403 Forbidden" errors
```
Solution: Ensure CSRF token is included in forms
```

### Configuration

To change the default port, add to `application.properties`:
```properties
server.port=8081
```

To use PostgreSQL instead of H2:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emailanalyzer
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style
- Follow Java naming conventions
- Write meaningful commit messages
- Add unit tests for new features
- Update documentation as needed

---

## 👨‍💻 What This Project Demonstrates

This project showcases:
- ✅ Solid understanding of **Spring Boot & Spring Security**
- ✅ Clean code and layered architecture
- ✅ Secure handling of user data and authentication
- ✅ Ability to design scalable backend systems
- ✅ Database design and JPA/Hibernate usage
- ✅ RESTful principles and MVC pattern
- ✅ Good software engineering practices
- ✅ Documentation and code organization

---

## 📝 Author

**Hendi Santika**
Backend Java Developer

- GitHub: [@hendisantika](https://github.com/hendisantika)
- Email: hendi.santika@example.com

---

## 📜 License

This project is for **educational and demonstration purposes**.
Feel free to use it as a learning resource or portfolio piece.

---

## 🙏 Acknowledgments

- Spring Framework team for excellent documentation
- The open-source community for inspiration
- All contributors and supporters

---

<div align="center">
  <p>Made with ☕ and Spring Boot</p>
  <p>⭐ Star this repository if you find it helpful!</p>
</div>