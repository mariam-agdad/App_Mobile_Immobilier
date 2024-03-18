package com.example.annonceinterface1.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PublishScreen(onNavigateTo: (Int) -> Unit) {
    var departement by remember { mutableStateOf("") }
    var surface by remember { mutableStateOf("") }
    var nbrePieces by remember { mutableStateOf("") }
    var nbreChambres by remember { mutableStateOf("") }
    var estMeuble by remember { mutableStateOf(false) }
    var typeService by remember { mutableStateOf("") }
    var avecColocataire by remember { mutableStateOf(false) }
    var etage by remember { mutableStateOf("") }
    var ascenseur by remember { mutableStateOf(false) }
    var typeBien by remember { mutableStateOf("") }
    var showAlert by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Publier une annonce") },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        content = {
            LazyColumn(modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    TextField(
                        value = departement,
                        onValueChange = { departement = it },
                        label = { Text("Département de l'appartement") }
                    )
                }
                item{
                    TextField(
                        value = surface,
                        onValueChange = { surface = it },
                        label = { Text("Surface habitable de l'appartement") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                item{
                    TextField(
                        value = nbrePieces,
                        onValueChange = { nbrePieces = it },
                        label = { Text("Nombre de pièces de l'appartement") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                item{
                    TextField(
                        value = nbreChambres,
                        onValueChange = { nbreChambres = it },
                        label = { Text("Nombre de chambres de l'appartement") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                item{
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Checkbox(
                            checked = estMeuble,
                            onCheckedChange = { estMeuble = it },
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Est-ce que l'appartement est meublé?",
                            modifier = Modifier.weight(4f)
                        )
                    }
                }
                item{
                    TextField(
                        value = typeService,
                        onValueChange = { typeService = it },
                        label = { Text("Type de service (location, vente, etc.)") }
                    )
                }
                item{
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Checkbox(
                            checked = avecColocataire,
                            onCheckedChange = { avecColocataire = it },
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Est-ce que l'appartement est en colocation?",
                            modifier = Modifier.weight(4f)
                        )
                    }
                }
                item{
                    TextField(
                        value = etage,
                        onValueChange = { etage = it },
                        label = { Text("Étage de l'appartement") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                item{
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Checkbox(
                            checked = ascenseur,
                            onCheckedChange = { ascenseur = it },
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Est-ce qu'il y a un ascenseur dans l'immeuble?",
                            modifier = Modifier.weight(4f)
                        )
                    }
                }
                item{
                    TextField(
                        value = typeBien,
                        onValueChange = { typeBien = it },
                        label = { Text("Type de bien (appartement, maison, etc.)") }
                    )
                }
                item {
                    Button(
                        onClick = {
                            // Ajouter le code pour enregistrer l'annonce dans Firebase
                                  showAlert = true;
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Publier l'annonce")
                    }
                    if (showAlert) {
                        AlertDialog(
                            onDismissRequest = { showAlert = false },
                            title = { Text("Alerte") },
                            text = { Text("Annonce publiée") },
                            confirmButton = {
                                Button(
                                    onClick = { showAlert = false }
                                ) {
                                    Text("OK")
                                }
                            }
                        )
                    }
                }
                item {
                    Button(
                        onClick = {
                            onNavigateTo(0)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Retour à l'acceuil")
                    }
                }

            }
        }
    )
}
