/*
Ici tout les composants communs de notre application
 */


package ensa.android.immoapp.ui_components
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.favorisannonce.AnnoncesScreen
import com.example.favorisannonce.FavorisAnnonceTheme
import com.example.favorisannonce.FavorisViewModel
import ensa.android.immoapp.R
import ensa.android.immoapp.data.models.Annonce
import ensa.android.immoapp.screens.MonCompteScreen
import ensa.android.immoapp.screens.activityScreen
import ensa.android.immoapp.screens.home
import ensa.android.immoapp.screens.serviceScreen
import java.text.Format
import java.text.NumberFormat
import java.util.Formatter

@Composable
fun appTopBarGenerator(
    appBarText : String,
    topBarId : TopBardId?,
    action: () -> Unit ={}
    ) {
    when (topBarId) {

        //différents affichage des topBars de l'application

        TopBardId.ANNONCES -> {
            //topBar pour la partie qui affiche toutes les annonces filtrées selon une alerte
            Row() {
                topBarText(appBarText = appBarText)
                  Icon(
                    painter = painterResource(id = R.drawable.baseline_expand_more_24),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_notifications_24),
                    contentDescription = null
                )
            }
        }
        TopBardId.FAVORIS -> {
            // topBar pour la partie qui affiche les favoris
            Row(
                //clickable {  }
            ) {
                topBarText(appBarText = appBarText)


            }
        }
        TopBardId.ACTIVITES -> {
            //topBar pour la partie "Mes activités"

            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()

                ) {

                topBarText(appBarText = appBarText)

            }
        }
            TopBardId.COMPTE ->{
                //topBar de la partie compte
                /*ToDo*/

            }
            TopBardId.SERVICES ->{
                //topBar de la partie Services

                Row() {
                    /*ToDo*/
                    topBarText(appBarText = appBarText)

                }
            }
            else ->{
                
                //Lors du remplissage du formulaire de l'alerte, annonce ou autres
                /*ToDo*/
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(onClick = action),
                        tint = Color.DarkGray
                    )
                    topBarText(appBarText = appBarText)
                }
            }
        }

    }

@Composable
fun bottomBar(navController : NavController) {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        bottomBarElement(
            icon = painterResource(id = R.drawable.baseline_archive_24),
            text = "Annonces"
        ) {
            navController.navigate("annonces")
        }
        bottomBarElement(
            icon = painterResource(id = R.drawable.baseline_favorite_24),
            text = "Favoris"
        ) {
            navController.navigate("favoris")
        }
        bottomBarElement(
            icon = painterResource(id = R.drawable.baseline_real_estate_agent_24),
            text = "Services"
        ) {
            navController.navigate("services")

        }
        bottomBarElement(
            icon = painterResource(id = R.drawable.baseline_add_home_work_24),
            text = "Activités"
        ) {

            navController.navigate("activities")

        }
        bottomBarElement(
            icon = painterResource(id = R.drawable.baseline_account_circle_24),
            text = "Compte"
        ) {
            navController.navigate("compte")
        }
    }
}

@Composable
fun homeNavigation(navController: NavHostController ) {
    val viewModel = FavorisViewModel()

    NavHost(navController = navController, startDestination = "annonces") {
        composable(route = "annonces",) {
            //Annonce screen , is also the start destination..
            home()
        }

        composable(route = "favoris") {
            //Favoris screen..
            FavorisAnnonceTheme(viewModel) {
                AnnoncesScreen(viewModel)
            }

        }

        composable(route = "services") {
            serviceScreen()
        }

        composable(route = "activities") {
            activityScreen()
        }

        composable(route = "compte") {
            //Compte screen..
            MonCompteScreen()
        }

    }
}



@Composable
fun bottomBarElement(icon : Painter, text : String, action : ()->Unit) {

    Column(
        modifier = Modifier
            .clickable (
                onClick = action
                    )

    ) {
        Icon(
            painter = icon,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            contentDescription = null,
            tint = Color.DarkGray
        )
        Text(
            text = text,
            color = Color.DarkGray,
            fontSize = 12.sp

        )
    }

    }


@Composable
fun annonceCard(card : Annonce) {
    
    Column() {
        Row() {
            Row(){
                Icon(painter = painterResource(card.propIcon), contentDescription = null )
                Text(text = card.nomProp)
            }
            Text(text ="Le " + card.dateCreation.toString())
        }
        Card() {
            //Slides images
        }
        Row {
            Text(text = card.dept + "-" + card.surface + "-" + card.nmbrP + "-" + card.nmbrCh)
            Text(text = card.convertMeubToText())
        }
        Row() {
            Text(text = NumberFormat.getCurrencyInstance().format(card.prix))
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = null
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = null
            )
        }
        
    }
    

}

@Composable
fun topBarText(
    appBarText : String,
    ){

    Text(
        text = appBarText,
        color = Color.Black,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(30.dp)
    )
}

@Composable
fun buttonWithIcon(
    text : String,
    icon : ImageVector,
    modifier: Modifier = Modifier,
    onClickAction : ()-> Unit) {
    
    Button(onClick = onClickAction) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(
            text = text
        )
    }

}


