package com.example.restapiintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiintegration.UserAdapter.UserAdapter
import com.example.restapiintegration.model.UserViewModel
import com.example.restapiintegration.model.UserViewModelFactory
import com.example.restapiintegration.util.ApiService
import com.example.restapiintegration.util.RetrofitHelper


class MainActivity : AppCompatActivity() {

    lateinit var apiService: ApiService
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserAdapter
    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(emptyList(),this)
        recyclerView.adapter = adapter

        val retrofitclient = RetrofitHelper.get_instance()
        apiService = retrofitclient.create(ApiService::class.java)

        userViewModel = ViewModelProvider(this,UserViewModelFactory(apiService)).get(UserViewModel::class.java)

        userViewModel.users.observe(this, Observer{u->

            if(u.users.isNotEmpty())
            {
                Log.d("Main Activity", u.toString())
                adapter = UserAdapter(u.users,this)
                recyclerView.adapter = adapter
            }
            else{
                Toast.makeText(this,"empty_list",Toast.LENGTH_LONG).show()
            }

        })



    }
}