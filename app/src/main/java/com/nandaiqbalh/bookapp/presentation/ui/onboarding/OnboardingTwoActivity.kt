package com.nandaiqbalh.bookapp.presentation.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaiqbalh.bookapp.presentation.ui.home.MainActivity
import com.nandaiqbalh.bookapp.databinding.ActivityOnboardingTwoBinding
import com.nandaiqbalh.bookapp.utils.SharedPrefs

class OnboardingTwoActivity : AppCompatActivity() {

	private var _binding:ActivityOnboardingTwoBinding? = null
	private val binding get() = _binding!!

	private lateinit var sharedPrefs:SharedPrefs

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityOnboardingTwoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		sharedPrefs = SharedPrefs(this)

		if (sharedPrefs.getValue("onboarding").equals("1")){
			val intent = Intent(this@OnboardingTwoActivity, MainActivity::class.java)
			startActivity(intent)
			finishAffinity()
		}

		mainButton()
	}

	private fun mainButton(){

		// next
		binding.btnNext.setOnClickListener {
			val intent = Intent(this@OnboardingTwoActivity, OnboardingThreeActivity::class.java)
			startActivity(intent)
		}

		binding.btnSkip.setOnClickListener {

			sharedPrefs.setValue("onboarding", "1")

			val intent = Intent(this@OnboardingTwoActivity, MainActivity::class.java)
			startActivity(intent)
			finishAffinity()
		}

	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}