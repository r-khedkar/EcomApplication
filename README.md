# E-Commerce Application

A full-stack e-commerce application built with Spring Boot backend and Angular frontend.

## Project Structure

```
EcomApplication/
├── backend/                 # Spring Boot REST API
│   ├── src/
│   ├── pom.xml
│   ├── mvnw
│   ├── mvnw.cmd
│   └── README.md
├── frontend/                # Angular SPA
│   ├── src/
│   ├── package.json
│   ├── angular.json
│   ├── tsconfig.json
│   └── README.md
├── docker-compose.yml       # Docker orchestration
└── README.md
```

## Quick Start

### Backend Setup
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
Backend runs on: http://localhost:8080

### Frontend Setup
```bash
cd frontend
npm install
npm start
```
Frontend runs on: http://localhost:4200

## Technology Stack

### Backend
- Spring Boot 4.0.6
- Spring Data JPA
- H2 Database
- Maven

### Frontend
- Angular 17
- TypeScript
- RxJS
- CSS3

## API Documentation

### Products
- `GET /api/products` - Get all products
- `GET /api/products/:id` - Get product by ID
- `POST /api/products` - Create product
- `PUT /api/products/:id` - Update product
- `DELETE /api/products/:id` - Delete product

### Orders
- `GET /api/orders` - Get all orders
- `GET /api/orders/:id` - Get order by ID
- `POST /api/orders` - Create order
- `PUT /api/orders/:id` - Update order

## Docker Support

Build and run with Docker Compose:
```bash
docker-compose up -d
```

## License

This project is licensed under the MIT License.
