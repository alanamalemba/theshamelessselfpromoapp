package com.example.theshamelessselfpromoapp

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String,
    val immediateStart: Boolean,
    val startDate: String
)