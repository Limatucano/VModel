package correa.matheus.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.ContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtValor : EditText
    lateinit var btnDados : Button
    lateinit var btnMostrar : Button

    lateinit var mviewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initClick()
    }

    fun initClick(){
        btnDados.setOnClickListener {
            mviewModel.Contador()
        }
        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext,"Valor ${mviewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

    fun initDados(){
        mviewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        txtValor = findViewById(R.id.valor)
        btnDados = findViewById(R.id.dados)
        btnMostrar = findViewById(R.id.mostrar)

        mviewModel.mContador.observe(this, Observer {
            txtValor.setText(it)
        })
    }
}