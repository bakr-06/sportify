package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
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
import com.example.sportify.match_list_screen.presentation.TeamUi

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
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            TimeRow(
                matchUi.displayTime,
                matchUi.competitionUi.emblem
            )
            TeamsRow(matchUi.homeTeam, matchUi.awayTeam)
            StageBox(matchUi.stage)
        }
    }
}

@Composable
private fun TeamsRow(
    homeTeamUi: TeamUi,
    awayTeamUi: TeamUi,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Text(
                text = homeTeamUi.tla,
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            AsyncImage(
                model = homeTeamUi.crest,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            AsyncImage(
                model = awayTeamUi.crest,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = awayTeamUi.tla,
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun TimeRow(displayTime: String, competitionEmblem: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = competitionEmblem,
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
                text = displayTime,
                fontFamily = manropeFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
fun StageBox(stage: String, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E1E))
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            text = stage,
            fontFamily = manropeFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color(0xFFFFFFFF)
        )
    }
}
