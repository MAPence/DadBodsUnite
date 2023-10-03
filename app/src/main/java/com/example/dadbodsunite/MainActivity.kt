package com.example.dadbodsunite

import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dadbodsunite.ui.theme.DadBodsUniteTheme
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    private lateinit var loginButton: Button
    private lateinit var webView: WebView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (isLoginValid(username, password)) {

            val inflater = LayoutInflater.from(this)

        } else {
            Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
        }
        }
    }
    private fun isLoginValid(username: String, password: String): Boolean {

        return username == "admin" && password == "password"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadBodsUniteTheme {
        Greeting("Android")
    }
}