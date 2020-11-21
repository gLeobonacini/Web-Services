package com.kotlin.aula35_webservice.UI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.aula35_webservice.Entities.Aluno
import com.kotlin.aula35_webservice.Entities.Produto
import com.kotlin.aula35_webservice.Services.Repository
import com.kotlin.aula35_webservice.Services.repositorio
import kotlinx.coroutines.launch

class MainViewModel(repository: Repository): ViewModel() {
    val aluno = MutableLiveData<Aluno>()
    val listaAlunos = MutableLiveData<List<Aluno>>()
    val listaProdutos = MutableLiveData<List<Produto>>()

    fun getSortAluno(){
        try {
            viewModelScope.launch {
                aluno.value = repositorio.getSortAlunoRepository()
            }
        }catch (e: Exception){
            Log.e("MainViewModel", e.toString())
        }
    }

    fun getListaAlunos(){
        try {
            viewModelScope.launch {
                listaAlunos.value = repositorio.getTodosAlunosRepository()
            }
        }catch (e: Exception){
            Log.e("MainViewModel",e.toString())
        }
    }

    fun getListaProdutos(){
        try {
            viewModelScope.launch {
                listaProdutos.value = repositorio.getTodosProdutosRepository().listaProdutos
            }
        }catch (e: Exception){
            Log.e("MainViewModel",e.toString())
        }
    }
}