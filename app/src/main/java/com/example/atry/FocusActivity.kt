package com.example.atry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_focus.*

class FocusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_focus)

        btnNearby.setOnClickListener {
            goToList()
        }

        btnNews.setOnClickListener {
            goToList()
        }

        btnBestSelling.setOnClickListener {
            goToList()
        }

        btnSby.setOnClickListener {
            goToList()
        }

        btnMlg.setOnClickListener {
            goToList()
        }
    }

    private fun goToList() {
        val intent = Intent (this, ListActivity::class.java)
        startActivity(intent)
    }
}
