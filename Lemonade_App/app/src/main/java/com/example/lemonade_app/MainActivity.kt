package com.example.lemonade_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade_app.ui.theme.Lemonade_appTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
//Creamos la funcion LemonadeApp
fun LemonadeApp(modifier: Modifier = Modifier) {
    //Variables que necesitaremos
    var nomUsuari by remember { mutableStateOf("") }    //variable para el nombre del Usuario
    var nomTemp by remember { mutableStateOf("") }  //variable nomTemporal
    var step by remember { mutableIntStateOf(0) } //variable para los pasos
    var clicksNecessaris by remember { mutableIntStateOf(0) } //variable para los clicks necesarios
    var clicksActuals by remember { mutableIntStateOf(0) }  //variable para guardar los clics que hace el usuario

    val context = LocalContext.current   //variable para poder utilizar el toast


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        when (step) {
            //Paso 1. Introducir el nombre
            0 -> {
                Text(
                    text = "Benvingut a l'app de Llimonada!",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                OutlinedTextField(
                    value = nomTemp,
                    onValueChange = { nomTemp = it },
                    label = { Text("El teu nom") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Button(
                    onClick = {
                        if (nomTemp.isNotBlank()) {
                            nomUsuari = nomTemp
                            step = 1
                            //Toast lo utilizamos para mostrar un mensaje pequeño en la pantalla por unos segundos y despues desaparece
                            Toast.makeText(context, "Hola $nomUsuari!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Començar")
                }
            }

            //Paso 2. Usamos al limonero
            1 -> {
                Text(
                    text = "Agafa una llimona $nomUsuari",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.lemon_tree), // Necessites aquesta imatge
                    contentDescription = "Llimoner",
                    modifier = Modifier
                        .size(300.dp)
                        .clickable {
                            step = 2
                            // Random.nextInt(from, until) no inclou el límit superior
                            clicksNecessaris = Random.nextInt(1, 11) // De 1 a 10
                            clicksActuals = 0
                            Toast.makeText(
                                context,
                                "Necessites $clicksNecessaris clics!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                )
            }

            // Paso 3: Exprimir la llimona
            2 -> {
                Text(
                    text = "Esprem la llimona $nomUsuari",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Clics: $clicksActuals / $clicksNecessaris",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze), // Necessites aquesta imatge
                    contentDescription = "Llimona",
                    modifier = Modifier
                        .size(300.dp)
                        .clickable {
                            clicksActuals++
                            if (clicksActuals >= clicksNecessaris) {
                                step = 3
                                Toast.makeText(
                                    context,
                                    "Llimona espremuda!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                )
            }
        }
    }
}