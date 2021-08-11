package correa.matheus.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtValor : EditText
    lateinit var btnDados : Button
    lateinit var btnMostrar : Button

    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initContador()
        initClick()
        validaContador()
    }
    fun validaContador(){
        if(contador > 5){
            contador = 0
        }
    }
    fun initClick(){
        btnDados.setOnClickListener {
            contador++
            validaContador()
            initContador()
        }
        btnMostrar.setOnClickListener {
            Toast.makeText(this,"Valor $contador", Toast.LENGTH_SHORT).show()
        }
    }
    fun initContador(){
        txtValor.setText(contador.toString())
    }
    fun initDados(){
        txtValor = findViewById(R.id.valor)
        btnDados = findViewById(R.id.dados)
        btnMostrar = findViewById(R.id.mostrar)
    }
}