package com.example.telephonebookapp.data.repo

import com.example.telephonebookapp.data.datasource.KisilerDataSource
import com.example.telephonebookapp.data.entity.Kisiler

class KisilerRepository(var kds :KisilerDataSource) {
    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        return kds.kaydet(kisi_ad,kisi_tel)
    }
    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        return kds.guncelle(kisi_id,kisi_ad,kisi_tel)
    }
    suspend fun sil(kisi_id:Int){
        return kds.sil(kisi_id)
    }
    suspend fun kisileriYukle():List<Kisiler>{
        return kds.kisileriYukle()
    }
    suspend fun ara(aramaKelimesi:String):List<Kisiler>{
       return kds.ara(aramaKelimesi)
    }
}