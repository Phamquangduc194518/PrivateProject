package com.example.demorecycleview

import android.os.AsyncTask
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AsynActivity : AppCompatActivity(), View.OnLongClickListener, View.OnClickListener {
    private lateinit var tvNumber: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asyn)
        findViewById<View>(R.id.btn_click).setOnClickListener(this)
        tvNumber = findViewById(R.id.tv_number)
    }

    override fun onLongClick(p0: View?): Boolean {
        return true
    }

    override fun onClick(view: View) {
        val asy = object : AsyncTask<Int, Int, String>() {
            //            thread khac
            override fun doInBackground(vararg v: Int?): String {
                for (i in v[0]!!..99) {
                    publishProgress(i, i+1)
                    SystemClock.sleep(100)

                }
                return "DONE"
            }

            override fun onProgressUpdate(vararg values: Int?) {
                //main thread
                tvNumber.setText(values[0].toString())
            }

            override fun onPostExecute(result: String) {
                //finish tren ham doInBackground
                tvNumber.setText(result)
            }
        }

        asy.execute(10, 12)
    }
}