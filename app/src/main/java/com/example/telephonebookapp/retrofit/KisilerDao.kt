package com.example.telephonebookapp.retrofit

import com.example.telephonebookapp.data.entity.CRUDCevap
import com.example.telephonebookapp.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//dao = database access object  , burda web servisleri çalıştırıcaz post get felan
interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ -> base url
    //kisiler/tum_kisiler.php -> web servis url
    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle():KisilerCevap

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun kaydet(@Field("kisi_ad") kisi_ad:String,
                       @Field("kisi_tel" )kisi_tel:String):CRUDCevap

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun guncelle(@Field("kisi_id") kisi_id:Int,
                         @Field("kisi_ad") kisi_ad:String,
                         @Field("kisi_tel") kisi_tel:String):CRUDCevap

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun sil(@Field ("kisi_id") kisi_id:Int):CRUDCevap

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun ara(@Field ("kisi_ad") aramaKelimesi:String):KisilerCevap
}