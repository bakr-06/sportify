package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.sportify.core.presentation.theme.ui.manropeFontFamily
import com.example.sportify.match_list_screen.presentation.MatchUi

@Composable
fun UpcomingMatchListItem(
    modifier: Modifier = Modifier,
    matchUi: MatchUi
) {
    Surface(
        modifier = modifier,
        color = Color(0xFFEEEDED),
        onClick = { },
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = matchUi.competitionUi.emblem,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFD6D5D5))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = matchUi.dateTime.hour.toString(),
                            fontFamily = manropeFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(36.dp)
                    ) {
                        Text(
                            text = matchUi.homeTeam.tla,
                            fontFamily = manropeFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                        AsyncImage(
                            model = matchUi.homeTeam.crest,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(36.dp)
                    ) {
                        AsyncImage(
                            model = matchUi.awayTeam.crest,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Text(
                            text = matchUi.awayTeam.tla,
                            fontFamily = manropeFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E1E1E))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                Text(
                    text = matchUi.stage
                        .replace(oldValue = "_", newValue = " ")
                        .lowercase(),
                    fontFamily = manropeFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFFFFFFFF)
                )
            }
        }
    }
}