package com.example.telephonebookapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telephonebookapp.data.entity.Kisiler
import com.example.telephonebookapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var krepo:KisilerRepository) :ViewModel(){
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
            kisileriYukle()
        }
    }
    init {
        kisileriYukle()
    }

    fun kisileriYukle(){
        //eğer veritabanından hiçbir nesne gelmezse uygulama çökmesin diye
        try {
            CoroutineScope(Dispatchers.Main).launch {
                kisilerListesi.value= krepo.kisileriYukle()
            }
        }catch (e:Exception){}

    }
    fun ara(aramaKelimesi:String){
        //eğer veritabanından hiçbir nesne gelmezse uygulama çökmesin diye
        try {
            CoroutineScope(Dispatchers.Main).launch{
                kisilerListesi.value=krepo.ara(aramaKelimesi)
            }
        }catch (e:Exception){}

    }
}