package com.example.wecareapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wecareapp.api.RetroInstance
import com.example.wecareapp.model.Specialist
import com.example.wecareapp.model.SpecialistResponse
import com.example.wecareapp.model.User
import com.example.wecareapp.model.UserResponse
import com.example.wecareapp.services.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateLogUserVM: ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<UserResponse?>
    init {
        createNewUserLiveData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<UserResponse?> {
        return createNewUserLiveData
    }


    fun createNewUser(user: User): Boolean {
        var success= false
        val retroService  = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val call = retroService.createLog(user)
        call.enqueue(object: Callback<UserResponse?> {
            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                    success= true
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {

                createNewUserLiveData.postValue(null)
            }
        })

        return success
    }
}


