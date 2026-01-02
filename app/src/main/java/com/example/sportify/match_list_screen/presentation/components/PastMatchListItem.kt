package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.sportify.R
import com.example.sportify.core.presentation.theme.ui.SportifyTheme
import com.example.sportify.core.presentation.theme.ui.manropeFontFamily
import com.example.sportify.match_list_screen.domain.entities.FullTime
import com.example.sportify.match_list_screen.domain.entities.Score
import com.example.sportify.match_list_screen.domain.entities.Season
import com.example.sportify.match_list_screen.presentation.CompetitionUi
import com.example.sportify.match_list_screen.presentation.MatchUi
import com.example.sportify.match_list_screen.presentation.TeamUi
import kotlinx.datetime.LocalDateTime

@Composable
fun PastMatchListItem(
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
                        Text(
                            text = "${matchUi.score?.fullTime?.home ?: -1}"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(36.dp)
                    ) {
                        Text(
                            text = "${matchUi.score?.fullTime?.away ?: -1}"
                        )
                        AsyncImage(
                            model = matchUi.awayTeam.crest,
                            contentDescription = null,
                            placeholder = painterResource(R.drawable.manchester_united),
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E1E1E))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.background(Color.White).padding(3.dp), contentAlignment = Alignment.Center) {
                        AsyncImage(
                            model = matchUi.competitionUi.emblem,
                            placeholder = painterResource(R.drawable.premier_league),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(24.dp)
                        )
                    }
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
}

@Preview(showBackground = true)
@Composable
private fun PastMatchListItemPreview() {
    SportifyTheme {
        PastMatchListItem(
            matchUi = MatchUi(
                id = -1,
                competitionUi = CompetitionUi(
                    id = -1,
                    name = "Premier League",
                    emblem = "https://crests.football-data.org/PL.png"
                ),
                homeTeam = TeamUi(
                    name = "Manchester United FC",
                    shortName = "Man United",
                    tla = "MUN",
                    crest = "https://crests.football-data.org/66.png"
                ),
                awayTeam = TeamUi(
                    name = "Manchester United FC",
                    shortName = "Man United",
                    tla = "MUN",
                    crest = "https://crests.football-data.org/66.png"
                ),
                dateTime = LocalDateTime.parse("2021-07-31T11:15:30"),
                stage = "league Match",
                group = "",
                lastUpdated = "",
                matchDay = 1,
                status = "",
                referees = listOf(),
                season = Season(1, "", 1, ""),
                score = Score("", fullTime = FullTime(1, 1))
            )
        )
    }
}