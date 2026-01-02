package com.example.sportify.match_list_screen.presentation

import kotlinx.datetime.LocalDateTime

data class MatchesListState(
    val competitions: List<CompetitionUi> = dummyCompetitions,
    val matches: Map<LocalDateTime, List<MatchUi>> = emptyMap(),
    val isLoadingMatches: Boolean = false,
    val isLoadingCompetitions: Boolean = false,
    val selectedCompetitionId: Int = 2021,
    val selectedTab: MatchTab = MatchTab.UPCOMING,
    val isRefreshing: Boolean = true
)

val dummyCompetitionUi = CompetitionUi(
    id = 0,
    name = "Unknown",
    emblem = ""
)

val dummyCompetitions = (1..10).map {
    dummyCompetitionUi
}.toList()