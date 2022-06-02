package com.example.alarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.alarma.databinding.ActivityMainBinding
import com.example.alarma.databinding.ActivitySetBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        b.bMas1.setOnClickListener {
            val myTv = tvToInt(b.tvHoras)
            if (myTv < 23){
                if (myTv >= 9)
                b.tvHoras.text =  myTv.inc().toString()
                else
                    b.tvHoras.text = "0" + myTv.inc().toString()
            }

        }
        b.bMas2.setOnClickListener {
            val myTv = tvToInt(b.tvMinutos)
            if (myTv < 59) {
                if (myTv >= 9)
                    b.tvMinutos.text =  myTv.inc().toString()
                else
                    b.tvMinutos.text = "0" + myTv.inc().toString()
            }
        }
        b.bMas3.setOnClickListener {
            val myTv = tvToInt(b.tvSegundos)
            if (myTv < 59){
                if (myTv >= 9)
                    b.tvSegundos.text =  myTv.inc().toString()
                else
                    b.tvSegundos.text = "0" + myTv.inc().toString()
            }
        }
        b.bMenos1.setOnClickListener {
            val myTv = tvToInt(b.tvHoras)
            if (myTv > 0) b.tvHoras.text = myTv.dec().toString()
        }
        b.bMenos2.setOnClickListener {
            val myTv = tvToInt(b.tvMinutos)
            if (myTv > 0) b.tvMinutos.text = myTv.dec().toString()
        }
        b.bMenos3.setOnClickListener {
            val myTv = tvToInt(b.tvSegundos)
            if (myTv > 0) b.tvSegundos.text = myTv.dec().toString()
        }
        b.bSet.setOnClickListener {
            val myIntent = Intent(this, SetActivity::class.java)
            myIntent.putExtra("i_Horas", b.tvHoras.text)
            myIntent.putExtra("i_Minutos", b.tvMinutos.text)
            myIntent.putExtra("i_Segundos", b.tvSegundos.text)
            Toast.makeText(this, "ALARMA FIJADA", Toast.LENGTH_LONG).show()
            startActivity(myIntent)

        }
    }

    fun tvToInt(tv: TextView): Int {
        return tv.text.toString().toInt()
    }


}







