package com.example.uts_pppb_1_nuraziz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts_pppb_1_nuraziz.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityWelcomeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnSubmit.setOnClickListener {
                val username = inputName.text.toString()
                if (username == "") {
                    Toast.makeText(
                        this@WelcomeActivity,
                        "Enter your name first",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@WelcomeActivity, ProfileActivity::class.java)
                    intent.putExtra("EXTRA_USERNAME", username)
                    startActivity(intent)
                }
            }
        }
    }
}