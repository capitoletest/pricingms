  # Pricing Microservice

## Technologies Used

- **Java** 17  
- **Spring Boot** 3.1.4  
- **H2 Database** – In-memory database used for development and testing  
- **Flyway** – Database migration management  
- **Swagger (OpenAPI)** – Auto-generated interactive REST API documentation  
- **Hexagonal Architecture** – Clean architecture with separation of concerns  
- **Checkstyle** – Static code analysis for code quality  
- **JaCoCo** – Test coverage reporting  
- **Docker** – Containerization for deployment  

## Key Features

- 🛠 **Hexagonal architecture** ensures maintainability and scalability.
- 🧪 **Integration and unit testing** with 100% test coverage using JUnit and JaCoCo.
- 🚀 **Flyway** used for initializing the database schema and data.
- 📄 **Swagger UI** available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- ✅ **Code quality enforced** with Checkstyle.
- 🐳 **Docker support** for seamless deployment and testing environments.

## Project Structure

```
src/
├── main/
│   ├── java/com/capitole/inditex/pricingms/
│   │   ├── application/       # Business logic and use cases
│   │   │   ├── command/       # DTOs for input
│   │   │   ├── response/      # DTOs for output
│   │   │   ├── service/       # Core service logic
│   │   │   └── usecase/       # Interfaces for use cases
│   │   ├── domain/            # Domain models
│   │   ├── infrastructure/    
│   │   │   ├── adapter/       
│   │   │   │   ├── in/rest/   # Controllers (input ports)
│   │   │   │   └── out/jpa/   # Repository adapters (output ports)
│   │   │   ├── config/        # Spring and Swagger configurations
│   │   │   ├── entity/        # JPA entities
│   │   │   └── exception/     # Global exception handling
│   │   └── utils/             # Constants, helpers, utilities
│   └── resources/
│       ├── db/migration/      # Flyway SQL scripts
│       └── application.yml    # Main application configuration
└── test/
    └── java/com/capitole/inditex/pricingms/
        ├── application/service/        # Integration tests for services
        ├── infrastructure/adapter/     # Integration tests for controllers and repos
        ├── config/                     # Base test config
        ├── exception/                  # Exception handler tests
        └── PricingmsApplicationTests   # Main application test
```

## Running the Application

### ✅ With Docker

1. Build Docker image:
   ```bash
   docker build -t pricingms .
   ```

2. Run container:
   ```bash
   docker run -p 8080:8080 pricingms
   ```

3. Access Swagger:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

### 🖥 Locally (without Docker)

1. Clone the repo:
   ```bash
   git clone <REPO_URL>
   cd pricingms
   ```

2. Run the application:
   ```bash
   ./gradlew bootRun 
   ```

3. Access Swagger:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## ✅ Run Tests and Coverage Report

To run all unit and integration tests and generate the JaCoCo report:

```bash
./gradlew test jacocoTestReport
```

View the report at:

```
build/reports/jacoco/test/html/index.html
```

## Quality Tools

- **Checkstyle**: Enforces coding standards (`checkstyle.xml`)
- **JaCoCo**: Ensures test coverage
- **Coveralls plugin**: (optional) For reporting coverage to Coveralls

## API Documentation

The API exposes a `/api/prices` endpoint that receives a `POST` request with brandId, productId, and applicationDate, returning the applicable price details. Swagger is automatically generated and accessible during runtime.

---

For more details, please refer to the official documentation:  
👉 **[https://capitoletest.github.io/documentation/](https://capitoletest.github.io/documentation/)**
