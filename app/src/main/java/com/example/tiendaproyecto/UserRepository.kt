package com.example.tiendaproyecto

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserRepository (private val dataSource: FirebaseAuth) {

    public fun loggedIn(): FirebaseUser?{
        return dataSource.currentUser
    }
}