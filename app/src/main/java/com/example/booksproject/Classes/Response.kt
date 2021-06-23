package com.example.booksproject.Classes

class Response {
    var status: Int = 0
    var error: Boolean = true
    lateinit var messages: String
    var data = mutableListOf(String)
}