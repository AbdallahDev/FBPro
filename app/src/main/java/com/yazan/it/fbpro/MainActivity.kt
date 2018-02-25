package com.yazan.it.fbpro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var auth=FirebaseAuth.getInstance()

        btn.setOnClickListener {

            if(pw.text.toString().equals(cp.text.toString()))
            {
                auth.createUserWithEmailAndPassword(em.text.toString(),
                        pw.text.toString()).addOnCompleteListener { task ->

                    if(task.isSuccessful)
                        Toast.makeText(this,"User Created",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(this,"Error",
                                Toast.LENGTH_LONG).show()
                }
            }
            else
                Toast.makeText(this,"Password Not Match",
                        Toast.LENGTH_LONG).show()

        }
    }
}
