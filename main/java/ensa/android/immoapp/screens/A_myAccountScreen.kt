package ensa.android.immoapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MonCompteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mon compte",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Action pour modifier l'email */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Modifier mon email")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Action pour supprimer le compte */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Supprimer mon compte")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Action pour se déconnecter avec Google */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Se déconnecter ")
        }
    }
}