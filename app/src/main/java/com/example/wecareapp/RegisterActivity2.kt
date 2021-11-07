package com.example.wecareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.example.wecareapp.Services.RegisterService

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        val registro=findViewById<Button>(R.id.bt_crearC2)
        val nombres=findViewById<AutoCompleteTextView>(R.id.tv_nombre1).text.toString()
        val apellidos=findViewById<AutoCompleteTextView>(R.id.tv_apellido1).text.toString()
        val correo=findViewById<AutoCompleteTextView>(R.id.tv_correo1).text.toString()
        val contrasena=findViewById<AutoCompleteTextView>(R.id.tv_contraseña1).text.toString()
        val esp=findViewById<AutoCompleteTextView>(R.id.tv_especialidad).text.toString()
        val nrocol=findViewById<AutoCompleteTextView>(R.id.tv_nro_colegiatura).text.toString()

      //  RegisterService.enviarWs(nombres,apellidos,correo,contrasena,esp,nrocol);

        registro.setOnClickListener(){
            val intent = Intent(this, SelectorActivity::class.java).apply {
                //putExtra("Username",user.name)
            }
            startActivity(intent)
        }
    }
}