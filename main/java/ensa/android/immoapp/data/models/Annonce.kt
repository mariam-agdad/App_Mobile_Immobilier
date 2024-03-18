package ensa.android.immoapp.data.models

import ensa.android.immoapp.R
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class Annonce(
    var images : MutableList<Int> = mutableListOf(),
    var nomProp : String = "",
    var propIcon : Int = R.drawable.download,
    var proprietaire: Proprietaire = Proprietaire.PARTICULIER,
    var dept : String ="",
    var surface : String ="",
    var nmbrP : String ="1",
    var nmbrCh : String ="1",
    var prix : Int =0,
    var dateCreation : Date? = null,
    var meuble : Boolean = false,
    var titre: String ="image",
   var description: String = "image desc",
    var image :Int =R.drawable.download
    ) {
    constructor(titre : String, description : String, image : Int) : this()

/*   val titre: String

   val description: String


  var images : MutableList<Int> */


    //Convert meuble attr to explicit text
     fun convertMeubToText () : String{
        if(meuble){
            return "Meublé"
        }else{
            return "Non meublé"
        }
    }

}