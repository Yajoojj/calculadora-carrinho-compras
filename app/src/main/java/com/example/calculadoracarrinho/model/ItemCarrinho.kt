package com.example.calculadoracarrinho.model

import com.example.calculadoracarrinho.domain.totalItem

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {
    override fun calcularTotal(): Double = totalItem(produto, quantidade)
}
