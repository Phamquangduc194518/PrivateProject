package com.example.btfilemanager

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionStore()
    }

    private fun permissionStore() {
        val pers = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
        for (per in pers) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, per)) {
                return
            }
        }
        val perNotGrant = mutableListOf<String>()
        for (per in pers) {
            if (ContextCompat.checkSelfPermission(this, per) != PackageManager.PERMISSION_GRANTED) {
                perNotGrant.add(per)
            }
            if (perNotGrant.size > 0) {
                ActivityCompat.requestPermissions(this, perNotGrant.toTypedArray(), 101)
            } else {
                readExtra()
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    openSetting()
                }
            }
            readExtra()
        }
    }

    private fun openSetting() {
        AlertDialog.Builder(this).setTitle("Setting")
            .setMessage("Do you want open Setting")
            .setPositiveButton("Yes") { dialog, index ->
                run {
                    //mo open setting
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val data = Uri.fromParts("package", packageName, null)
                    intent.setData(data)
                    startActivityForResult(intent, 100)
                }
            }
            .setNegativeButton("No") { dialog, index -> }
            .show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            val pers = arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            )
            for (per in pers) {
                if (ActivityCompat.checkSelfPermission(this, per)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
            }
            readExtra()
        }
    }
    private fun readExtra() {
        return
    }
}