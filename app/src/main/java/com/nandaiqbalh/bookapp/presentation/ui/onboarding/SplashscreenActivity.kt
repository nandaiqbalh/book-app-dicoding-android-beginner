package com.nandaiqbalh.bookapp.presentation.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.nandaiqbalh.bookapp.R

class SplashscreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splashscreen)

		// full screen
		window.setFlags(
			WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN
		)

		// create variable for splashscreen handler
		val handler = Handler()
		handler.postDelayed({

			val intent = Intent(this@SplashscreenActivity, OnboardingOneActivity::class.java)
			startActivity(intent)
			finish()

		}, 5000)
	}
}