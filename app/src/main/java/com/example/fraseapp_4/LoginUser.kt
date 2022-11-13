package com.example.fraseapp_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.fraseapp_4.databinding.ActivityLoginUserBinding
import com.example.fraseapp_4.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class LoginUser : AppCompatActivity() {

    private lateinit var binding : ActivityLoginUserBinding
    // lateinit var textEmail: TextInputEditText
    //lateinit var textPassword: TextInputEditText
    //lateinit var containerTextEmail: TextInputLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butLogin.setOnClickListener{validate()}

      //  textEmail = findViewById(R.id.emailEditText)
        // textPassword = findViewById(R.id.passwordEditText)
        // containerTextEmail = findViewById(R.id.emailContainer)
        //  emailFocusLinstener()
    }

    private fun validate(){
        val result = arrayOf(validateEmail(),validatePassword())

        if (false in result){
            return
        }
        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
    }

    private fun validateEmail() : Boolean{
        val email = binding.emailEditText?.text.toString()
        return if (email.isEmpty()){
            binding.emailContainer.error="Field can not be empty"
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailContainer.error="Please enter a valid email address"
            false
        }else{
            binding.emailContainer.error= null
            true
        }
    }

    private fun validatePassword() : Boolean{
        val password = binding.passwordEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^"+
                    "(?=.*[0-9])"+ //Al menos un dígito
                    ".{8,}" +  //Al menos 8 caracteres
                    "$"

        )
                return if (password.isEmpty()){
                    binding.passwordContainer.error="Field can not be empty"
                    false
                }else if(!passwordRegex.matcher(password).matches()){
                    binding.passwordContainer.error="Password is too weak"
                    false
                }else{
                    binding.passwordContainer.error= null
                    true
                }

    }

}