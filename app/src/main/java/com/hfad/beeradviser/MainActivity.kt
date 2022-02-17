package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBook = findViewById<Button>(R.id.find_book)
        findBook.setOnClickListener{
            val bookGenre = findViewById<Spinner>(R.id.book_genre)
            val genre = bookGenre.selectedItem
            val bookList = getBooks(genre.toString())
            val books = bookList.reduce { str, item -> str + '\n' + item }
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = books
        }

        //val brands = findViewById<TextView> (R.id.brands)
        //brands.text = "Gottle of geer"
    }

    fun getBooks(genre: String): List<String> {
        return when (genre) {
            "Horror" -> listOf("The Haunting of Hill House", "Dracula By Bram Stoker")
            "Non Fiction" -> listOf("Crying In H Mart", "Empire of Pain")
            "Literature" -> listOf("Jane Eyre", "The Great Gatsby")
            "Easy Reading" -> listOf("Office Girl", "Station Eleven")
            else -> listOf("Harry Potter Series", "The Lord Of The Rings")
        }
    }
}