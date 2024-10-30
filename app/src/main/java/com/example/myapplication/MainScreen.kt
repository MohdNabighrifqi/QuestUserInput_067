package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier

){
    var name by rememberSaveable { mutableStateOf ("") }
    var email by remember { mutableStateOf("")  }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("")    }
    var selectedGender by remember { mutableStateOf("")    }

    val jenisKelamin = listOf("Laki-Laki","Perempuan")

    var confirmName by rememberSaveable { mutableStateOf ("") }
    var confirmEmail by remember { mutableStateOf("")  }
    var confirmAlamat by remember { mutableStateOf("") }
    var confirmnoHP by remember { mutableStateOf("")    }
    var confirmselectedGender by remember { mutableStateOf("")    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = name, onValueChange = {name = it},
            placeholder = { Text("Masukan Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
            Row {
                jenisKelamin.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedGender == item,
                            onClick = {
                                selectedGender = item
                            })
                    }
                }
            }

        OutlinedTextField(value = email, onValueChange = {email = it},
            placeholder = { Text("Masukan Email") }, label = { Text(text ="Nama")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(value = alamat    , onValueChange = {alamat = it},
            placeholder = { Text("Masukan Alamat") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(value = noHP, onValueChange = {noHP = it},
            placeholder = { Text("Masukan Nomor Telepon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(onClick = {
            confirmName = name
            confirmselectedGender= selectedGender
            confirmEmail = email
            confirmAlamat = alamat
            confirmnoHP = noHP
        })
        { Text(text = "Simpan") }
        Card(modifier.size(height = 200.dp, width = 300.dp)) {

            CardSection(judulParam = "Nama", isiParam = confirmName)
            CardSection(judulParam = "Jenis Kelamin", isiParam = confirmselectedGender)
            CardSection(judulParam = "Email", isiParam = confirmEmail)
            CardSection(judulParam = "Alamat", isiParam = confirmAlamat)
            CardSection(judulParam = "noHP", isiParam = confirmnoHP)
        }
    }
}
@Composable
fun CardSection(judulParam: String, isiParam:String){
    Column() {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Text(text = judulParam, modifier =  Modifier.weight(0.8f))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = isiParam, modifier = Modifier.weight(2f))
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}
