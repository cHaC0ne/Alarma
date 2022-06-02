package com.example.alarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarma.databinding.ActivityMainBinding
import com.example.alarma.databinding.ActivitySetBinding

class SetActivity : AppCompatActivity() {
    private lateinit var b: ActivitySetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySetBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)
        b.bVolver.setOnClickListener {
            onBackPressed()
        }
        val datos = intent.extras
        val horas = datos?.get("i_Horas").toString()
        val minutos = datos?.get("i_Minutos").toString()
        val segundos = datos?.get("i_Segundos").toString()
        b.tvHfija.text = "$horas : $minutos : $segundos"
    }
}