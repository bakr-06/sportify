package com.example.sportify.match_list_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportify.core.domain.onError
import com.example.sportify.core.domain.onSuccess
import com.example.sportify.match_list_screen.domain.MatchDataSource
import com.example.sportify.match_list_screen.domain.entities.Match
import com.example.sportify.match_list_screen.domain.mappers.toCompetitionUi
import com.example.sportify.match_list_screen.domain.mappers.toUpcomingMatchUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MatchViewModel(
    private val matchDataSource: MatchDataSource
) : ViewModel() {
    private val _state = MutableStateFlow(MatchesListState())
    val state = _state
        .onStart { loadCompetitions() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = MatchesListState()
        )

    private val _events = Channel<MatchListEvent>()
    val events = _events.receiveAsFlow()

    fun changeSelectedCompetitionId(competitionId: Int) {
        _state.update {
            it.copy(selectedCompetitionId = competitionId)
        }
        loadMatches()
    }

    fun changeSelectedTab(tab: MatchTab) {
        _state.update {
            it.copy(selectedTab = tab)
        }
        loadMatches()
    }

    fun onRefresh() {
        _state.update {
            it.copy(isRefreshing = true)
        }
        loadMatches()
    }

    private fun loadMatches() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoadingMatches = true)
            }
            matchDataSource
                .getMatchesByCompetitionId(
                    _state.value.selectedCompetitionId,
                    _state.value.selectedTab.dateFrom,
                    _state.value.selectedTab.dateTo
                )
                .onSuccess { matches ->
                    _state.update { state ->
                        state.copy(
                            isLoadingMatches = false,
                            isRefreshing = false,
                            matches = matches.map { match: Match ->
                                match.toUpcomingMatchUi()
                            }.groupBy {
                                it.dateTime
                            }
                        )
                    }
                }
                .onError { networkError ->
                    _state.update {
                        it.copy(
                            isLoadingMatches = false,
                            isRefreshing = false
                        )
                    }
                    _events.send(MatchListEvent.Error(networkError))
                }
        }
    }

    private fun loadCompetitions() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoadingCompetitions = true
                )
            }
            matchDataSource
                .getAllCompetitions()
                .onSuccess { competitions ->
                    _state.update {
                        it.copy(
                            competitions = competitions.map { competition ->
                                competition.toCompetitionUi()
                            },
                            selectedCompetitionId = competitions.first().id,
                            isLoadingCompetitions = false,
                        )
                    }
                    loadMatches()
                }
                .onError { networkError ->
                    _state.update {
                        it.copy(
                            isLoadingCompetitions = false,
                            isRefreshing = true
                        )
                    }
                    _events.send(MatchListEvent.Error(networkError))
                }
        }
    }
}