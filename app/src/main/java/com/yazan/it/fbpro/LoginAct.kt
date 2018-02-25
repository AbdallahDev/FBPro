package com.yazan.it.fbpro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var auth=FirebaseAuth.getInstance()

        login_btn.setOnClickListener {

            auth.signInWithEmailAndPassword(login_em.text.toString(),
                    login_pw.text.toString()).addOnCompleteListener {
                task ->
                if(task.isSuccessful)
                {
                    var i=Intent(this,UploadAct::class.java)
                    startActivity(i)
                }
                else
                    Toast.makeText(this,"Login Fail",
                            Toast.LENGTH_LONG).show()
            }

        }
    }
}
