package dev.bananaumai.android.practices.kvstore

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val tag = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("test", Context.MODE_PRIVATE)
        val pass = pref.getString("password", "")

        if (pass == "") {
            gotoPasswordEditActivity()
            return
        }

        findViewById<TextView>(R.id.textView).let {
            val newText = "${it.text} '$pass'"
            Log.d(tag, newText)
            it.text = newText
        }
    }

    fun editPassword(view: View) {
        gotoPasswordEditActivity()
    }

    private fun gotoPasswordEditActivity() {
        Intent(this, PasswordEditActivity::class.java).let { intent ->
            startActivity(intent)
        }
    }
}
