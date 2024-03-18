package com.example.annonceinterface1.ui.theme

import AnnonceModifyScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.annonceinterface1.*


@Composable
fun AnnonceScreen(onNavigateTo: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onNavigateTo(1) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Publier une annonce")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onNavigateTo(6) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Modifier une annonce")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onNavigateTo(7) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Supprimer une annonce")
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectedItem by remember { mutableStateOf(0) }
    //val viewModel = FavorisViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Annonces immobilières") }
            )
        }
    ) {
        when (selectedItem) {
            0 -> AnnonceScreen(onNavigateTo = { selectedItem = it })
            1 -> PublishScreen(onNavigateTo = { selectedItem = it })
            3 -> ModifyScreen(onNavigateTo = { selectedItem = it })
            6 -> AnnonceModifyScreen(onNavigateTo = { selectedItem = it })
            7 -> DeleteScreen(onNavigateTo = { selectedItem = it })
            else -> error("Invalid item selected: $selectedItem")
        }
    }
}

