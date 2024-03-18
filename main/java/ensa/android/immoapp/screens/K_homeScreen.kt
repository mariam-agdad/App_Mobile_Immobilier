package ensa.android.immoapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ensa.android.immoapp.R
import ensa.android.immoapp.data.dataSource.annoncesList
import ensa.android.immoapp.ui_components.TopBardId
import ensa.android.immoapp.ui_components.annonceCard
import ensa.android.immoapp.ui_components.appTopBarGenerator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun home() {

    var alertNumber = 1 //pour le numéro de l'alerte

    Scaffold(
        topBar = {
            appTopBarGenerator(appBarText = stringResource(id = R.string.annonces_topBar,alertNumber), topBarId = TopBardId.ANNONCES)
        }
    ) {

        LazyColumn(){
            items(annoncesList){card ->
                annonceCard(card = card)
            }
        }
    }
}

