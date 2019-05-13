package dev.bananaumai.android.practices.kvstore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val tag = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val txt = findViewById<EditText>(R.id.password).text
        Log.d(tag, "password is $txt")
        Intent(this, DisplayPasswordActivity::class.java).let { intent ->
            startActivity(intent)
        }
    }
}
