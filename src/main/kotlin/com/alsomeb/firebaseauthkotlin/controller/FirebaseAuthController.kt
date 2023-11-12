package com.alsomeb.firebaseauthkotlin.controller

import com.google.firebase.auth.FirebaseAuth
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("api/firebase")
class FirebaseAuthController {

    @GetMapping("user")
    fun getCurrentlyLoggedInUser(principal: Principal): ResponseEntity<String> {
        val uid = principal.name // Firebase UID

        val currentUser = FirebaseAuth.getInstance().getUser(uid)

        return ResponseEntity.ok("Current User UID: ${currentUser.uid} Email: ${currentUser.email}")
    }
}

