package com.example.dadbodsunite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dadbodsunite.ui.theme.DadBodsUniteTheme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : ComponentActivity() {
    private lateinit var loginButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var usersRef: DatabaseReference
    val signUpButton = findViewById<Button>(R.id.signUpButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        usersRef = FirebaseDatabase.getInstance().reference.child("users")

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        val userId = firebaseAuth.currentUser?.uid
                        if (userId != null) {
                            // Check admin status from Firebase Realtime Database
                            usersRef.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    val isAdmin = dataSnapshot.child("admin").getValue(Boolean::class.java)
                                    if (isAdmin == true) {
                                        // Navigate to the admin screen
                                        val intent = Intent(this@MainActivity, AdminActivity::class.java)
                                        startActivity(intent)
                                    } else {
                                        // For non-admin users, handle it here
                                        Toast.makeText(this@MainActivity, "Welcome, non-admin user!", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    // Handle database read errors here
                                }
                            })
                        }
                    } else {
                        // Sign in failed, display an error message
                        Toast.makeText(this@MainActivity, "Invalid login credentials", Toast.LENGTH_SHORT).show()
                    }
                })
            signUpButton.setOnClickListener {
                // Add code to navigate to the sign-up screen or perform sign-up actions.
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
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