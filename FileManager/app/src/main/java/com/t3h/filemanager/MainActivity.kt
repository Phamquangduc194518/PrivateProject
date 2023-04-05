package com.t3h.filemanager

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.webkit.MimeTypeMap
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File


class MainActivity : AppCompatActivity(), FileManagerAdapter.IFileManagerAdapter {
    private val itemFiles = mutableListOf<ItemFile>()
    private lateinit var rcFileManager: RecyclerView
    private lateinit var adapter: FileManagerAdapter
    private var currentParentPath = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcFileManager = findViewById(R.id.rc_file_manager)
        rcFileManager.layoutManager = LinearLayoutManager(this)
        adapter = FileManagerAdapter(this)
        rcFileManager.adapter = adapter
        permissionStore()
    }

    private fun permissionStore() {
        val pers = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )

        for (per in pers) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, per)) {
                openSetting()
                return
            }
        }
        //check 2 permission xem duoc dong y chua
        val persNotGrant = mutableListOf<String>()
        for (per in pers) {
            if (ContextCompat.checkSelfPermission(this, per) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                persNotGrant.add(per)
            }
        }
        if (persNotGrant.size > 0) {
            //hien thi de nguoi dung dong y quyen
            ActivityCompat.requestPermissions(
                this,
                persNotGrant.toTypedArray(), 101
            )
        } else {
            readExternal()
        }


    }

    private fun openSetting() {
        AlertDialog.Builder(this)
            .setTitle("Setting")
            .setMessage("Do you want to open setting?")
            .setPositiveButton("Yes", { dialog, index ->
                run {
                    //mo open setting
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val data = Uri.fromParts("package", packageName, null)
                    intent.setData(data)
                    startActivityForResult(intent, 100)
                }
            })
            .setNegativeButton("No", { dialog, index -> })
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
            //da dong y het
            readExternal()
        }
    }

    //khi nguoi dung dung dong y, hoac khong dong y quyen, thi se vao phuong thuc nay
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    return
                }
            }
            readExternal()
        }
    }

    private fun readExternal(
        parent: String =
            Environment.getExternalStorageDirectory().path
    ) {
        currentParentPath = parent
        //start read
        //lay thu muc goc
//        val root = Environment.getExternalStorageDirectory()
        val file = File(parent)
        val listFile = file.listFiles()
        if (listFile != null) {
            for (f in listFile) {
                itemFiles.add(
                    ItemFile(
                        f.name, f.path,
                        if (f.isFile) R.drawable.ic_insert_drive_file_purple_500_48dp
                        else R.drawable.ic_folder_purple_500_48dp
                    )
                )
            }
        }
        adapter.notifyDataSetChanged()
    }

    override fun onClickItem(position: Int) {
        val file = File(itemFiles[position].path)
        if (file.isDirectory) {
            itemFiles.clear()
            readExternal(file.path)
        } else {
            val mintype = getMimeType(file.path)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            val uri = FileProvider.getUriForFile(
                this,
                getApplicationContext().getPackageName() + ".provider",
                file
            )
            intent.setDataAndType(uri, mintype)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent)
        }

    }

    override fun getSize(): Int {
        return itemFiles.size
    }

    override fun getData(position: Int): ItemFile {
        return itemFiles[position]
    }

    override fun onBackPressed() {
        if (currentParentPath.equals(
                Environment.getExternalStorageDirectory().path
            )
        ) {
            finish()
            return
        }
        val currentFile = File(currentParentPath)
        itemFiles.clear()
        readExternal(currentFile.parent)
    }

    fun getMimeType(url: String): String {
        var type: String? = null
        val ff = File(url)
        var extension = MimeTypeMap.getFileExtensionFromUrl(url)
        if (extension == null || extension.equals("")) {
            val name = ff.name
            if (name.contains(".")) {
                extension = name.substring(name.lastIndexOf(".") + 1)
            }
        }
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        }
        if (type == null) {
            return "*/*"
        }
        return type
    }
}