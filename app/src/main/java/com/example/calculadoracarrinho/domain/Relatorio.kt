package com.example.calculadoracarrinho.domain

import com.example.calculadoracarrinho.model.ItemCarrinho

fun gerarRelatorio(itens: List<ItemCarrinho>): List<String> {
    val comDesconto = itens
        .filter { it.produto.descontoPercentual > 0 }
        .sortedByDescending { it.calcularTotal() }

    val linhas = comDesconto.map {
        "${it.produto.nome} - ${formatarMoeda(it.calcularTotal())}"
    }

    val total = comDesconto.fold(0.0) { soma, item -> soma + item.calcularTotal() }

    return listOf("--- Produtos com desconto ---") +
            linhas +
            "Total dos itens com desconto: ${formatarMoeda(total)}"
}
