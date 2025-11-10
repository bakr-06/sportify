package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sportify.match_list_screen.presentation.CompetitionUi

@Composable
fun CompetitionRow(
    competitionUiItems: List<CompetitionUi>,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
    selectedItemId: Int,
) {
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(items = competitionUiItems) { item ->
            if (selectedItemId == item.id) {
                SelectedCompetitionListItem(competitionUi = item, onItemClick = { onItemClick(item.id) })
            } else {
                CompetitionListItem(competitionUi = item, onItemClick = { onItemClick(item.id) })
            }
        }
    }
}