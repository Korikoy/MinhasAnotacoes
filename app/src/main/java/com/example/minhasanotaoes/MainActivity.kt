package com.example.minhasanotaoes

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.minhasanotaoes.databinding.ActivityMainBinding
import com.example.minhasanotaoes.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var preferencias : AnotacaoPreferencias
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferencias = AnotacaoPreferencias(applicationContext)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.fab.setOnClickListener { view ->
            val textoRecuperado = binding.include.editText.text.toString()
        if (textoRecuperado == ""){
            Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show()
        }else{
            Snackbar.make(view, "Anotação Salva com Sucesso", Snackbar.LENGTH_LONG).show()

            preferencias.salvarAnotacao(textoRecuperado)
            }
        }


        //recuperar anotaçao
       var anotacao = preferencias.recuperarAnotacao()
        if(anotacao != ""){
            binding.include.editText.setText(anotacao)
        }

    }


}