package com.example.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

// Set of Material typography styles to start with
val SpaceGrotesk = FontFamily(
    Font(R.font.spacegrotesk_medium, FontWeight.SemiBold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 28.sp
    ),
    h3 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 14.sp
    ),
    h5 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = SpaceGrotesk,
        fontSize = 10.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)