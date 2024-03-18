package com.example.favorisannonce

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ensa.android.immoapp.ui.theme.Shapes

private val LightColorPalette = lightColors(
    primary = Color(0xFF455A64),
    primaryVariant = Color(0xFF1C313A),
    secondary = Color(0xFF455A64),
    background = Color.White,
    onBackground = Color.Black,
//    onPrimary = Color.White,
)

private val DarkColorPalette = darkColors(
    primary = Color(0xFF90A4AE),
    primaryVariant = Color(0xFF78909C),
    secondary = Color(0xFF90A4AE),
    background = Color.Black,
    onBackground = Color.White,
//    onPrimary = Color.Black,
)

@Composable
fun FavorisAnnonceTheme(
    viewModel: FavorisViewModel,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
//        typography = Typography,
        shapes = Shapes,
        content = content
    )
}