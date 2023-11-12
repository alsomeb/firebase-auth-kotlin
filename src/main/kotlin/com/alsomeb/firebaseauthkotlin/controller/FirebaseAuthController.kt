package com.alsomeb.firebaseauthkotlin.controller

import com.google.firebase.auth.FirebaseAuth
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@RestController
@RequestMapping("api/firebase")
class FirebaseAuthController {

    /*
     - The endpoint has verified the Firebase ID token from the client.
     - The getUser method fetches the user details associated with the UID obtained from the token.
     - The response contains information about the currently logged-in user, such as UID and email.
     */
    @GetMapping("user")
    fun getCurrentlyLoggedInUser(principal: Principal): ResponseEntity<String> {
        val uid = principal.name // Firebase UID
        val currentUser = FirebaseAuth.getInstance().getUser(uid)

        // Convert Instant to LocalDateTime in Stockholm time zone
        val zoneIdSthlm = ZoneId.of("Europe/Stockholm")
        val latestSignIn = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentUser.userMetadata.lastSignInTimestamp), zoneIdSthlm)

        return ResponseEntity.ok("Current User UID: ${currentUser.uid} Email: ${currentUser.email} Last Sign in: $latestSignIn")
    }
}

