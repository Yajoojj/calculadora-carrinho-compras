package com.example.calculadoracarrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculadoracarrinho.data.carrinho
import com.example.calculadoracarrinho.domain.gerarRelatorio
import com.example.calculadoracarrinho.ui.CarrinhoScreen
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        gerarRelatorio(carrinho.itens).forEach { Log.d("Carrinho", it) }

        setContent {
            CalculadoraCarrinhoTheme {
                CarrinhoScreen(carrinho)
            }
        }
    }
}
