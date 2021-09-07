package com.example.appcommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class UserRegisterActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        showToolbar()
        toolbarTitle()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun showToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun toolbarTitle(){
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.user_register_titulo)

        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}