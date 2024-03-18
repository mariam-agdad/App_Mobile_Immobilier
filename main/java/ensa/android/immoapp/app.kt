package ensa.android.immoapp

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ensa.android.immoapp.screens.activityScreen
import ensa.android.immoapp.screens.alertFormContent
import ensa.android.immoapp.screens.home
import ensa.android.immoapp.ui_components.bottomBar
import ensa.android.immoapp.ui_components.homeNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainApp() {
val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            bottomBar(navController = navController)
                    },

    ){
        homeNavigation(navController)
    }

}