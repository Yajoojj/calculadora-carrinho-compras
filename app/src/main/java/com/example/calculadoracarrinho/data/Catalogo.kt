package com.example.calculadoracarrinho.data

import com.example.calculadoracarrinho.model.Carrinho
import com.example.calculadoracarrinho.model.ItemCarrinho
import com.example.calculadoracarrinho.model.Produto

val catalogo = listOf(
    Produto(
        nome = "Notebook Dell Inspiron 15 3000 Intel Core i5 8GB 256GB SSD",
        preco = 3499.00,
        descricao = "Um notebook rápido para trabalho e estudos, com tela Full HD de 15,6 polegadas e bateria de longa duração",
        descontoPercentual = 5.0
    ),
    Produto(nome = "Mouse sem fio", preco = 89.90),
    Produto(
        nome = "Teclado mecânico RGB",
        preco = 349.90,
        descricao = "Switch azul, ABNT2"
    ),
    Produto(
        nome = "Monitor LG 24 polegadas",
        preco = 899.90,
        descricao = "Full HD, 75Hz, painel IPS",
        descontoPercentual = 10.0
    ),
    Produto(
        nome = "Headset Gamer",
        preco = 199.90,
        descricao = "Som surround 7.1 e microfone removível"
    ),
    Produto(
        nome = "Webcam Full HD",
        preco = 159.90,
        descricao = "1080p com microfone embutido",
        descontoPercentual = 15.0
    )
)

val carrinho = Carrinho(
    listOf(
        ItemCarrinho(catalogo[0], 2),
        ItemCarrinho(catalogo[1], 1),
        ItemCarrinho(catalogo[2], 1)
    )
)
