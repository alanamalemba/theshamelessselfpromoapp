package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("message", Message::class.java)
                ?: throw IllegalArgumentException("Message is missing in intent extras")
        } else {
            @Suppress("DEPRECATION")
            (intent.getSerializableExtra("message") as? Message)
                ?: throw IllegalArgumentException("Message is missing in intent extras")
        }


        messagePreviewText = """
             ${message?.contactName}, 
             My name is ${message?.myDisplayName} and I am ${message?.getFullJobDescription()}.
             I hava a portfolio of apps to demonstrate my skill.
             I am able to start a new position ${message?.getAvailability()}
             Please get in touch.
             Thanks and best regards
         """.trimIndent()

        val messageTextView: TextView = findViewById(R.id.text_view_message)
        messageTextView.text = messagePreviewText
    }

    private fun setupButton() {
        val sendMessageButton: Button = findViewById(R.id.button_send_message)

        sendMessageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}") // ensures only sms apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }

    }
}