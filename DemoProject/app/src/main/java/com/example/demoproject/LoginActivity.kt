package com.example.demoproject

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.transition.Transition
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget

class LoginActivity : AppCompatActivity(), OnClickListener, View.OnLongClickListener {
    companion object {
        val TAG = LoginActivity.javaClass.simpleName
    }

    private lateinit var tvSignUp: TextView
    private lateinit var btnLogin: Button
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var ivImg: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate conten log....")
        setContentView(R.layout.login_activity)
        tvSignUp = findViewById<TextView>(R.id.tv_signup)
        btnLogin = findViewById(R.id.btn_login)
        edtUsername = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)
        ivImg = findViewById(R.id.iv_img)

//        tvSignUp.setOnClickListener(
//            object : OnClickListener {
//                override fun onClick(view: View) {
//
//                }
//            }
//        )
//        btnLogin.setOnClickListener(
//            object : OnClickListener {
//                override fun onClick(view: View) {
//
//                }
//            }
//        )
        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)

        btnLogin.setOnLongClickListener(this)
        tvSignUp.setOnLongClickListener(this)

        findViewById<View>(R.id.tv_open_browser).setOnClickListener(this)
        findViewById<View>(R.id.tv_open_galary).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> {
                Toast.makeText(this, "Click login...", Toast.LENGTH_SHORT).show()
            }
            R.id.tv_signup -> {
                Toast.makeText(this, "Click sign up...", Toast.LENGTH_SHORT).show()
//                openRegisterActivity()
                openRegisterAndSendDataObjFromApp()
            }
            R.id.tv_open_browser -> {
                openBrowser()
            }
            R.id.tv_open_galary -> {
                openGallery()
            }
        }
    }

    private fun openBrowser() {
        val link = "https://www.facebook.com"
        val intent = Intent()
        //intent khong tuong minh phai set Action
        intent.action = Intent.ACTION_VIEW
        intent.setData(Uri.parse(link))
        startActivityForResult(intent, 10)
    }

    private fun openGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_PICK
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 10)
    }

    override fun onLongClick(view: View): Boolean {

        return true
    }

    private fun openRegisterActivity() {
        val intent = Intent()
        intent.setClass(this, RegisterActivity::class.java)
        //dua data vao
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()
        intent.putExtra("USERNAME", username)
        intent.putExtra("PASSWORD", password)
        intent.putExtra("TYPE", "NORMAL")
//        cho thuyen chay
        startActivity(intent)
    }

    private fun openRegisterAndSendDataObj() {
        val intent = Intent()
        intent.setClass(this, RegisterActivity::class.java)
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()
        intent.putExtra("TYPE", "SER")
        intent.putExtra(
            "ACCOUNT", Account(username, password)
        )
        startActivity(intent)
    }

    private fun openRegisterAndSendDataObjFromApp() {
        val intent = Intent()
        intent.setClass(this, RegisterActivity::class.java)
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()
        val account = Account(username, password)
        intent.putExtra("TYPE", "APP")
        (applicationContext as MyApp).account = account

//        startActivity(intent)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            100 -> {
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(
                        this,
                        data?.getStringExtra("USERNAME"),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            10 -> {
                if (resultCode == Activity.RESULT_OK) {
                    Glide.with(this)
                        .load(R.drawable.loading)
                        .into(ivImg)
                    Glide.with(this)
//                        .load(data?.data)
                        .asBitmap()
                        .load("https://c4.wallpaperflare.com/wallpaper/173/61/119/asian-women-model-ao-dai-wallpaper-preview.jpg")
                        .apply(RequestOptions().override(ivImg.width, ivImg.height))
                        .into(object : CustomTarget<Bitmap>() {
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                            ) {
                                ivImg.setImageBitmap(resource)
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                            }
                        })
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume conten log....")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause conten log....")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy conten log....")
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        Log.d(TAG, "onBackPressed conten log....")
    }


}