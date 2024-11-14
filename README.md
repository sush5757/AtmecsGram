# AtmecsGram Project - Documentation

This repository contains the **AtmecsGram** project, which is a **full-stack** social media platform. The backend enables users to interact, follow other users, and post content, while the frontend provides a user interface for interacting with the system. The backend is composed of three key services: **User Service**, **Follow Service**, and **AtmecsGram Service**, and the frontend is built with **Angular**.

The services are designed using **Spring Boot** and communicate with each other through a **Service Registry** with **Eureka** for service discovery.

## Project Overview

### Services Overview:
1. **User Service**: Manages user-related functionalities such as user registration, login, and retrieving user information.
2. **Follow Service**: Handles following and unfollowing of users and manages the relationship between followers and followees.
3. **AtmecsGram Service**: Manages posts, including creating posts, retrieving posts by users, and liking posts.

### Technologies Used:
- **Backend**:
  - **Spring Boot** for building the REST APIs.
  - **Eureka** for Service Discovery (Service Registry).
  - **Spring Data JPA** for persistence.
  - **Swagger** for API documentation.
  
- **Frontend**:
  - **Angular** for building the frontend application.
  - **Angular CLI 18.0.3**.
  - **Node.js 20.14.0**.
  - **npm 10.7.0**.

## Frontend Overview

The frontend of the **ATMecsGram** project is built with **Angular**. The application leverages **Angular CLI 18.0.3** and the following environment:

- **Angular CLI**: 18.0.3
- **Node.js**: 20.14.0
- **npm**: 10.7.0
- **Angular**: 18.0.2
- **Operating System**: Windows 32-bit (x64)

### Components:
1. **Signup**: Handles user registration.
2. **Login**: Manages user authentication.
3. **Home**: Displays posts and general content for the user.
4. **UserTile**: Displays user information in a compact card.
5. **Suggestions**: Shows suggestions for users to follow.
6. **Post**: Displays individual posts.
7. **Create Post**: Allows the user to create a new post.
8. **Custom Button**: A reusable button component used throughout the app.

## Backend Architecture

The backend system is designed in a **microservices architecture** with each service performing a specific role. The services are registered with **Eureka** as the service registry, allowing them to dynamically discover and communicate with each other.

### Eureka Client and Service Registry

All services in this system act as **Eureka Clients** and register themselves with a **Eureka Server**. This allows each service to be discovered by others, enabling dynamic interaction between them without needing to manually configure their IP addresses or URLs.

### Service Communication

Each service communicates with others using HTTP requests, and the Eureka Client handles the service discovery to make these calls more flexible and fault-tolerant.

## Backend Project Structure

- **User Service**: Handles user-related operations like registration, login, and fetching user details.
- **Follow Service**: Manages follower and following relationships between users.
- **ATMecsGram Service**: Manages posts, including creating posts, retrieving posts, and liking posts.

### Folder Structure:



### Folder Structure:

```
atmecsgram-backend
│
├── user-service
│   ├── src/main/java/com/atmecsgram/user/
│   └── src/main/resources/application.properties
│
├── follow-service
│   ├── src/main/java/com/atmecsgram/follow/
│   └── src/main/resources/application.properties
│
└── atmecsgram-service
    ├── src/main/java/com/atmecsgram/post/
    └── src/main/resources/application.properties
```
## Backend Setup and Configuration

### 1. Eureka Server Configuration

Ensure that the Eureka server is up and running. You can configure the Eureka Server in a separate Spring Boot application, or use a public Eureka instance.

In your `application.properties` of each service, configure the Eureka server URL:

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/  # Replace with your Eureka server URL
spring.application.name=user-service  # Change for each service
```

### 2. Service Configuration

Each service is a Spring Boot application with the following configurations:

- **User Service**: Manages user-related operations like registration, login, and fetching user details.
- **Follow Service**: Manages follower and following relationships between users.
- **ATMecsGram Service**: Manages posts, including creating posts, retrieving posts, and liking posts.

Each service should be annotated with `@EnableDiscoveryClient` to register itself with Eureka.

Example for User Service:

```java
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
```

### 3. Load Balancing with `RestTemplate` or `WebClient`

To enable service communication, use `RestTemplate` or `WebClient` with the `@LoadBalanced` annotation. This ensures that the client service can resolve the target service dynamically via Eureka.

#### Example with `RestTemplate`:

```java
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

#### Example with `WebClient`:

```java
@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
```

### 4. Swagger Integration

To document the APIs, we have integrated **Swagger**. This allows you to explore the endpoints of each service in the browser.

Add the following dependency for Swagger in your `pom.xml`:

```xml
<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.6.0</version>
		</dependency>
```

Swagger documentation will be accessible via:

```
http://localhost:8080/swagger-ui/index.html
```

Each service will expose its API documentation there.

## Services and Endpoints

### 1. **User Service Endpoints**
- `POST /user/signup`: Create a new user.
- `POST /user/login`: Login with email and password.
- `GET /user/{id}`: Get user details by ID.
- `GET /user`: Get all users.
- `PUT /user/{id}`: Update user details by ID.

### 2. **Follow Service Endpoints**
- `POST /follow/{followerId}/follow/{followingId}`: Follow a user.
- `GET /follow/{userId}/following`: Get the list of users being followed by the user.
- `GET /follow/followers/{userId}`: Get the list of followers for the user.
- `DELETE /follow/{followerId}/unfollow/{followingId}`: Unfollow a user.

### 3. **ATMecsGram Service Endpoints**
- `POST /home/post`: Create a post.
- `GET /home/post`: Get all posts.
- `GET /home/post/{userId}`: Get posts by a specific user.
- `PUT /home/post/{id}`: Update a post by ID.
- `DELETE /home/post/{id}`: Delete a post by ID.
- `POST /home/post/{id}/like`: Like a post.

## How to Run the Backend

1. Clone this repository:

```bash
git clone https://github.com/your-username/atmecsgram-backend.git
cd atmecsgram-backend
```

2. Build and run each service:

For example, to run **User Service**:

```bash
cd user-service
mvn clean install
mvn spring-boot:run
```

Similarly, run the **Follow Service** and **ATMecsGram Service**.

3. Make sure the **Eureka Server** is running at `http://localhost:8761`.

4. Access the Swagger UI for each service at `http://localhost:<port>/swagger-ui/index.html`.

## Future Enhancements

- **Frontend Integration**: A frontend application will be added later to interact with these backend services.
- **Authentication**: Future plans include integrating JWT-based authentication and authorization for securing endpoints.
- **Additional Features**: Explore adding features like comments, notifications, and more.

## Conclusion

This backend system is designed to be scalable and flexible, using Spring Boot microservices, Eureka for service discovery, and Swagger for API documentation. The frontend will be integrated later, but the backend is fully functional for handling user accounts, following relationships, and posts.
