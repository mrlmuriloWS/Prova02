package com.example.prova02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var btLogar: Button
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btLogar = findViewById(R.id.bt_logar)
        etEmail = findViewById(R.id.et_email)
        etSenha = findViewById(R.id.et_senha)

        btLogar.setOnClickListener{
            logar()
        }

    }

    private fun logar() {
        var user = Usuario("", etEmail.text.toString(), etSenha.text.toString())

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginHandler = retrofit.create(LoginHandler::class.java)

        var intent = Intent(this@MainActivity, MateriasActivity::class.java)
        intent.putExtra("id_usuario", user.id)
        startActivity(intent)
    }

}