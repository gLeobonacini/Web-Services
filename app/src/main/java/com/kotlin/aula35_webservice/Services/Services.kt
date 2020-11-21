package com.kotlin.aula35_webservice.Services

import com.kotlin.aula35_webservice.Entities.Aluno
import com.kotlin.aula35_webservice.Entities.Msg
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Repository {
    @GET("sort/aluno")
    suspend fun getSortAlunoRepository(): Aluno

    @GET("alunos")
    suspend fun getTodosAlunosRepository(): List<Aluno>

    @GET("produtos")
    suspend fun getTodosProdutosRepository(): Msg
}

val retroFit = Retrofit.Builder()
        .baseUrl("https://promoios.com.br/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val repositorio: Repository = retroFit.create(Repository::class.java)