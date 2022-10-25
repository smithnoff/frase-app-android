package com.example.fraseapp_4

import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.intellij.lang.annotations.Pattern



class LoginActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    val etPassword by lazy { findViewById<EditText>(R.id.txt_pass) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail=findViewById(R.id.txt_email)
    }



}


