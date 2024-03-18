
package ensa.android.immoapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ensa.android.immoapp.ui_components.TopBardId
import ensa.android.immoapp.ui_components.appTopBarGenerator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun serviceScreen() {

    Scaffold (
        topBar = { appTopBarGenerator(appBarText = stringResource(id = ensa.android.immoapp.R.string.services_topBar), topBarId = TopBardId.SERVICES) }
            ){
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            ){

                Spacer(modifier = Modifier.height(60.dp))
                Button(
                    onClick = { /* Action à réaliser lorsqu'on appuie sur le bouton Louer */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF3739E0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Louer un bien")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Action à réaliser lorsqu'on appuie sur le bouton Acheter */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF3739E0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Acheter un bien")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Action à réaliser lorsqu'on appuie sur le bouton Vendre */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF3739E0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Louer son bien")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Action à réaliser lorsqu'on appuie sur le bouton Louer son bien */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF3739E0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Vendre son bien ")
                }
            }
        }
    }

}