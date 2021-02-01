package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)
        var imgTest = findViewById<ImageView>(R.id.imgTest)
        var resposta = findViewById<Button>(R.id.resposta)
        var cancelar = findViewById<Button>(R.id.cancelar)
        var respostaUser = findViewById<EditText>(R.id.respostaUser)

        var params: Bundle? = intent.extras
        var opcao = params?.getString("opcao")
        if(opcao.toString() == "test1"){
            imgTest.setImageResource(R.drawable.teste1)
        }else if(opcao.toString() == "test2"){
            imgTest.setImageResource(R.drawable.teste2)
        }else if(opcao.toString() == "test3"){
            imgTest.setImageResource(R.drawable.teste3)
        }

        var intent = Intent(this, MainActivity::class.java)
        var bundle = Bundle()

        resposta.setOnClickListener {
            bundle.putString("result", respostaUser.text.toString())
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        cancelar.setOnClickListener {
            finish()
        }
    }
}