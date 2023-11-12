package com.alsomeb.firebaseauthkotlin.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import java.io.IOException

@Configuration
class FirebaseConfig {

    // DOCS
    // https://firebase.google.com/docs/admin/setup

    @Bean
    fun initFireBaseApp() {
        try {
            val serviceAccount = FileInputStream("private_key.json")

            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
            FirebaseApp.initializeApp(options)
        } catch (e: IOException) {
            throw RuntimeException("Error initializing FirebaseApp", e)
        }
    }
}
