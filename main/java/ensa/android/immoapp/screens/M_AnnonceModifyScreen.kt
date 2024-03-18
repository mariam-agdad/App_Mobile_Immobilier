
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.annonceinterface1.*
import ensa.android.immoapp.R
import ensa.android.immoapp.data.models.Annonce

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnnonceModifyScreen(onNavigateTo: (Int) -> Unit) {
    val annonces = listOf(
        Annonce(
            titre = "Annonce 1",
            description = "Description de l'annonce 1",
            image = R.drawable.download
        ),
        Annonce(
            titre = "Annonce 2",
            description = "Description de l'annonce 2",
            image = ensa.android.immoapp.R.drawable.download
        ),
        Annonce(
            titre = "Annonce 3",
            description = "Description de l'annonce 3",
            image =ensa.android.immoapp.R.drawable.download
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
                ListAnnonceModify(annonce = annonce, {onNavigateTo(3)})
            }
        }
    }
}