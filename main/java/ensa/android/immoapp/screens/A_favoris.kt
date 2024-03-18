package com.example.favorisannonce

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ensa.android.immoapp.R
import ensa.android.immoapp.data.models.Annonce


@Composable
fun AnnonceListItem(
    annonce: Annonce,
    viewModel: FavorisViewModel
) {
    val isFavori by remember { mutableStateOf(viewModel.isFavori(annonce)) }
    val favoriteIcon = if (isFavori) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder

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
                .clickable(onClick = {
// Naviguer vers l'annonce
 })
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
            IconButton(
                onClick = { viewModel.toggleFavori(annonce) },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = favoriteIcon,
                    contentDescription = stringResource(R.string.favorite_button_content_description)
                )
            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnnoncesScreen(viewModel: FavorisViewModel) {
    val annonces = listOf(
        Annonce(
            titre = "Annonce 1",
            description = "Description de l'annonce 1",
            image = R.drawable.download
        ),
        Annonce(
            titre = "Annonce 2",
            description = "Description de l'annonce 2",
            image = R.drawable.download
        ),
        Annonce(
            titre = "Annonce 3",
            description = "Description de l'annonce 3",
            image = R.drawable.download
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Annonces") },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(annonces) { annonce ->
                AnnonceListItem(annonce = annonce, viewModel = viewModel)
            }
        }
    }
}







