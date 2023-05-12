package com.example.btfilemanager.model

import android.net.Uri

data class ImageItem(
    val contentUri: String,
    val name: String, // Tên của tập tin hoặc thư mục
//    val path: String, // Đường dẫn đến tập tin hoặc thư mục
    val date: Long, // Ngày thêm hoặc sửa
//    val size: String, // Kích thước của tập tin hoặc thư mục
//    val isDirectory: Boolean // Cho biết đó có phải là thư mục hay không
)