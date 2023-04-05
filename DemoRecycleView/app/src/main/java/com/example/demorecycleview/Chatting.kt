package com.example.demorecycleview

data class Chatting(
    var username: String,
    var imageLink: String,
    var content: String,
    var isClick: Boolean = false
)