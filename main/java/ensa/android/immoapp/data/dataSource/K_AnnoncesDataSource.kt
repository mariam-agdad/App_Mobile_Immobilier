package ensa.android.immoapp.data.dataSource

import ensa.android.immoapp.R
import ensa.android.immoapp.data.models.Annonce
import ensa.android.immoapp.data.models.Proprietaire
import java.util.*

val annoncesList = listOf<Annonce>(
    Annonce(
        images = mutableListOf<Int>(R.drawable.download, R.drawable.download),
        nomProp = "Kaouthar",
        propIcon = R.drawable.download ,
        proprietaire = Proprietaire.AGENCE ,
        dept = "Marrakech, Gueliz",
        surface = "200",
        nmbrP = "4",
        nmbrCh = "8",
        prix = 600,
        dateCreation = Date(),
        meuble = true
    ),
    Annonce(
        images = mutableListOf<Int>(R.drawable.download, R.drawable.download),
        nomProp = "Kaouthar",
        propIcon = R.drawable.download ,
        proprietaire = Proprietaire.AGENCE ,
        dept = "Marrakech, Gueliz",
        surface = "200",
        nmbrP = "4",
        nmbrCh = "8",
        prix = 600,
        dateCreation = Date(),
        meuble = true
    )
)