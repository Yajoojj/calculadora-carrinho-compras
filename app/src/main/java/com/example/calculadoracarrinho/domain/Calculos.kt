package com.example.calculadoracarrinho.domain

import com.example.calculadoracarrinho.model.ItemCarrinho
import com.example.calculadoracarrinho.model.Produto
import java.text.NumberFormat
import java.util.Locale

fun subtotalItem(produto: Produto, quantidade: Int): Double =
    produto.preco * quantidade

fun descontoItem(produto: Produto, quantidade: Int): Double =
    subtotalItem(produto, quantidade) * produto.descontoPercentual / 100

fun totalItem(produto: Produto, quantidade: Int): Double =
    subtotalItem(produto, quantidade) - descontoItem(produto, quantidade)

fun subtotalCarrinho(itens: List<ItemCarrinho>): Double =
    itens.sumOf { subtotalItem(it.produto, it.quantidade) }

fun descontosCarrinho(itens: List<ItemCarrinho>): Double =
    itens.sumOf { descontoItem(it.produto, it.quantidade) }

fun formatarMoeda(valor: Double): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(valor)
