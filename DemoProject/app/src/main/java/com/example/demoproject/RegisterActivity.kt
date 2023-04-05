package com.example.demoproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtConfirmPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        edtUsername = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)
        edtConfirmPassword = findViewById(R.id.edt_confirm_password)

        updateDataFromIntent()

        findViewById<View>(R.id.btn_register).setOnClickListener {
            finishWhenClickRegister()
        }

    }

    private fun finishWhenClickRegister(){
        val intent = Intent()
        intent.putExtra("USERNAME", edtUsername.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun updateDataFromIntent() {
        val type = intent.getStringExtra("TYPE")
        if (type == null) {
            return
        }
        when (type) {
            "NORMAL" -> {
                //lay data ra
                val username = intent.getStringExtra("USERNAME")
                val password = intent.getStringExtra("PASSWORD")
                edtPassword.setText(password)
                edtUsername.setText(username)
            }
            "SER"->{
                val account = intent.getSerializableExtra(
                    "ACCOUNT"
                ) as Account
                edtPassword.setText(account.password)
                edtUsername.setText(account.username)
            }
            "APP"->{
                edtPassword.setText(
                    (applicationContext as MyApp).account?.password
                )
                edtUsername.setText(
                    (applicationContext as MyApp).account?.username
                )
                (applicationContext as MyApp).account = null
            }
        }
    }
}