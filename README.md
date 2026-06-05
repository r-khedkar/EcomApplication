# E-Commerce Application

A full-stack e-commerce application built with **Spring Boot** backend and **Angular** frontend, packaged as a monorepo with Docker support.

## 📋 Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Technology Stack](#technology-stack)
- [API Documentation](#api-documentation)
- [Troubleshooting](#troubleshooting)

## 📁 Project Structure

```
EcomApplication/
├── backend/                      # Spring Boot REST API (Port 8080)
│   ├── src/
│   │   ├── main/java/
│   │   ├── main/resources/
│   │   └── test/
│   ├── pom.xml                   # Maven configuration
│   ├── mvnw                      # Maven wrapper (Unix/Linux/Mac)
│   ├── mvnw.cmd                  # Maven wrapper (Windows)
│   ├── Dockerfile                # Backend Docker image
│   └── README.md                 # Backend documentation
│
├── frontend/                     # Angular SPA (Port 4200)
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── services/
│   │   │   ├── models/
│   │   │   └── ...
│   │   ├── assets/
│   │   └── index.html
│   ├── package.json              # NPM dependencies
│   ├── angular.json              # Angular CLI configuration
│   ├── tsconfig.json             # TypeScript configuration
│   ├── Dockerfile                # Frontend Docker image
│   ├── nginx.conf                # Nginx reverse proxy configuration
│   └── README.md                 # Frontend documentation
│
├── docker-compose.yml            # Docker orchestration file
├── DEVELOPMENT.md                # Development guide
├── .gitignore                    # Git ignore rules
└── README.md                     # This file
```

## 📋 Prerequisites

### For Local Development

**Backend Requirements:**
- Java 17 or higher
- Maven 3.6+

**Frontend Requirements:**
- Node.js 18 or higher
- npm 9 or higher
- Angular CLI 17+

**For Docker:**
- Docker 20.10+
- Docker Compose 2.0+

### Installation

**Install Java (Backend):**
```bash
# Ubuntu/Debian
sudo apt-get install default-jdk

# macOS
brew install openjdk@17

# Windows
# Download from https://www.oracle.com/java/technologies/downloads/
```

**Install Node.js (Frontend):**
```bash
# Using Node Version Manager (NVM) - Recommended
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
nvm install 18
nvm use 18

# Or download from https://nodejs.org/
```

**Verify Installation:**
```bash
java -version          # Should show Java 17+
mvn -version          # Should show Maven 3.6+
node -version         # Should show Node 18+
npm -version          # Should show npm 9+
```

## 🚀 Quick Start

### Option 1: Local Development (Recommended for Development)

This setup runs both backend and frontend locally on your machine with live reload capabilities.

#### Step 1: Start the Backend

```bash
# Navigate to backend directory
cd backend

# Clean and install dependencies
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
```

**Expected Output:**
```
Started EcomApplication in X seconds
Tomcat started on port(s): 8080
```

**Backend Services:**
- REST API: http://localhost:8080
- H2 Database Console: http://localhost:8080/h2-console
  - Username: `sa`
  - Password: (leave blank)

#### Step 2: Start the Frontend (New Terminal)

```bash
# Navigate to frontend directory
cd frontend

# Install dependencies
npm install

# Start the development server
npm start
```

**Expected Output:**
```
Application bundle generated successfully.
Angular Live Development Server is listening on localhost:4200
```

**Access the Application:**
- Angular Application: http://localhost:4200
- API calls automatically proxy to http://localhost:8080

### Option 2: Docker Compose (Production-like Environment)

This setup uses Docker containers and is closer to production deployment.

#### Prerequisites
- Docker installed and running
- Docker Compose installed

#### Start All Services

```bash
# Build all images and start containers
docker-compose up -d

# Or with verbose output
docker-compose up

# View logs
docker-compose logs -f

# View specific service logs
docker-compose logs -f backend
docker-compose logs -f frontend
```

**Access the Services:**
- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- H2 Console: http://localhost:8082

#### Stop Services

```bash
# Stop all services
docker-compose down

# Stop and remove volumes (clean state)
docker-compose down -v

# Stop specific service
docker-compose stop backend
docker-compose stop frontend
```

#### Rebuild Images

```bash
# Rebuild all images without cache
docker-compose build --no-cache

# Rebuild specific service
docker-compose build --no-cache backend
docker-compose build --no-cache frontend
```

## 🏗️ Technology Stack

### Backend (Spring Boot)

| Technology | Version | Purpose |
|-----------|---------|---------|
| Spring Boot | 4.0.6 | Web framework |
| Spring Data JPA | 4.0.6 | ORM & database abstraction |
| H2 Database | Latest | In-memory database |
| Maven | 3.6+ | Dependency management |
| Java | 17+ | Programming language |

### Frontend (Angular)

| Technology | Version | Purpose |
|-----------|---------|---------|
| Angular | 17 | Web framework |
| TypeScript | 5.2+ | Programming language |
| RxJS | 7.8+ | Reactive programming |
| Angular CLI | 17 | Development tools |
| npm | 9+ | Package manager |

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Products API

**Get All Products**
```http
GET /api/products
Content-Type: application/json

Response: 200 OK
[
  {
    "id": 1,
    "name": "Product Name",
    "description": "Product Description",
    "price": 99.99,
    "quantity": 10,
    "imageUrl": "https://...",
    "category": "Electronics"
  }
]
```

**Get Product by ID**
```http
GET /api/products/{id}
Content-Type: application/json

Response: 200 OK
{
  "id": 1,
  "name": "Product Name",
  "description": "Product Description",
  "price": 99.99,
  "quantity": 10
}
```

**Create Product**
```http
POST /api/products
Content-Type: application/json

Body:
{
  "name": "New Product",
  "description": "Description",
  "price": 49.99,
  "quantity": 5
}

Response: 201 Created
{
  "id": 2,
  "name": "New Product",
  ...
}
```

**Update Product**
```http
PUT /api/products/{id}
Content-Type: application/json

Body:
{
  "name": "Updated Product",
  "price": 59.99,
  "quantity": 10
}

Response: 200 OK
```

**Delete Product**
```http
DELETE /api/products/{id}

Response: 204 No Content
```

### Orders API

**Get All Orders**
```http
GET /api/orders
Content-Type: application/json

Response: 200 OK
[
  {
    "id": 1,
    "items": [...],
    "totalPrice": 249.99,
    "status": "pending",
    "createdAt": "2026-06-05T10:00:00Z"
  }
]
```

**Create Order**
```http
POST /api/orders
Content-Type: application/json

Body:
{
  "items": [
    {
      "product": {...},
      "quantity": 2
    }
  ],
  "totalPrice": 199.99
}

Response: 201 Created
{
  "id": 1,
  "items": [...],
  "totalPrice": 199.99,
  "status": "pending"
}
```

## 🔧 Common Development Tasks

### Backend

**Run Tests**
```bash
cd backend
mvn test
```

**Run Specific Test**
```bash
mvn test -Dtest=ProductControllerTest
```

**Build JAR**
```bash
mvn clean package
# Output: target/EcomApplication-0.0.1-SNAPSHOT.jar
```

**Skip Tests on Build**
```bash
mvn clean package -DskipTests
```

**Run with Specific Profile**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

### Frontend

**Run Tests**
```bash
cd frontend
npm test
```

**Run Linting**
```bash
npm run lint
```

**Build for Production**
```bash
npm run build
# Output: dist/ecom-frontend/
```

**Build Docker Image**
```bash
docker build -t ecomapp-frontend:1.0 .
```

**Run Development Server with Proxy**
```bash
ng serve --proxy-config proxy.conf.json
```

## 🐛 Troubleshooting

### Backend Issues

**Problem: Port 8080 already in use**
```bash
# Unix/Linux/Mac - Kill process on port 8080
lsof -ti:8080 | xargs kill -9

# Windows - Kill process on port 8080
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

**Problem: Maven command not found**
```bash
# Use Maven wrapper instead
./mvnw clean install          # Unix/Linux/Mac
mvnw.cmd clean install        # Windows
```

**Problem: Java version mismatch**
```bash
# Check installed Java version
java -version

# If wrong version, set JAVA_HOME
export JAVA_HOME=/path/to/java17    # Unix/Linux/Mac
set JAVA_HOME=C:\path\to\java17     # Windows
```

**Problem: H2 Console login fails**
- Use empty password
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`

### Frontend Issues

**Problem: Port 4200 already in use**
```bash
# Unix/Linux/Mac - Kill process on port 4200
lsof -ti:4200 | xargs kill -9

# Windows - Kill process on port 4200
netstat -ano | findstr :4200
taskkill /PID <PID> /F
```

**Problem: npm install fails**
```bash
# Clear npm cache
npm cache clean --force

# Delete node_modules and package-lock.json
rm -rf node_modules package-lock.json

# Reinstall
npm install
```

**Problem: Angular not found**
```bash
# Install Angular CLI globally
npm install -g @angular/cli

# Or use local CLI
npx ng serve
```

**Problem: API calls failing**
```
- Ensure backend is running on http://localhost:8080
- Check browser console (F12) for CORS errors
- Verify API_URL in src/app/services/api.service.ts
```

### Docker Issues

**Problem: Containers won't start**
```bash
# Check Docker daemon
docker ps

# View logs
docker-compose logs

# Rebuild without cache
docker-compose build --no-cache

# Start with verbose output
docker-compose up -v
```

**Problem: Port conflicts in Docker**
```bash
# Check what's using port 8080
docker ps -a

# Stop conflicting containers
docker stop <container-id>

# Or change port in docker-compose.yml
```

**Problem: Out of disk space**
```bash
# Clean up Docker resources
docker system prune -a

# Remove unused volumes
docker volume prune
```

## 📝 Environment Configuration

### Backend (application.properties)

```properties
# Server
server.port=8080
server.servlet.context-path=/

# Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Logging
logging.level.root=INFO
logging.level.com.ecommerce=DEBUG
```

### Frontend (environment.ts)

```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
```

## 🚀 Deployment

### Build Production Packages

**Backend**
```bash
cd backend
mvn clean package -DskipTests
# Creates: target/EcomApplication-0.0.1-SNAPSHOT.jar
```

**Frontend**
```bash
cd frontend
npm run build
# Creates: dist/ecom-frontend/
```

### Deploy with Docker

```bash
# Build images
docker-compose build

# Tag images
docker tag ecomapplication_backend:latest your-registry/ecomapp-backend:1.0
docker tag ecomapplication_frontend:latest your-registry/ecomapp-frontend:1.0

# Push to registry
docker push your-registry/ecomapp-backend:1.0
docker push your-registry/ecomapp-frontend:1.0

# Deploy
docker pull your-registry/ecomapp-backend:1.0
docker pull your-registry/ecomapp-frontend:1.0
docker-compose up -d
```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Angular Documentation](https://angular.io/docs)
- [Docker Documentation](https://docs.docker.com/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [TypeScript Documentation](https://www.typescriptlang.org/docs/)

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📧 Support

For issues and questions, please open an issue on GitHub.

---

**Last Updated:** June 5, 2026
**Maintained By:** Development Team
