package com.example.calculadoracarrinho.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculadoracarrinho.domain.formatarMoeda

@Composable
fun ResumoCarrinho(
    subtotal: Double,
    descontos: Double,
    total: Double,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        LinhaResumo("Subtotal", formatarMoeda(subtotal))
        LinhaResumo("Descontos", "-" + formatarMoeda(descontos))
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("TOTAL", style = MaterialTheme.typography.titleLarge)
            Text(formatarMoeda(total), style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun LinhaResumo(rotulo: String, valor: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(rotulo, style = MaterialTheme.typography.bodyLarge)
        Text(valor, style = MaterialTheme.typography.bodyLarge)
    }
}
