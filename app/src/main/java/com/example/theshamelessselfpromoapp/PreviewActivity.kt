package com.example.theshamelessselfpromoapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val message = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("message", Message::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("message") as? Message
        }

        val messagePreviewText = """
         ${message?.contactName}, 
         My name is ${message?.myDisplayName} and I am ${message?.getFullJobDescription()}.
         I hava a portfolio of apps to demonstrate my skill.
         I am able to start a new position ${message?.getAvailability()}
         Please get in touch.
         Thanks and best regards
     """.trimIndent()

        val messageTextView:TextView = findViewById(R.id.text_view_message)
        messageTextView.text = messagePreviewText
    }
}