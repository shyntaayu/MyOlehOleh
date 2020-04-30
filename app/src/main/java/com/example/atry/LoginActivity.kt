package com.example.atry

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val email=inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val progressDialog = ProgressDialog(this, R.style.Theme_AppCompat_Light_Dialog)
            progressDialog.isIndeterminate=true
            progressDialog.setMessage("Loading...")
            progressDialog.show()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if(!it.isSuccessful){
                    return@addOnCompleteListener
                    val intent=Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                progressDialog.hide()
            }.addOnFailureListener {
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Email or Password incorrect", Toast.LENGTH_SHORT).show()
                progressDialog.hide()
            }
        }
    }
}
