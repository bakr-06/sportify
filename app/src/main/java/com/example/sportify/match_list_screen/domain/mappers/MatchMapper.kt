package com.example.sportify.match_list_screen.domain.mappers

import com.example.sportify.match_list_screen.domain.entities.Competition
import com.example.sportify.match_list_screen.domain.entities.Competition1
import com.example.sportify.match_list_screen.domain.entities.Match
import com.example.sportify.match_list_screen.domain.entities.Team
import com.example.sportify.match_list_screen.presentation.CompetitionUi
import com.example.sportify.match_list_screen.presentation.MatchUi
import com.example.sportify.match_list_screen.presentation.TeamUi
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.char

fun Match.toUpcomingMatchUi(): MatchUi {
    val format = LocalDateTime.Format {
        year()
        char('-')
        monthNumber()
        char('-')
        day()
        char('T')
        hour()
        char(':')
        minute()
        char(':')
        second()
        char('Z')
    }
    return MatchUi(
        competitionUi = this.competition.toCompetitionUi(),
        homeTeam = this.homeTeam.toTeamUi(),
        awayTeam = this.awayTeam.toTeamUi(),
        stage = this.stage ?: "no stage",
        dateTime = LocalDateTime.parse(this.utcDate, format),
        referees = this.referees,
        id = this.id,
        group = this.group ?: "no group",
        lastUpdated = this.lastUpdated,
        matchDay = this.matchday,
        season = this.season,
        status = this.status,
        score = this.score
    )
}

private fun Competition1.toCompetitionUi(): CompetitionUi {
   return CompetitionUi(
        id = this.id,
        name = this.name,
        emblem = this.emblem
    )
}

fun Competition.toCompetitionUi(): CompetitionUi {
    return CompetitionUi(
        id = this.id,
        name = this.name,
        emblem = this.emblem
    )
}

private fun Team.toTeamUi(): TeamUi {
    return TeamUi(
        name = this.name ?: "Unknown Team",
        shortName = this.shortName ?: "Unknown",
        tla = this.tla ?: "UNK",
        crest = this.crest ?: ""
    )
}

fun Int.to12(): String {
    return if (this > 12) "${this.minus(12)} pm" else "$this am"
}