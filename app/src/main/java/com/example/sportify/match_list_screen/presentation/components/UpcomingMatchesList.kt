package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportify.match_list_screen.presentation.MatchUi
import kotlinx.datetime.LocalDateTime

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpcomingMatchesList(
    matches: Map<LocalDateTime, List<MatchUi>>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PullToRefreshLazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
    ) {
        matches.forEach { (date, matches) ->
            stickyHeader {
                Text(
                    text = "${date.day} ${date.month.name.lowercase().capitalize(Locale.current)}, ${date.dayOfWeek.name.lowercase().capitalize(Locale.current)}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF1E1E1E))
                        .padding(8.dp)
                )
            }
            items(items = matches) { matchUi ->
                UpcomingMatchListItem(matchUi = matchUi)
            }
        }
    }
}