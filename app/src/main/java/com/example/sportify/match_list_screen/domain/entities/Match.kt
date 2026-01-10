package com.example.sportify.match_list_screen.domain.entities

import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Serializable
data class Match @OptIn(ExperimentalTime::class) constructor(
    val id: Int,
    val area: Area,
    val awayTeam: Team,
    val competition: Competition1,
    val group: String?,
    val homeTeam: Team,
    val lastUpdated: String,
    val matchday: Int,
    val referees: List<Referee>,
    val season: Season,
    val stage: String?,
    val status: String,
    val utcDate: Instant,
    val score: Score?
)

@Serializable
data class Score (
    val winner: String?,
    val fullTime: FullTime
)

@Serializable
data class FullTime(
    val home: Int?,
    val away: Int?
)

@Serializable
data class Area(
    val code: String,
    val id: Int,
    val name: String
)

@Serializable
data class Team(
    val crest: String?,
    val id: Int?,
    val name: String?,
    val shortName: String?,
    val tla: String?
)

@Serializable
data class Competition1(
    val code: String,
    val emblem: String,
    val id: Int,
    val name: String,
    val type: String
)

@Serializable
data class Referee(
    val id: Int,
    val name: String,
    val nationality: String?,
    val type: String
)

@Serializable
data class Season(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String,
)
