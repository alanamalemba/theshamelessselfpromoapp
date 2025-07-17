package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit private var contactNameEditText: TextInputEditText
    lateinit private var contactNumberEditText: TextInputEditText
    lateinit private var myDisplayNameEditText: TextInputEditText
    lateinit private var startDateEditText: TextInputEditText
    lateinit private var juniorCheckBox: CheckBox
    lateinit private var immediateStartCheckBox: CheckBox
    lateinit private var jobTitleSpinner: Spinner
    lateinit private var previewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactNameEditText = findViewById(R.id.edit_text_contact_name)
        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
        startDateEditText = findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)

        previewButton = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClick()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")

        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)

        jobTitleSpinner?.adapter = spinnerAdapter
    }

    private fun onPreviewClick() {

        val message = Message(
                contactNameEditText.text.toString(),
                contactNumberEditText.text.toString(),
                myDisplayNameEditText.text.toString(),
                juniorCheckBox.isChecked,
                jobTitleSpinner.selectedItem.toString(),
                immediateStartCheckBox.isChecked,
                startDateEditText.text.toString(),

                )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

        previewActivityIntent.putExtra("Contact Name", message.contactName)
        previewActivityIntent.putExtra("Contact Number", message.contactNumber)
        previewActivityIntent.putExtra("Display Name", message.myDisplayName)
        previewActivityIntent.putExtra("Include Junior", message.includeJunior)
        previewActivityIntent.putExtra("Job Title", message.jobTitle)
        previewActivityIntent.putExtra("Immediate Start", message.immediateStart)
        previewActivityIntent.putExtra("Start Date", message.startDate)

        startActivity(previewActivityIntent)
    }
}