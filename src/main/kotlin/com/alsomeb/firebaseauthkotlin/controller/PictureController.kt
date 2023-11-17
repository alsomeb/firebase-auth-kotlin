package com.alsomeb.firebaseauthkotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

@RestController
@RequestMapping("api/picture")
class PictureController {

    @GetMapping
    fun fetchLamaPicture(): ResponseEntity<ByteArray> {
        val lamaPath = System.getProperty("user.dir") + "\\lama.jpg"

        return try {
            val bytes = Files.readAllBytes(Paths.get(lamaPath))
            ResponseEntity.ok(bytes)
        } catch (e: IOException) {
            ResponseEntity.status(500).build()
        }

    }
}
