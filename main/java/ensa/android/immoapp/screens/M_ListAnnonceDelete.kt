package com.example.annonceinterface1


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import ensa.android.immoapp.R
import ensa.android.immoapp.data.models.Annonce

@Composable
fun ListAnnonceDelete(
    annonce: Annonce,
) {
    val showDialog = remember { mutableStateOf(false) }
    Surface(
        color = Color.White,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = annonce.image),
                contentDescription = annonce.titre,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = annonce.titre,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = annonce.description,
                    style = MaterialTheme.typography.body2,
                    maxLines = 2
                )
            }

            Button(
                onClick = { showDialog.value = true },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete_button_content_description)
                )
            }
            if (showDialog.value) {
                AlertDialog(
                    onDismissRequest = { showDialog.value = false },
                    title = { Text(text = "Supprimer") },
                    text = { Text(text = "Voulez-vous supprimer cet élément ?") },
                    confirmButton = {
                        Button(
                            onClick = {
                                // Effectuer l'action de suppression ici
                                showDialog.value = false
                            }
                        ) {
                            Text(text = "Supprimer")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog.value = false }
                        ) {
                            Text(text = "Annuler")
                        }
                    },
                    properties = DialogProperties(dismissOnClickOutside = false)
                )
            }
        }
    }
}