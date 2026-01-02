package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportify.core.presentation.theme.ui.GayRed
import com.example.sportify.core.presentation.theme.ui.bebasNueueFontFamily
import com.example.sportify.core.presentation.theme.ui.chipShape
import com.example.sportify.core.presentation.theme.ui.manropeFontFamily

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Matches",
            fontFamily = manropeFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )
        Row(
            modifier = Modifier
                .clip(chipShape)
                .background(GayRed)
                .padding(start = 24.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "FOOTBALL",
                fontFamily = bebasNueueFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFFFAFAFA)
            )
            Icon(
                imageVector =  Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
                tint = Color(0xFFFAFAFA)
            )
        }
    }
}
