# HotelRatingSystem

HotelRatingSystem is a microservices-based application built using Spring Boot that allows users to rate and review hotels. It comprises several microservices, each responsible for a specific functionality.

## Microservices

### 1. Hotel Service

The Hotel Service handles hotel-related operations such as creating, updating, and retrieving hotel information. It provides a RESTful API for other services to interact with hotel data.

### 2. Rating Service

The Rating Service facilitates users in rating and reviewing hotels. It offers functionality for creating, updating, and retrieving ratings and reviews for hotels.

### 3. User Service

The User Service manages user authentication and authorization. It handles user registration, login, and user profile management.


## Technologies Utilized

- Java
- Spring Boot
- Spring Cloud
- Netflix Eureka (Service Discovery)
- Hibernate (Object-Relational Mapping)
- PostgreSQL (Database for Hotel Service)
- MYSQL (Database for User Service)
- MongoDB (Database for Rating Service)


## Getting Started

### Prerequisites

- Java 8 or higher

### Building and Running

1. Clone the repository
2. Build the project using Maven: `mvn clean install`
3. Build Docker images for each microservice
4. Deploy the microservices to your Kubernetes cluster

Refer to the individual microservice README files for more detailed instructions on building, running, and deploying each service.

## Contributing

Contributions are welcome! Please follow the standard GitHub workflow:

1. Fork the repository
2. Create a new branch for your feature/bug fix
3. Commit your changes
4. Push to the branch
5. Create a pull request

Please ensure that your code adheres to the project's coding standards and that you have added appropriate tests.

