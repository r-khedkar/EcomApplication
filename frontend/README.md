# E-Commerce Frontend

This is an Angular-based frontend application for the E-commerce Application built with Java backend.

## Features

- **Product Listing** - Browse all available products
- **Product Details** - View detailed information about products  
- **Shopping Cart** - Add/remove products and manage quantities
- **Checkout** - Place orders through the checkout process
- **Responsive Design** - Mobile-friendly UI

## Prerequisites

- Node.js (v18 or higher)
- Angular CLI (v17 or higher)

## Installation

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

## Configuration

Update the API base URL in `src/app/services/api.service.ts`:
```typescript
private apiUrl = 'http://localhost:8080/api';
```

## Development Server

```bash
npm start
```

Navigate to `http://localhost:4200/`.

## Build

```bash
npm run build
```

## API Endpoints Expected

- `GET /api/products` - Get all products
- `GET /api/products/:id` - Get product by ID  
- `POST /api/orders` - Create a new order

## License

This project is part of the E-commerce Application.
