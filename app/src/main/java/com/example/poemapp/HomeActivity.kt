package com.example.poemapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.poemapp.models.FormData
import com.example.poemapp.models.Validations.ValidationResult

class HomeActivity : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        username = findViewById(R.id.edtuser)
        password = findViewById(R.id.logpw)



    }
    fun displayAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->

        }
        val dialog = builder.create()
        dialog.show()
    }
    fun login(v:View){
        val myForm = FormData(
            username.text.toString(),
            password.text.toString()
        )
        val UserValidation = myForm.validateusername()
        val PasswordValidation = myForm.validatePassword()

        when (UserValidation){
            is ValidationResult.Valid->{
                count++
            }
            is ValidationResult.Invalid -> {
                username.error = UserValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                username.error = UserValidation.errorMessage
            }
        }
        when(PasswordValidation){
            is ValidationResult.Valid -> {
                count++
            }

            is ValidationResult.Invalid -> {
                password.error = PasswordValidation.errorMessage
            }

            is ValidationResult.Empty -> {
                password.error = PasswordValidation.errorMessage
            }
        }
        if (count == 2){

            val logbutton: Button = findViewById(R.id.logbtn)

            logbutton.setOnClickListener {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            displayAlert("Success","You successfully login")
        }
    }


}





