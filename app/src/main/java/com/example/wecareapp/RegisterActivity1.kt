package com.example.wecareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.example.wecareapp.Services.RegisterService

class RegisterActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        val registro=findViewById<Button>(R.id.bt_crearC1)
        val nombres=findViewById<AutoCompleteTextView>(R.id.tv_nombre).text.toString()
        val apellidos=findViewById<AutoCompleteTextView>(R.id.tv_apellido).text.toString()
        val correo=findViewById<AutoCompleteTextView>(R.id.tv_correo).text.toString()
        val contrasena=findViewById<AutoCompleteTextView>(R.id.tv_contraseña).text.toString()

        //RegisterService.enviarWs1(nombres,apellidos,correo,contrasena);

        registro.setOnClickListener(){
            val intent = Intent(this, SelectorActivity::class.java).apply {
                //putExtra("Username",user.name)
            }
            startActivity(intent)
        }
    }
}