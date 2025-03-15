package com.devtools.memoryadd.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devtools.memoryadd.Componets.Card_versionAndroid
import com.devtools.memoryadd.Componets.PieChart
import com.devtools.memoryadd.R
import com.devtools.memoryadd.data.repository.AndroidService
import com.devtools.memoryadd.data.repository.MemoryService



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home_View ( ) {

    val Service_android= AndroidService()


    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,


        topBar = {

            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {

                    Text("+Memory",
                    color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge
                        )


                }
            )

        }


    )


    { innerPadding ->


        Box(modifier = Modifier.padding(innerPadding)
            .padding(8.dp),
        ){


            Column (modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,



            ) {


                PieChart()


                Card_versionAndroid("Android Version"
                ,Service_android.getVersionAndroid(),
                 R.drawable.android
                )


                Card_versionAndroid("Brand"
                    ,Service_android.getBrandDevice(),
                    R.drawable.android
                )



                Card_versionAndroid("Brand"
                    ,Service_android.getBOARD(),
                    R.drawable.android
                )

            }

        }

    }

}