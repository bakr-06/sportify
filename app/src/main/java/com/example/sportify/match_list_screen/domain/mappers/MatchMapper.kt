package com.example.sportify.match_list_screen.domain.mappers

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.example.sportify.match_list_screen.domain.entities.Competition
import com.example.sportify.match_list_screen.domain.entities.Competition1
import com.example.sportify.match_list_screen.domain.entities.Match
import com.example.sportify.match_list_screen.domain.entities.Team
import com.example.sportify.match_list_screen.presentation.CompetitionUi
import com.example.sportify.match_list_screen.presentation.MatchUi
import com.example.sportify.match_list_screen.presentation.TeamUi
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun Match.toUpcomingMatchUi(): MatchUi {
    return MatchUi(
        competitionUi = this.competition.toCompetitionUi(),
        homeTeam = this.homeTeam.toTeamUi(),
        awayTeam = this.awayTeam.toTeamUi(),
        stage = (this.stage ?: "no stage")
            .replace(oldValue = "_", newValue = " ")
            .lowercase()
            .capitalize(Locale.current),
        dateTime = this.utcDate.toLocalDateTime(TimeZone.currentSystemDefault()),
        displayTime = utcDate.formatTo12HourTime(),
        relativeTime = "${utcDate - Clock.System.now()}",
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

// ai slop, sry!
@OptIn(ExperimentalTime::class)
fun Instant.formatTo12HourTime(): String {
    val userTimeZone = TimeZone.currentSystemDefault()

    // Convert UTC Instant to user's LocalDateTime
    // Documentation: https://kotlinlang.org/api/kotlinx-datetime/kotlinx-datetime/kotlinx.datetime/to-local-date-time.html
    val localDateTime = this.toLocalDateTime(userTimeZone)
    val hour = localDateTime.hour
    val minute = localDateTime.minute
    return format12Hour(hour, minute)
}

private fun format12Hour(hour: Int, minute: Int): String {
    val period = if (hour < 12) "AM" else "PM"
    val displayHour = when {
        hour == 0 -> 12
        hour > 12 -> hour - 12
        else -> hour
    }

    val formattedMinute = minute.toString().padStart(2, '0')

    return "$displayHour:$formattedMinute $period"
}