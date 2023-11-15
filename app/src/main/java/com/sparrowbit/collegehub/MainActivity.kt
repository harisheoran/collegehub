package com.sparrowbit.collegehub

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sparrowbit.collegehub.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        val isUserLoggedIn = sharedPreferences.getBoolean("isUserLoggedIn", false)
        if (isUserLoggedIn) {
            // User is logged in, redirect to home page
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}