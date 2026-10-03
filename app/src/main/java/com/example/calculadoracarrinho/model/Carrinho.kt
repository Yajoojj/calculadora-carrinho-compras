package com.example.calculadoracarrinho.model

data class Carrinho(val itens: List<ItemCarrinho>) : Pagavel {
    override fun calcularTotal(): Double = itens.sumOf { it.calcularTotal() }
}
