# Backend Tech Challenge - MyHotel

## Setup and Configuration

### Prerequisites
Before setting up the project, ensure you have the following installed:
- **Docker & Docker Compose**
- **Java 17+**
- **Maven**
- **IntelliJ IDEA** (or another preferred IDE)

---

##  Database Setup (MySQL with Docker)

To set up the MySQL database, follow these steps:

1. **Start the database container**
   ```sh
   docker-compose up -d
   ```
2. **Verify the database is running**
   ```sh
   docker ps
   ```
   The container named `myhotel-mysql` should be running.

3. **Connect to MySQL inside the container**
   ```sh
   docker exec -it myhotel-mysql mysql -u user -p
   ```
   Enter the password: `password`

4. **Check database and tables**
   ```sql
   SHOW DATABASES;
   USE myhotel_db;
   SHOW TABLES;
   ```

The database is now ready to be used in the application.

---

## Environment Configuration

Create an `.env` file in the project root with the following content (if needed):

```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=myhotel_db
DB_USER=user
DB_PASSWORD=password
```

Also, make sure that `application.properties` or `application.yml` contains the correct database configuration:

```properties
spring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## Running the Application

### Option 1: Running Locally

1. **Clone the repository**
   ```sh
   git clone https://github.com/your-username/backend-tech-challenge-myhotel.git
   cd backend-tech-challenge-myhotel
   ```

2. **Build the project**
   ```sh
   mvn clean install
   ```

3. **Run the Spring Boot application**
   ```sh
   mvn spring-boot:run
   ```

The application will be available at:  
 `http://localhost:8080/`

---

### Option 2: Running with Docker

If you prefer to run everything inside Docker containers:

1. **Build and start the services**
   ```sh
   docker-compose up --build
   ```

   This will:
   - Start a MySQL container.
   - Build and run the backend.

2. **Verify the application is running**
   ```
   http://localhost:8080/
   ```

3. **Stop the containers**
   ```sh
   docker-compose down
   ```

   If you also want to remove database data:
   ```sh
   docker-compose down -v
   ```

---

## Running Tests

To run all tests:

```sh
mvn clean test
```

If you want to compile without running tests:

```sh
mvn clean install -DskipTests
```

---

## API Endpoints

### Employee Endpoints

| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET`  | `/employees/salary-segments` | Get salary segments |
| `GET`  | `/employees/top-paid` | Get top-paid employees by department |
| `GET`  | `/employees/experienced-managers` | Get experienced managers |
| `GET`  | `/employees/salary-stats/country` | Get salary statistics by country |

Example request:

```sh
curl -X GET http://localhost:8080/employees/salary-segments
```

---

## Project Structure

```
backend-tech-challenge-myhotel/
│── src/
│   ├── main/
│   │   ├── java/com/myhotel/employees/   # Application source code
│   │   ├── resources/                     # Configurations (application.properties)
│   ├── test/                              # Test cases
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
```

---

## Notes

- If the application fails to connect to MySQL, ensure the database container is running.
- If there are dependency issues, try running:
  ```sh
  mvn clean install -U
  ```
- For any issues or suggestions, feel free to open an issue in the repository.

---

