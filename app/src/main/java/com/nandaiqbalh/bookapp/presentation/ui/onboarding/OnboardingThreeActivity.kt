package com.nandaiqbalh.bookapp.presentation.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaiqbalh.bookapp.presentation.ui.home.MainActivity
import com.nandaiqbalh.bookapp.databinding.ActivityOnboardingThreeBinding
import com.nandaiqbalh.bookapp.utils.SharedPrefs

class OnboardingThreeActivity : AppCompatActivity() {

	private var _binding:ActivityOnboardingThreeBinding? = null
	private val binding get() = _binding!!

	private lateinit var sharedPrefs: SharedPrefs

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityOnboardingThreeBinding.inflate(layoutInflater)
		setContentView(binding.root)

		sharedPrefs = SharedPrefs(this)

		if (sharedPrefs.getValue("onboarding").equals("1")){
			val intent = Intent(this@OnboardingThreeActivity, MainActivity::class.java)
			startActivity(intent)
			finishAffinity()
		}

		mainButton()

	}

	private fun mainButton(){

		binding.btnGetStarted.setOnClickListener {

			sharedPrefs.setValue("onboarding", "1")

			val intent = Intent(this@OnboardingThreeActivity, MainActivity::class.java)
			startActivity(intent)
			finishAffinity()
		}

	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}