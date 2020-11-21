package com.kotlin.aula35_webservice.Entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Msg(@SerializedName("produtos") @Expose var listaProdutos: List<Produto>)