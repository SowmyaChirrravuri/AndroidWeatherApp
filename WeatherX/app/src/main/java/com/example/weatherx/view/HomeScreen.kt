package com.example.weatherx

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherx.ui.theme.Screen
import com.example.weatherx.viewModel.weatherViewModel

//@Composable
//fun HomeScreen(navController: NavController, viewModel: weatherViewModel) {
//
//    val usaStates = listOf(
//        "Alabama", "Alaska", "Arizona", "Arkansas", "California",
//        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
//        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
//        "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
//        "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
//        "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
//        "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
//        "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
//        "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
//        "Washington", "West Virginia", "Wisconsin", "Wyoming"
//    )
//
//    var selectedState by remember { mutableStateOf("Select a State") }
//    var city by remember { mutableStateOf("") }
//    var country by remember { mutableStateOf("") }
//    var isDropdownExpanded by remember { mutableStateOf(false) }
//    val uiState = viewModel.uiState.value
//    val isCityNotEmpty = city.isNotEmpty()
//
//    Column(
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        OutlinedTextField(
//            value = city,
//            onValueChange = { city = it },
//            label = { Text("City") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.clickable {
//                isDropdownExpanded = true
//            }
//        ) {
//            OutlinedTextField(
//                value = selectedState,
//                onValueChange = {},
//                textStyle = TextStyle(color = LocalContentColor.current),
//                readOnly = true,
//                trailingIcon = {
//                    Icon(
//                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_downward_24),
//                        contentDescription = null,
//                        modifier = Modifier.clickable {
//                            isDropdownExpanded = true
//                        }
//                    )
//                },
//                modifier = Modifier
//                    .weight(1f)
//                    .clickable {
//                        isDropdownExpanded = true
//                    }
//            )
//        }
//
//        OutlinedTextField(
//            value = country,
//            onValueChange = { country = it },
//            label = { Text("Country") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Button(
//            onClick = {
//                navController.navigate(Screen.SearchScreen.route)
//               viewModel.getWeatherData(city = city)
//            },
//            enabled =  uiState is Uistate.Loading,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            when (uiState) {
//                is Uistate.Loading -> CircularProgressIndicator()
//                else -> Text("Continue")
//            }
//        }
//
//        DropdownMenu(
//            expanded = isDropdownExpanded,
//            onDismissRequest = { isDropdownExpanded = false }
//        ) {
//            usaStates.forEach { state ->
//                DropdownMenuItem(
//                    onClick = {
//                        selectedState = state
//                        isDropdownExpanded = false
//                    }
//                ) {
//                    Text(text = state)
//                }
//            }
//        }
//    }
//}
//
//
