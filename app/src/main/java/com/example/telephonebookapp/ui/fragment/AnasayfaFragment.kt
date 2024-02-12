package com.example.telephonebookapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.telephonebookapp.R
import com.example.telephonebookapp.data.entity.Kisiler
import com.example.telephonebookapp.databinding.FragmentAnasayfaBinding
import com.example.telephonebookapp.ui.adapter.KisilerAdapter
import com.example.telephonebookapp.ui.viewmodel.AnasayfaViewModel
import com.example.telephonebookapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var viewModel:AnasayfaViewModel
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        binding.anasayfaFragment=this

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter=kisilerAdapter
        }



        binding.anasayfaToolbarBaslik="Kişiler"

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }


    fun fabTikla(it:View){
       Navigation.gecisYap(it,R.id.kisiKayitGecis)
    }

    //Bu , sayfaya veri ekleyip sildiğimiz zaman geri döndüğümüzde ekranı en güncel haline çevirir
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }


}