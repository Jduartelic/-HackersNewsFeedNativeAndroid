package com.hn.hackernewsandroid.navigation

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import com.hn.hackernewsandroid.ui.onboarding.OnboardingActivity
import com.hn.hackernewsandroid.MainActivity
import com.hn.hackernewsandroid.R
import com.hn.hackernewsandroid.domain.Preference.preference
import com.hn.hackernewsandroid.ui.preference.PreferenceActivity

fun NavController.navigateToActivity(context: Context, destinationId: Int) {
    val destination = currentDestination?.getAction(destinationId)?.destinationId ?: return
    val intent = Intent(
        context, when (destination) {
            R.id.mainActivity -> MainActivity::class.java
            R.id.OnboardingActivity -> OnboardingActivity::class.java
            R.id.PreferencesActivity -> PreferenceActivity::class.java
            else -> return
        }
    )
    context.startActivity(intent)
}