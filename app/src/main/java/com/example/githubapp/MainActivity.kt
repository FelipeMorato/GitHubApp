package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSearch.setOnClickListener{

            buscar()
        }
    }

    private fun buscar() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        val service = retrofit.create(GitHubService::class.java)

        service.buscarUsuario(etUsername.text.toString()).enqueue(object : Callback<Usuario>{
            override fun onFailure(call: Call<Usuario>, t: Throwable) {

            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

            }
        })

    }
}
