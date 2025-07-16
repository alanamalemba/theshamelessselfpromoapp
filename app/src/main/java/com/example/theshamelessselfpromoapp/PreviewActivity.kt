package com.example.theshamelessselfpromoapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val contactName = intent.getStringExtra("Contact Name")
        val contactNumber = intent.getStringExtra("Contact Number")
        val displayName = intent.getStringExtra("Display Name")
        val includeJunior = intent.getBooleanExtra("Include Junior",false)
        val jobTitle = intent.getStringExtra("Job Title")
        val immediateStart = intent.getBooleanExtra("Immediate Start",false)
        val startDate = intent.getStringExtra("Start Date")

        val testString = "Contact Name: $contactName, " +
                "Contact Number: $contactNumber, " +
                "Display Name: $displayName, " +
                "Include Junior: $includeJunior, " +
                "Job Title: $jobTitle, " +
                "Immediate Start: $immediateStart, " +
                "Start Date: $startDate"

        val messageTextView: TextView = findViewById(R.id.text_view_message)

        messageTextView.text = testString
    }
}