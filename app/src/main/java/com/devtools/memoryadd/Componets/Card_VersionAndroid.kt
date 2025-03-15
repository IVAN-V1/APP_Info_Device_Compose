package com.devtools.memoryadd.Componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devtools.memoryadd.R
import com.devtools.memoryadd.ui.theme.MemoryAddTheme

@Composable
fun Card_versionAndroid(title: String, date: String,image: Int) {

    MemoryAddTheme {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            ) {

            Card(
                shape = RoundedCornerShape(16.dp,),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)

                ,


                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,

                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {


                    Column (modifier = Modifier.align(Alignment.Center)) {

                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )


                        Spacer(Modifier.height(16.dp))

                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically){


                                Text(
                                    text = date,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.secondary

                                )

                                Image(
                                    painter = painterResource(id = image),
                                    contentDescription = null,
                                    modifier = Modifier.size(64.dp)
                                )






                        }



                    }


                }
            }
        }

    }

}
