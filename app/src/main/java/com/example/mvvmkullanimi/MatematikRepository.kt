package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData

class MatematikRepository {

    var MatematikselSonuc = MutableLiveData<String>()

    init {
        MatematikselSonuc = MutableLiveData<String>("0")
    }

    fun matematikselSonucGetir():MutableLiveData<String>{
        return MatematikselSonuc
    }

    fun toplamaYap(alinanSayi1:String,alinanSayi2:String){
        val sayi1 =  alinanSayi1.toInt()
        val sayi2 =  alinanSayi2.toInt()
        val toplam = sayi2+sayi1
        MatematikselSonuc.value = toplam.toString()
    }

    fun carpmaYap(alinanSayi1:String,alinanSayi2:String){
        val sayi1 =  alinanSayi1.toInt()
        val sayi2 =  alinanSayi2.toInt()
        val carpim = sayi2*sayi1
        MatematikselSonuc.value = carpim.toString()
    }

}