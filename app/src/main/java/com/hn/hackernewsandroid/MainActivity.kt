package com.hn.hackernewsandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.hn.hackernewsandroid.ui.onboarding.OnboardingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val hasSeenOnBoarding = getSharedPreference()

        if (hasSeenOnBoarding == true) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }


        val initialActivity = R.layout.activity_main
        setContentView(initialActivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun getSharedPreference(): Boolean? {
        val sharedPreferences: SharedPreferences? = getSharedPreferences(
            "MyPrefs", Context.MODE_PRIVATE
        )

        val userHasSeenOnboarding =
            sharedPreferences?.getBoolean("userHasSeenOnboarding", false)
        Log.i(userHasSeenOnboarding.toString(), "getSharedPreference: ")

        return userHasSeenOnboarding
    }
}