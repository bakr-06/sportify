package com.example.sportify.match_list_screen.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sportify.core.presentation.theme.ui.GayRed
import com.example.sportify.core.presentation.theme.ui.SportifyTheme
import com.example.sportify.match_list_screen.presentation.components.*

@Composable
fun MatchesScreen(
    uiState: MatchesListState = MatchesListState(),
    onCompetitionClick: (Int) -> Unit = {},
    onTabClick: (MatchTab) -> Unit = {},
    onRefresh: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        TopBar()
        if (!uiState.isLoadingCompetitions) {
            CompetitionRow(
                competitionUiItems = uiState.competitions,
                modifier = Modifier.fillMaxWidth(),
                onItemClick = onCompetitionClick,
                uiState.selectedCompetitionId
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GayRed)
            }
        }

        MatchesTabRow(
            modifier = Modifier.fillMaxWidth(0.75f),
            tabs = MatchTab.entries,
            selectedTab = uiState.selectedTab,
            onTabClick = onTabClick
        )
        if (!uiState.isLoadingMatches) {
            when (uiState.selectedTab) {
                MatchTab.UPCOMING -> {
                    UpcomingMatchesList(
                        matches = uiState.matches,
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = onRefresh
                    )
                }

                MatchTab.PAST -> {
                    PastMatchesList(
                        matches = uiState.matches,
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = onRefresh
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = GayRed)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun UpcomingMatchesScreenPreview() {
    SportifyTheme {
        MatchesScreen()
    }
}