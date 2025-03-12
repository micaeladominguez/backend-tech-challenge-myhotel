# Backend Tech Challenge - MyHotel

## Setup and Configuration

### Prerequisites
Before setting up the project, ensure you have the following installed:
- **Docker & Docker Compose**
- **Java 17+**
- **Maven**
- **IntelliJ IDEA** (or another preferred IDE)

### Database Setup (MySQL with Docker)
To set up the MySQL database, follow these steps:

1. **Start the database container**
   ```bash
   docker-compose up -d
   ```
2. **Verify the database is running**
   ```bash
   docker ps
   ```
   The container named `myhotel-mysql` should be running.

3. **Connect to MySQL inside the container**
   ```bash
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

### Environment Configuration
Create an `.env` file in the project root with the following content (if needed):

```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=myhotel_db
DB_USER=user
DB_PASSWORD=password
```

### Next Steps
- Configure Spring Boot to connect to the database.
- Implement API endpoints for managing vehicles and employee data.

---

This is the initial setup for the README. As we progress, we will add more sections including how to run the Spring Boot application, API documentation, and testing instructions.