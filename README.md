
---

# Product Management System

This is a simple Product Management System built using Spring Boot, JPA, and MySQL. It provides basic CRUD operations for managing products.

## Features

- Add a new product
- View all products
- Update existing product details
- Delete a product
- Retrieve a product by its ID

## Project Structure

### Model

#### `Product.java`

Represents a product entity with the following fields:

- `id`: Integer (Primary Key)
- `title`: String
- `description`: String
- `price`: Double
- `quantity`: Integer

### DTO

#### `ProductDto.java`

A Data Transfer Object (DTO) used to transfer product data between processes. It contains the same fields as the `Product` entity.

### Service

#### `ProductService.java`

Interface defining the methods for product operations:

- `Boolean saveProduct(ProductDto productDto)`: Saves a product to the database.
- `List<ProductDto> getAllProducts()`: Retrieves all products from the database.
- `ProductDto getByProductId(Integer id)`: Retrieves a product by its ID.
- `Boolean deleteProduct(Integer id)`: Deletes a product by its ID.

#### `ProductServiceImplementation.java`

Implements the `ProductService` interface. Uses a `ProductRepository` and `ModelMapper` to perform operations.

### Repository

#### `ProductRepository.java`

A Spring Data JPA repository for the `Product` entity. Provides methods for CRUD operations.

### Configuration

#### `ProjectConfig.java`

Contains Spring configuration for the project, including a `ModelMapper` bean.

## Database Configuration

The project uses MySQL for data storage. The database configuration is specified in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productmanagementsystem
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Adventure@25
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## Dependencies

This project uses the following dependencies:

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Thymeleaf
- MySQL Connector/J
- ModelMapper
- Lombok (optional, for reducing boilerplate code)
- Spring Boot DevTools (for development)
- Spring Boot Starter Test (for testing)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- MySQL 8.0 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/shivaakira12/productmanagementsystem.git
   ```

2. Navigate to the project directory:

   ```bash
   cd product-management-system
   ```

3. Create a MySQL database:

   ```sql
   CREATE DATABASE productmanagementsystem;
   ```

4. Update the `application.properties` file with your MySQL credentials.

5. Build and run the project:

   ```bash
   mvn spring-boot:run
   ```

6. Access the application at `http://localhost:8080`.

## Usage

You can interact with the Product Management System via RESTful APIs:

- **Add a Product:** `POST /api/products/save`
- **Get All Products:** `GET /api/products/getAllProducts`
- **Get Product by ID:** `GET /api/products/{id}`
- **Update a Product:** `PUT /api/products/update`
- **Delete a Product:** `DELETE /api/products/{id}`

## Contributing

Feel free to submit issues or pull requests to improve this project.

## Contact

For any inquiries, please contact [shivaakira000@gmail.com](mailto:shivaakira000@gmail.com).

---
