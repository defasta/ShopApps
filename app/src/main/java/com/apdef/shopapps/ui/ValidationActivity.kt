package com.apdef.shopapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apdef.shopapps.R
import kotlinx.android.synthetic.main.activity_validation.*

class ValidationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)

        btn_enter.setOnClickListener {
            val username = et_username.text.toString()
            val pin = et_pin.text.toString()
            if(username.isEmpty() || pin.isEmpty()){
                Toast.makeText(this, "Kolom tidak boleh kosong!",Toast.LENGTH_SHORT).show()
            }else{
                if ( (username == "user1" && pin == "8881") ||  (username == "user2" && pin == "8882") ||  (username == "user3" && pin == "8883") ||  (username == "user4" && pin == "8884") ||  (username == "user5" && pin == "8885")){
                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )
                }else{
                    Toast.makeText(this, "Username atau password tidak valid!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}