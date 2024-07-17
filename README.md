JWT Authentication and Authorization with Spring Boot
In this project, we leverage the latest version of Spring Boot to implement JWT (JSON Web Token) authentication and authorization, providing a secure and robust user management system. Here's an overview of the key features and functionalities:

User Registration (Signup API):
We have a signup API that allows users to create their accounts by providing their email, password (encrypted for security), and name. This registration process ensures that user information is stored safely in our system.

User Login (Login API):
The login API checks user credentials, including email and password. If the provided credentials are correct, the system returns a JWT token and a refresh token. These tokens are used for subsequent requests to authenticate and authorize users.

User Access Control:
We have two distinct controllers for admin users and normal users. These users cannot access each other's endpoints. If they attempt to access endpoints reserved for the other user type, the system returns a 403 (Forbidden) response, ensuring strict access control.

Token Refresh API:
In addition to the login API, we provide an endpoint for obtaining a new JWT token when a user's token expires. This feature ensures uninterrupted service for customers, even if their token has expired. The system performs necessary validations before issuing a new token.

With this project, we've created a secure and user-friendly environment for user registration, authentication, and authorization, while also maintaining strict access controls between different user roles. The use of JWT tokens enhances the overall security of the application.
