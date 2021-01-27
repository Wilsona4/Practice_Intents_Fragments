package com.funcrib.practice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial)

//      Get intent content
        val number: String? = intent.getStringExtra("DIGITS")

        val phoneNumber = findViewById<TextView>(R.id.phoneNumber).apply { text = number }
        val dial = findViewById<Button>(R.id.dial)

        dial.setOnClickListener {
            Toast.makeText(this, "Dialing $number", Toast.LENGTH_SHORT).show()

//          Create intent, choose action and provide date
            val callIntent = Intent().apply {
                action = Intent.ACTION_DIAL
                data = Uri.parse("tel:${phoneNumber.text}")

            }

//          Verify that the intent will resolve to an activity
            if (callIntent.resolveActivity(packageManager) != null) {
                startActivity(callIntent)
            }
        }
    }
}