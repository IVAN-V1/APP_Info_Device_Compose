package com.devtools.memoryadd.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devtools.memoryadd.Componets.Card_versionAndroid
import com.devtools.memoryadd.Componets.PieChart
import com.devtools.memoryadd.R
import com.devtools.memoryadd.data.repository.MemoryService
import com.devtools.memoryadd.viewModel.AndroidServiceViewModel
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home_View() {

    val serviceAndroid = AndroidServiceViewModel()
    val context = LocalContext.current
    val memoryService = MemoryService()

    var totalRam by remember { mutableStateOf(0.0) }
    var availableRam by remember { mutableStateOf(0.0) }
    var availablePercentage by remember { mutableStateOf(0.0) }
    var porcentTotal by remember { mutableStateOf(0.0) }

    var versionAndroid by remember { mutableStateOf("") }
    var brandDevice by remember { mutableStateOf("") }
    var securityPatch by remember { mutableStateOf("") }
    var sdk by remember { mutableStateOf(0) }
    var release by remember { mutableStateOf("") }
    var board by remember { mutableStateOf("") }
    var manufacturer by remember { mutableStateOf("") }
    var host by remember { mutableStateOf("") }
    var codename by remember { mutableStateOf("") }
    var incremental by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }
    var hardware by remember { mutableStateOf("") }



    LaunchedEffect(Unit) {
        serviceAndroid.getVersionAndroid { versionAndroid = it }

       serviceAndroid.getBrandDevice { brandDevice = it }

        serviceAndroid.getSecurityPatch { securityPatch = it }

        serviceAndroid.getSDK { sdk = it }
        serviceAndroid.getRelease { release = it }
        serviceAndroid.getBOARD { board = it }
        serviceAndroid.getMANUFACTURER { manufacturer = it }
        serviceAndroid.getHOST { host = it }
        serviceAndroid.getCODENAME { codename = it }
        serviceAndroid.getINCREMENTAL { incremental = it }
        serviceAndroid.getUSER { user = it }
        serviceAndroid.getTAGS { tags = it }
        serviceAndroid.getTYPE { type = it }
        serviceAndroid.getMODEL { model = it }
        serviceAndroid.getHARDWARE { hardware = it }


        while (true) {
            val (ramInfo1, datainfo_2) = memoryService.getRAMInfo(context)
            totalRam = ramInfo1.first
            availableRam = ramInfo1.second

            availablePercentage = datainfo_2.first
            porcentTotal = datainfo_2.second

            delay(5000)
        }
    }






    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,


        topBar = {

            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {

                    Text(
                        "Info Device",
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge
                    )


                }
            )

        }


    )


    { innerPadding ->




        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,


                ) {


                PieChart(
                  totalRam,
                    availableRam,
                    availablePercentage,
                    porcentTotal
                )


                val deviceInfoList = listOf(
                    R.string.VersionAndroid to versionAndroid to R.drawable.android,
                    R.string.Brand to brandDevice to R.drawable.android_phone,
                    R.string.SecurityPatch to securityPatch to R.drawable.seguridad,
                    R.string.Hardware to hardware to R.drawable.android_phone,
                    R.string.SDK to sdk.toString() to R.drawable.android_phone,
                    R.string.Release to release to R.drawable.android_phone,
                    R.string.Board to board to R.drawable.electronicos,
                    R.string.Manufactured to manufacturer to R.drawable.empresa,
                    R.string.Host to host to R.drawable.android_phone,
                    R.string.codeName to codename to R.drawable.android_phone,
                    R.string.INCREMENTAL to incremental to R.drawable.android_phone,
                    R.string.User to user to R.drawable.user,
                    R.string.Tags to tags to R.drawable.android_phone,
                    R.string.Type to type to R.drawable.android_phone,
                    R.string.Model to model to R.drawable.android_phone
                )

                deviceInfoList.forEach { triple ->
                    val (labelRes, value) = triple.first
                    val iconRes = triple.second
                    Card_versionAndroid(stringResource(id = labelRes), value.toString(), iconRes)
                }



            }

        }

    }

}