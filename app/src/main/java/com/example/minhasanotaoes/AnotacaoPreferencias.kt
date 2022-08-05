package com.example.minhasanotaoes

import android.content.Context
import android.content.SharedPreferences
import android.text.Editable

class AnotacaoPreferencias(c:Context) {

    private var context : Context = c
    private var preferencia: SharedPreferences
    private var NOME_ARQUIVO = "anotacao.preferencias"
    private var editor: SharedPreferences.Editor
    private val CHAVE_NOME = ""

    init {
        preferencia = context.getSharedPreferences(NOME_ARQUIVO,0)
        editor = preferencia.edit()
    }

    fun salvarAnotacao(anotacao: String){
        editor.putString(CHAVE_NOME,anotacao)
        editor.commit()
    }
    fun recuperarAnotacao(): String {
        return preferencia.getString(CHAVE_NOME,"").toString()
    }


}