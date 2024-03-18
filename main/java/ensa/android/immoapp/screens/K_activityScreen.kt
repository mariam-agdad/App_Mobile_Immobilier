package ensa.android.immoapp.screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.annonceinterface1.ui.theme.MainScreen
import ensa.android.immoapp.R
import ensa.android.immoapp.data.dataSource.alertList
import ensa.android.immoapp.data.models.AlertData
import ensa.android.immoapp.ui.theme.Shapes
import ensa.android.immoapp.ui_components.*
import java.text.NumberFormat


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun activityScreen() {
    var color by remember {
        mutableStateOf(Color.Black)
    }
    val navController : NavHostController = rememberNavController()
  Scaffold(
        topBar = {
            Column() {
                appTopBarGenerator(stringResource(id = R.string.activity_topBar_text), TopBardId.ACTIVITES)
                activityBody(navController = navController)
            }
            },
        content = {
            activityNavigation(navController = navController)
        }

    )

}

@Composable
fun alertHome(navController: NavHostController){
    //home screen of alerts management

    var expandableState by remember{
        mutableStateOf(false)
    }
    Column() {
        generateAddAlertRow(
            textContent = "Ajouter une Alerte",
            icon = R.drawable.baseline_notification_add_24
        ){
            navController.navigate("alertForm")
        }
        generateDisplayAlertRow(
            textContent = "Voir mes alertes",
        ){
            expandableState = !expandableState
            expandableState
        }
    }
}

@Composable
fun alertNav() {
    val navControllerAlert = rememberNavController()

    NavHost(navController = navControllerAlert, startDestination = "alertHome") {
        composable(route = "alertHome") {
            alertHome(navControllerAlert)
        }
        composable(route="alertForm"){
            alertForm(R.string.create_alert_topBar, navControllerAlert)
        }

    }
}
@Composable
fun activityNavigation(navController : NavHostController){

    NavHost(navController = navController, startDestination = "alertes") {
        composable(route = "alertes") {
            alertNav()
        }

        composable(route = "annonces") {
            //Code pour les interfaces des annonces
            MainScreen()
            }
        }
    }


@Composable
fun alertNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "mesAlertes"){
        composable(route = "alertForm"){
            alertForm(R.string.create_alert_topBar,navController)
        }
        composable(route = "mesAlertes"){
            activityScreen()
        }

    }
        }

@Composable
fun activityBody(navController : NavHostController) {

    Column() {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Mes Alertes",
                modifier = Modifier
                    .clickable {
                        navController.navigate("alertes")
                    }
                    .weight(1f)
                    .background(Color.LightGray)
            )
            Text(
                text = "Mes Annonces",
                modifier = Modifier
                    .clickable {
                        navController.navigate("annonces")

                    }
                    .weight(1f)
                    .background(Color.LightGray)
            )
        }
    }
}

@Composable
fun generateAddAlertRow(textContent : String, @DrawableRes icon : Int, action : ()->Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp)
            .clickable(onClick = action)
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Column() {
            Text(
                text = textContent
            )
        }
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))

    }
}

@Composable
fun generateDisplayAlertRow(textContent : String, @DrawableRes icon : Int? = null, action : ()->Boolean = { false }) {

    var expandableState by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(icon)
    }

    if(icon == null){

        if(expandableState){

            iconState = R.drawable.baseline_expand_less_24

        }else{
            iconState = R.drawable.baseline_expand_more_24
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp)
            .clickable {
                //Lambda function
                expandableState = action()
            }
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Column() {
            Text(
                text = textContent
            )
        }
        Icon(
            painter = painterResource(id = iconState!!),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))

    }
    if(expandableState){
        displayAlerts()
    }
}

@Composable
fun alertAction() {
    //Supprimer, modifier ...
}

@Composable
fun displayAlerts() {


    //Affichage des alertes enregistrées avec la possibilité de
    //modifier
    //supprimer

        LazyColumn() {
            items( alertList ){alert-> alertCard(alert = alert)

            }
        }

}

@Composable
fun alertCard(alert : AlertData){
        Card(
            shape = Shapes.medium,
            elevation = 30.dp,
            modifier = Modifier
                .fillMaxWidth()
) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = alert.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(text = alert.dept)
                    Text(text = alert.surface + "m2")
                    Text(text = NumberFormat.getCurrencyInstance().format(alert.price))
                }
                Column(
                    modifier = Modifier
                        .weight(1f) ,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_mode_edit_24),
                            contentDescription = null,
                            tint = Color.DarkGray,
                            modifier = Modifier
                                .clickable {

                                }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_delete_24),
                            contentDescription = null,
                            tint = Color.DarkGray,
                            modifier = Modifier
                                .clickable {

                                }

                        )
                    }
                }

            }



}
}
