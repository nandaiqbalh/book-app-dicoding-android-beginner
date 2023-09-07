package com.nandaiqbalh.bookapp.presentation.ui.home.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.nandaiqbalh.bookapp.R
import com.nandaiqbalh.bookapp.data.model.Book
import com.nandaiqbalh.bookapp.databinding.ActivityDetailBookBinding

class DetailBookActivity : AppCompatActivity() {

	private var _binding: ActivityDetailBookBinding? = null
	private val binding get() = _binding!!

	private lateinit var toolbar: Toolbar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		_binding = ActivityDetailBookBinding.inflate(layoutInflater)
		setContentView(binding.root)
		val data = intent.getParcelableExtra<Book>("data")

		toolbar = findViewById(R.id.toolbar)
		// set toolbar
		setSupportActionBar(toolbar)
		supportActionBar?.title = data?.title
		supportActionBar?.setDisplayShowHomeEnabled(true)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		toolbar.setNavigationIcon(R.drawable.ic_back)

		getData(data)
		actionShare(data)

	}

	private fun getData(data: Book?) {

		if (data != null){
			// atur data
			setData(data)

		}
	}

	private fun setData(data: Book?){
		binding.ivGambarDetailBuku.setImageResource(data?.poster!!)

		binding.tvTitleDetail.text = data.title
		binding.tvDesc.text = data.desc
		binding.tvValueAuthor.text = data.author
		binding.tvValuePublisher.text = data.publisher
		binding.tvValueCategory.text = data.category
		binding.tvValueLanguage.text = data.language
		binding.tvValuePages.text = data.pages


	}

	private fun actionShare(data: Book?){
		binding.btnShare.setOnClickListener {
			val shareIntent = Intent()
			shareIntent.action = Intent.ACTION_SEND
			shareIntent.putExtra(Intent.EXTRA_TEXT, "Hai, ayo bagikan buku ${data!!.title} dengan penulis ${data.author}")
			shareIntent.type = "text/plain"
			startActivity(Intent.createChooser(shareIntent, "Bagikan \"${data.title}\" melalui: "))
		}
	}
	override fun onSupportNavigateUp(): Boolean {
		onBackPressed()
		return super.onSupportNavigateUp()
	}
	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}