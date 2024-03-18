package com.example.annonceinterface1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ensa.android.immoapp.data.models.Annonce

@Composable
fun ListAnnonceModify(
    annonce: Annonce,
    onNavigateTo: () -> Unit
) {
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
                .clickable(onClick = onNavigateTo)
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
        }
    }
}