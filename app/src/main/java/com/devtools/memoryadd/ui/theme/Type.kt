package com.devtools.memoryadd.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.devtools.memoryadd.R


val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)



val Ubuntu = GoogleFont("Ubuntu")
val Nunito = GoogleFont("Nunito")

val fontUbuntu = FontFamily(

    Font(
        googleFont = Ubuntu,
        fontProvider = provider,
    )
)

val fontNunito = FontFamily(

    Font(
        googleFont = Nunito,
        fontProvider = provider,
    )
)



val MyTypography = Typography(


    bodySmall = TextStyle(
        fontFamily = fontUbuntu,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp/*...*/
    ),


    bodyMedium = TextStyle(
        fontFamily = fontUbuntu,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp/*...*/
    ),



    bodyLarge = TextStyle(
        fontFamily = fontUbuntu,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp/*...*/

    ),


    titleLarge  = TextStyle(
        fontFamily = fontUbuntu,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
        /*...*/
    )

)