package ensa.android.immoapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ensa.android.immoapp.R
import ensa.android.immoapp.ui_components.AlertFields
import ensa.android.immoapp.ui_components.alertFormFields
import ensa.android.immoapp.ui_components.alertFormFieldsFilledAlert1
import ensa.android.immoapp.ui_components.appTopBarGenerator

@Composable
fun alertForm(appBarText : Int, navHostController: NavHostController){

    Column() {
        appTopBarGenerator(appBarText = stringResource(id = appBarText), topBarId = null){
            navHostController.navigate("alertHome")

        }
        alertFormContent()
    }
        }

@Composable
fun alertFormContent(alertFormFields: List<AlertFields> = ensa.android.immoapp.ui_components.alertFormFields) {
    //alertformFields can be passed filled or empty

    var showAlert = false

    LazyColumn(
        modifier = Modifier
            .padding(18.dp)
    ){
        items(alertFormFieldsFilledAlert1.shuffled()){field->
            renderInScreen(field = field)
        }
        item {
            Row(
                horizontalArrangement = Arrangement .Center
            ) {
                Surface(
                    color = Color.Black
                ) {
                    Text(
                        text = "Enregistrer",
                        color = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                //Show an alert with text
                                //showAlert = true

                            }
                    )
/*                    if (showAlert) {
                        AlertDialog(
                                onDismissRequest = { showAlert = false },
                                title = { Text("Message") },
                                text = { Text("Alerte modifiée") },
                                confirmButton = {
                                    Button(
                                        onClick = { showAlert = false }
                                    ) {
                                        Text("D\'accord")
                                    }
                                }
                            )
                    }*/
                }
                }
            }

        }
    }


@OptIn(ExperimentalMaterialApi::class)
@Composable

fun renderInScreen(field : AlertFields){
    //Initialisations
    var checkedState by remember {
        mutableStateOf(false)
    }
    var sliderRang = 1f..9f
    var sliderStep = 4

    var sliderValues by remember {
        mutableStateOf(sliderRang)
    }
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Options") }

    //vérifie si les champs sont remplies
    var filled =false
    if(
        field.value != null
    ){
        filled = true
    }


    Spacer(modifier = Modifier.height(10.dp))

    when(field.typeOfComponent){
        "slider" ->{
            when(field.type){
                "surface" ->{
                    sliderRang =1f..500f
                    sliderStep =10
                }
                "price" ->{
                    sliderRang = 0f..15000f
                    sliderStep = 50
                }
                else ->{
                    //erreur du type
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(),
            ) {
                fieldLabel(field.label!!)
                Text(
                    text = "Min: ${sliderValues.start}, Max: ${sliderValues.endInclusive}",
                    color = Color.White
                )
                RangeSlider(
                    //min = sliderValues.start
                    //max = sliderValues.endInclusive
                    value = (if(filled){
                        field.value
                    }else {
                        sliderValues
                    }) as ClosedFloatingPointRange<Float>,
                    onValueChange = {
                        sliderValues = it
                        println(it.start)
                                    },
                    valueRange = sliderRang,
                    steps = sliderStep,
                    colors = SliderDefaults.colors(activeTrackColor=Color.Black)
                )


            }

        }
        "switcher" ->{
            //It's a field with switcher component
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                fieldLabel(field.label!!)
                Switch(
                    checked = (if (filled){
                        field.value
                    }else{
                        checkedState
                    }) as Boolean,
                    onCheckedChange = {checkedState= it},
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End),
                    colors = SwitchDefaults.colors(checkedTrackColor = Color.Black)
                )
            }
        }

        "dropDown" ->{
            fieldLabel(field.label!!)
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },

            ) {
                TextField(
                    value = if(filled){
                    field.value
                }else{
                    selectedText
                } as String,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    //modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    field.options!!.forEach{
                        option ->
                        DropdownMenuItem(

                            onClick = {
                                //Save the selected element
                                selectedText = option
                                expanded=false
                            }
                        ) {
                            Text(text = option)
                        }
                    }
                    }
                }
            }

        "button" ->{
        Column() {
            fieldLabel(field.label!!)
            LazyRow(
            ){

                items(field.options!!){option ->
                    Surface(
                        color = if ( filled && option.equals(field.value) ){
                            //Change the color of the selected option
                            Color.Black
                        } else {
                            //Default color for none selected options
                            Color.Gray
                        },
                        contentColor = Color.White
                    ) {

                        Text(
                            text = option,
                            modifier = Modifier
                                .clickable { // modify color of the text field on click

                                }
                                .padding(10.dp)
                        )
                    }

                }
            }
        }

        }
    }


}

@Composable
fun fieldLabel(label : String) {
    Text(
        text = label,
        modifier = Modifier
            .padding(9.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}


