package com.example.mvvmkullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        binding.mainActivityNesnesi = this

        viewModel.sonuc.observe(this,{ s->
            binding.hesaplamaSonucu  = s
        })


    }

    fun buttonToplamaTikla(alinanSayi1:String,alinanSayi2:String){
        viewModel.toplamaYap(alinanSayi1,alinanSayi2)
    }

    fun buttonCarpmaTikla(alinanSayi1:String,alinanSayi2:String){
        viewModel.carpmaYap(alinanSayi1,alinanSayi2)
    }

}