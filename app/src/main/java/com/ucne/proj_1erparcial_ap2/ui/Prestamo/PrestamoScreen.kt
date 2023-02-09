package com.ucne.proj_1erparcial_ap2.ui.Prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen() {
    
    Column(modifier = Modifier.fillMaxSize()) {


        OutlinedTextField(

            modifier = Modifier.fillMaxSize().padding(8.dp),

            value=  " ", onValueChange = {}

        )









        
        
    }
    
}