package com.example.telephonebookapp.retrofit
//Interfaceye erişmemizi sağlayan class
class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"

        fun getKisilerDao():KisilerDao{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDao::class.java)
        }
    }
}