package com.example.telephonebookapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//json modelini parse ediyor
class RetrofitClient {
    companion object{//static
        fun getClient(baseurl:String): Retrofit {
            return Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}