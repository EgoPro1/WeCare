package com.example.wecareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.wecareapp.databinding.ActivityMainBinding
import com.example.wecareapp.databinding.ActivityMainBinding.inflate
import com.example.wecareapp.databinding.ActivitySelectRolBinding


class SelectRolActivity : AppCompatActivity(), AdapterView.OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_rol)

        val binding = ActivitySelectRolBinding.inflate(layoutInflater)
        setContentView(binding.root)

//Recuperamos los elementos del string array
        val countries = resources.getStringArray(R.array.rols)

//Creación del adapter
        val adapter = ArrayAdapter(
            this, // Contexto
            R.layout.lista_item, //Layout del diseño
            countries //Array
        )
        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
            onItemClickListener=this@SelectRolActivity
        }

        val rol=findViewById<Button>(R.id.bt_rol)
        rol.setOnClickListener(){
            val intent = Intent(this, RegisterActivity2::class.java).apply {
                //putExtra("Username",user.name)
            }
            startActivity(intent)
        }

    }


    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long)
    {
        //Recuperamos el item seleccionado por su posición
        val item = parent?.getItemAtPosition(position).toString()
        //Mostramos en un toast del elemento seleccionado
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()
    }
}