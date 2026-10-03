package com.example.calculadoracarrinho.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoracarrinho.data.carrinho
import com.example.calculadoracarrinho.domain.descontosCarrinho
import com.example.calculadoracarrinho.domain.subtotalCarrinho
import com.example.calculadoracarrinho.model.Carrinho
import com.example.calculadoracarrinho.ui.components.LinhaProduto
import com.example.calculadoracarrinho.ui.components.ResumoCarrinho
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen(carrinho: Carrinho) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meu Carrinho") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(carrinho.itens) { item ->
                    LinhaProduto(
                        nome = item.produto.nome,
                        descricao = item.produto.descricao,
                        precoUnitario = item.produto.preco,
                        quantidade = item.quantidade,
                        total = item.calcularTotal()
                    )
                }
            }
            HorizontalDivider()
            ResumoCarrinho(
                subtotal = subtotalCarrinho(carrinho.itens),
                descontos = descontosCarrinho(carrinho.itens),
                total = carrinho.calcularTotal()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarrinhoScreenPreview() {
    CalculadoraCarrinhoTheme {
        CarrinhoScreen(carrinho)
    }
}
