package com.ucne.proj_1erparcial_ap2.ui.Prestamo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.proj_1erparcial_ap2.data.local.Entity.PrestamoEntity
import javax.inject.Inject



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen(viewModel: PrestamosViewModel = hiltViewModel()) {

    Column(Modifier.fillMaxSize()) {
        PrestamoBody(viewModel)

        val uiState by viewModel.uiState.collectAsState()
        PrestamoListScreen(uiState.prestamosList)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PrestamoBody(
    viewModel: PrestamosViewModel
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.Deudor ,
            onValueChange = { viewModel.Deudor = it },
            label = { Text("Deudor") }
        )


        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.Concepto,
            onValueChange = { viewModel.Concepto = it },
            label = { Text("Concepto") }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.Monto,
            onValueChange = { viewModel.Monto= it },
            label = { Text("Monto") }
        )

        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = { Text("Guardar") },
            icon = { Icon(imageVector = Icons.Filled.Save, contentDescription = "Save") },
            onClick = { viewModel.insertar() }
        )

        Row(){

            Text (text ="deudor", )
            Spacer (modifier =Modifier.padding(10.dp))
            Text (text ="Cocepto", textAlign= TextAlign.Center)
            Spacer (modifier =Modifier.padding(10.dp))
            Text (text ="Monto", textAlign= TextAlign.End)

        }

    }
}


@Composable
private fun PrestamoListScreen(prestamosList:List<PrestamoEntity>){
    LazyColumn{
        items(prestamosList){prestamo->
            PrestamoRow(prestamo)
        }
    }
}

// tabla
@Composable
private fun PrestamoRow(prestamo: PrestamoEntity){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ){
        Row(
            modifier=Modifier
                .fillMaxWidth()
        ){



            Text(

                text=prestamo.Deudor,
                style= MaterialTheme.typography.titleLarge,
                modifier=Modifier.weight(3f)


            )

            Text(
                text=prestamo.Concepto,
                style= MaterialTheme.typography.titleLarge,
                textAlign= TextAlign.Center,
                modifier=Modifier.weight(3f)
            )
            Text(
                String.format("%.2f",prestamo.Monto),
                textAlign= TextAlign.End,
                modifier=Modifier.weight(2f)
            )
        }

        Divider(Modifier.fillMaxWidth())
    }
}