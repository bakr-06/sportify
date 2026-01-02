package com.example.sportify.match_list_screen.presentation.components

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sportify.core.presentation.theme.ui.GayRed
import com.example.sportify.core.presentation.theme.ui.SportifyTheme
import com.example.sportify.match_list_screen.presentation.MatchTab

@Composable
fun MatchesTabRow(
    modifier: Modifier = Modifier,
    selectedTab: MatchTab = MatchTab.UPCOMING,
    tabs: List<MatchTab> = MatchTab.entries,
    onTabClick: (MatchTab) -> Unit = { }
) {
    PrimaryTabRow(
        selectedTabIndex = selectedTab.ordinal,
        modifier = modifier,
        indicator = {
//        if (selectedTab.ordinal < tabPositions.size) {
//            TabRowDefaults.SecondaryIndicator(
//                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab.ordinal]),
//                color = GayRed
//            )
//        }
    },
    ) {
        tabs.forEach { tab ->
            Tab(
                selected = selectedTab == tab,
                onClick = { onTabClick(tab) },
                text = {
                    Text(
                        text = tab.title,
                        color = if (selectedTab == tab) {
                            Color(0xFF150000)
                        } else {
                            Color(0xFF5B5757)
                        }
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MatchesTabRowPreview() {
    SportifyTheme {
        MatchesTabRow()
    }
}
