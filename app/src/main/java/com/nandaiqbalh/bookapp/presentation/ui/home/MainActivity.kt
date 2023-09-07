package com.nandaiqbalh.bookapp.presentation.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaiqbalh.bookapp.R
import com.nandaiqbalh.bookapp.adapter.BookAdapter
import com.nandaiqbalh.bookapp.adapter.BookAdapterHorizontal
import com.nandaiqbalh.bookapp.data.model.Book
import com.nandaiqbalh.bookapp.databinding.ActivityMainBinding
import com.nandaiqbalh.bookapp.presentation.ui.home.detail.DetailBookActivity
import com.nandaiqbalh.bookapp.presentation.ui.home.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding!!

	private val list = ArrayList<Book>()

	private lateinit var toolbar: Toolbar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		list.addAll(getBookList())

		setRecyclerView()

		aturData()
	}

	private fun setRecyclerView(){
		binding.rvBook.layoutManager = LinearLayoutManager(this)
		binding.rvBook.adapter = BookAdapter(list){

			// jika dipencet akan ke halaman detail
			val intent = Intent(this@MainActivity, DetailBookActivity::class.java).putExtra("data", it)
			startActivity(intent)
		}

		// horizontal
		binding.rvBookHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
		binding.rvBookHorizontal.adapter = BookAdapterHorizontal(list){
			// jika dipencet akan ke halaman detail
			val intent = Intent(this@MainActivity, DetailBookActivity::class.java).putExtra("data", it)
			startActivity(intent)
		}
	}

	private fun aturData(){

		toolbar = findViewById(R.id.toolbar)
		// set toolbar
		setSupportActionBar(toolbar)
		supportActionBar?.title = "BookApp"
		supportActionBar?.setDisplayShowHomeEnabled(true)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		toolbar.navigationIcon = null
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {

		menuInflater.inflate(R.menu.menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val id = item.itemId

		if (id == R.id.profile){
			val intent = Intent(this@MainActivity, ProfileActivity::class.java)
			startActivity(intent)
		}
		return true
	}
	@SuppressLint("Recycle")
	private fun getBookList(): ArrayList<Book> {
		val dataPoster = resources.obtainTypedArray(R.array.poster)
		val dataTitle = resources.getStringArray(R.array.title)
		val dataDesc = resources.getStringArray(R.array.desc)
		val dataAuthor = resources.getStringArray(R.array.author)
		val dataPublisher = resources.getStringArray(R.array.publisher)
		val dataCategory = resources.getStringArray(R.array.category)
		val dataLanguage = resources.getStringArray(R.array.language)
		val dataPages = resources.getStringArray(R.array.page)

		val listBook = ArrayList<Book>()
		for (i in dataTitle.indices) {
			val book = Book(
				title = dataTitle[i],
				desc = dataDesc[i],
				publisher = dataPublisher[i],
				category = dataCategory[i],
				author = dataAuthor[i],
				language = dataLanguage[i],
				pages = dataPages[i],
				poster = dataPoster.getResourceId(i, -1),

				)

			listBook.add(book)
		}
		return listBook
	}
}