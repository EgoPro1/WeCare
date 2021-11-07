package com.example.wecareapp.Services

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONException
import org.json.JSONObject
import java.util.*

abstract class RegisterService {

     fun LeerWs() {
        val url = "https://jsonplaceholder.typicode.com/posts/11"
        val postResquest = StringRequest(
            Request.Method.GET, url,
            { response ->
                try {
                    val jsonObject = JSONObject(response)
                    //  txtUser.setText(jsonObject.getString("userId"));
                    val title = jsonObject.getString("title")
                    //    txtTitle.setText(title);
                    //    txtBody.setText(jsonObject.getString("body"));
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        ) { error -> Log.e("Error", error.message!!) }
        // Volley.newRequestQueue(this).add(postResquest);
    }

    fun enviarWs(
        nombres: String,
        apellidos: String,
        correo: String,
        contrasena: String,
        esp: String,
        nrocol: String
    ) {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val postResquest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener {
                //       Toast.makeText(MainActivity.this, "RESULTADO POST = " + response, Toast.LENGTH_LONG).show();
            },
            Response.ErrorListener { error -> Log.e("Error", error.message!!) }) {
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["nombres"] = nombres
                params["apellidos"] = apellidos
                params["correo"] = correo
                params["contraseña"] = contrasena
                params["especialidad"] = esp
                params["numero de colegiatura"] = nrocol
                return params
            }
        }
        //     Volley.newRequestQueue(this).add(postResquest);
    }
    fun enviarWs2(
        nombres: String,
        apellidos: String,
        correo: String,
        contrasena: String,

    ) {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val postResquest: StringRequest = object : StringRequest(
            Method.POST, url,
            Response.Listener {
                //       Toast.makeText(MainActivity.this, "RESULTADO POST = " + response, Toast.LENGTH_LONG).show();
            },
            Response.ErrorListener { error -> Log.e("Error", error.message!!) }) {
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["nombres"] = nombres
                params["apellidos"] = apellidos
                params["correo"] = correo
                params["contraseña"] = contrasena
                return params
            }
        }
        //     Volley.newRequestQueue(this).add(postResquest);
    }

     fun actualizarWs(title: String, body: String, userId: String) {
        val url = "https://jsonplaceholder.typicode.com/posts/1"
        val postResquest: StringRequest = object : StringRequest(
            Method.PUT, url,
            Response.Listener {
                //        Toast.makeText(MainActivity.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
            },
            Response.ErrorListener { error -> Log.e("Error", error.message!!) }) {
            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["id"] = "1"
                params["title"] = title
                params["body"] = body
                params["userId"] = userId
                return params
            }
        }
        //    Volley.newRequestQueue(this).add(postResquest);
    }

     fun eliminarWs() {
        val url = "https://jsonplaceholder.typicode.com/posts/1"
        val postResquest = StringRequest(Request.Method.DELETE, url, {
            //       Toast.makeText(MainActivity.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
        }
        ) { error -> Log.e("Error", error.message!!) }
        //   Volley.newRequestQueue(this).add(postResquest);
    }

}