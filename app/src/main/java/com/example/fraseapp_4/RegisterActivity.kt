package com.example.fraseapp_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.fraseapp_4.databinding.ActivityLoginUserBinding
import com.example.fraseapp_4.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.butRegirter.setOnClickListener { validate() }
    }

    private fun validate(){
        val result = arrayOf(validateEmail(),validatePassword1(),validatePassword2())

        if (false in result) {
            return
        } else if (binding.password1RegisterEditText?.text.toString()!=binding.password2RegisterEditText?.text.toString()){
            binding.password2RegisterContainer.error="Password does not match"
            false
            return
        }
        Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,LoginUser:: class.java))
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1-> R.layout.activity_login_user
            else -> return true
        }
        finish()
        return super.onOptionsItemSelected(item)
    }

    private fun validateEmail() : Boolean{
        val email = binding.emailRegisterEditText?.text.toString()
        return if (email.isEmpty()){
            binding.emailRegisterContainer.error="Field can not be empty"
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailRegisterContainer.error="Please enter a valid email address"
            false
        }else{
            binding.emailRegisterContainer.error= null
            true
        }
    }

    private fun validatePassword1() : Boolean{
        val password = binding.password1RegisterEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^"+
                    "(?=.*[0-9])"+ //Al menos un dígito
                    ".{8,}" +  //Al menos 8 caracteres
                    "$"

        )
        return if (password.isEmpty()){
            binding.passwordRegisterContainer.error="Field can not be empty"
            false
        }else if(!passwordRegex.matcher(password).matches()){
            binding.passwordRegisterContainer.error="Password is too weak"
            false
        }else{
            binding.passwordRegisterContainer.error= null
            true
        }

    }

    private fun validatePassword2() : Boolean{
        val password = binding.password2RegisterEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^"+
                    "(?=.*[0-9])"+ //Al menos un dígito
                    ".{8,}" +  //Al menos 8 caracteres
                    "$"

        )
        return if (password.isEmpty()){
            binding.password2RegisterContainer.error="Field can not be empty"
            false
        }else if(!passwordRegex.matcher(password).matches()){
            binding.password2RegisterContainer.error="Password is too weak"
            false
        }else{
            binding.password2RegisterContainer.error= null
            true
        }

    }
}