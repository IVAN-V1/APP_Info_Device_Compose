package com.devtools.memoryadd.Componets

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devtools.memoryadd.R
import com.devtools.memoryadd.ui.theme.MemoryAddTheme
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie

@Composable

@Preview
fun PieChart() {


    MemoryAddTheme {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            ) {
            Card(
                shape = RoundedCornerShape(16.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                ,


                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,

                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {


                    Column (modifier = Modifier.align(Alignment.Center)) {

                        Text(
                            text = stringResource(id = R.string.stadistics_text),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )


                        Spacer(Modifier.height(8.dp))

                        Row {



                            Spacer(Modifier.height(8.dp))



                            var data by remember {
                                mutableStateOf(
                                    listOf(
                                        Pie(label = "Dis", data =50.0, color = Color(0xFF5C6BC0), selectedColor = Color.Blue),
                                        Pie(label = "Linux", data = 60.0, color = Color(0xFFEC407A), selectedColor = Color.Yellow),
                                    )
                                )
                            }




                            PieChart(
                                modifier = Modifier.size(150.dp),
                                data = data,
                                onPieClick = {
                                    println("${it.label} Clicked")
                                    val pieIndex = data.indexOf(it)
                                    data = data.mapIndexed { mapIndex, pie -> pie.copy(selected = pieIndex == mapIndex) }
                                },
                                selectedScale = 1.2f,
                                scaleAnimEnterSpec = spring<Float>(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessLow
                                ),

                                colorAnimEnterSpec = tween(300),
                                colorAnimExitSpec = tween(300),
                                scaleAnimExitSpec = tween(300),
                                spaceDegreeAnimExitSpec = tween(300),
                                style = Pie.Style.Fill
                            )


                            Spacer(Modifier.widthIn(8.dp))


                            Column {


                                Text(
                                    text = stringResource(id = R.string.memory_text),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary

                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = "1.5",
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF5C6BC0)

                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = stringResource(id = R.string.memory_text),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary

                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = "2.G",
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFEC407A)

                                )


                            }


                        }












                    }


                }
            }
        }

    }

}
