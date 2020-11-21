package com.kotlin.aula35_webservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.kotlin.aula35_webservice.R
import com.kotlin.aula35_webservice.Services.repositorio

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repositorio) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getListaProdutos()

        viewModel.listaProdutos.observe(this){
            it.forEach {
                Log.i("MainActivity", it.toString())
            }
        }
    }
}