package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.testedaltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.test1.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            intent.putExtra("opcao", "test1")
            startActivityForResult(intent, 1)
        }
        binding.test2.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            intent.putExtra("opcao", "test2")
            startActivityForResult(intent, 2)
        }
        binding.test3.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            intent.putExtra("opcao", "test3")
            startActivityForResult(intent, 3)
        }

        binding.verificar.setOnClickListener {
            if (binding.res1.text == "Resposta_1" || binding.res2.text == "Resposta_2" || binding.res3.text == "Resposta_3") {
                Toast.makeText(this, "Faça os Testes!!!", Toast.LENGTH_SHORT)
            } else {
                if (binding.res1.text == "29" && binding.res2.text == "74" && binding.res3.text == "8") {
                    binding.resFinal.text = "Você é Normal!"
                } else {
                    binding.resFinal.text = "Você é daltônico, procure um médico"

                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                1 -> {
                    binding.res1.text = data?.getStringExtra("result").toString()
                }
                2 -> {
                    binding.res2.text = data?.getStringExtra("result").toString()
                }
                3 -> {
                    binding.res3.text = data?.getStringExtra("result").toString()
                }
            }
        }

    }
}