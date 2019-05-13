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

class PasswordEditActivity : AppCompatActivity() {
    private val tag = this::class.java.name
    private lateinit var pref: SharedPreferences
    private lateinit var passwordEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_edit)

        pref = getSharedPreferences("test", Context.MODE_PRIVATE)
        passwordEdit = findViewById<EditText>(R.id.password).apply {
            setText(pref.getString("password", ""), TextView.BufferType.EDITABLE)
        }
    }

    fun register(view: View) {
        val pass = findViewById<EditText>(R.id.password).text

        val succeed = pref.edit().run {
            putString("password", pass.toString())
            commit()
        }

        if (succeed) {
            Log.d(tag, "Successfully stored password to the KV store.")
            gotoMainActivity()
        } else {
            Log.e(tag, "Failed to store password in the KV store.")
        }
    }

    private fun gotoMainActivity() {
        Intent(this, MainActivity::class.java).let { intent ->
            startActivity(intent)
        }
    }
}
