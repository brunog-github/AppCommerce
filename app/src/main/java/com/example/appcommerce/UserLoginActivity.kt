package com.example.appcommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class UserLoginActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        showToolbar()
        toolbarTitle()

        btnRegister = findViewById(R.id.button_dontRegister)
        btnRegister.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)
        }
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
        textTitle.text = getString(R.string.user_login_title)

        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}