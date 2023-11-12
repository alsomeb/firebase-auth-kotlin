# Firebase with Spring Security App
This is a sample Spring Boot application that integrates Firebase Authentication with Spring Security. The application demonstrates how to verify Firebase JWTs on the server side using the Firebase Admin SDK.

## Prerequisites
Before running the application, make sure you have the following dependencies:
```
    implementation 'com.google.firebase:firebase-admin:9.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server'
    implementation 'org.springframework.boot:spring-boot-starter-security'
```

## Configuration
Before running the application, configure the Firebase Admin SDK with your own Firebase project credentials.

- Check **src/config/FirebaseConfig.kt** for help

## Endpoints
**GET /api/firebase/user:** Get information about the currently logged-in user.
