package com.nandaiqbalh.bookapp.presentation.ui.home.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.nandaiqbalh.bookapp.R

class ProfileActivity : AppCompatActivity() {

	private lateinit var toolbar: Toolbar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_profile)
		// init
		init()

		// atur data
		setData()

	}

	private fun init() {

		toolbar = findViewById(R.id.toolbar)

	}

	private fun setData() {

		// set toolbar
		setSupportActionBar(toolbar)
		supportActionBar?.title = "Profile"
		supportActionBar?.setDisplayShowHomeEnabled(true)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		toolbar.setNavigationIcon(R.drawable.ic_back)
	}

	override fun onSupportNavigateUp(): Boolean {
		onBackPressed()
		return super.onSupportNavigateUp()
	}
}