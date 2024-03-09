package com.example.restapiintegration.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapiintegration.User
import com.example.restapiintegration.UserX
import com.example.restapiintegration.util.ApiService
import com.example.restapiintegration.util.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val apiService: ApiService) : ViewModel() {

    private val _users = MutableLiveData<User>()
    val users: LiveData<User> get() = _users

    init {
        viewModelScope.launch {
            fetchUsers()
        }
    }

    suspend fun fetchUsers() {
        try {
            val userResponse = apiService.getUserInfo()
            _users.value = userResponse.body()
        } catch (e: Exception) {
            Log.d("View Model",e.localizedMessage)

        }
    }

}