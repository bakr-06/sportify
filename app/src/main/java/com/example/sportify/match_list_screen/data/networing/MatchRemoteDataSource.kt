package com.example.sportify.match_list_screen.data.networing

import com.example.sportify.BuildConfig
import com.example.sportify.core.data.networking.util.constructUrl
import com.example.sportify.core.data.networking.util.safeCall
import com.example.sportify.core.domain.NetworkError
import com.example.sportify.core.domain.Result
import com.example.sportify.core.domain.map
import com.example.sportify.match_list_screen.domain.MatchDataSource
import com.example.sportify.match_list_screen.domain.entities.Competition
import com.example.sportify.match_list_screen.domain.entities.Match
import io.ktor.client.*
import io.ktor.client.request.*
import java.time.LocalDate


class MatchRemoteDataSource(private val httpClient: HttpClient) : MatchDataSource {

    override suspend fun getMatchesByCompetitionId(
        id: Int,
        dateFrom: LocalDate,
        dateTo: LocalDate
    ): Result<List<Match>, NetworkError> {
        return safeCall<MatchesDto> {
            httpClient.get(constructUrl("/competitions/$id/matches")) {
                headers.append("X-Auth-Token", BuildConfig.API_KEY)
                parameter("dateFrom", dateFrom)
                parameter("dateTo", dateTo)
            }
        }.map { matchesDto ->
            matchesDto.matches
        }
    }

    override suspend fun getAllCompetitions(): Result<List<Competition>, NetworkError> {
        return safeCall<CompetitionsDto> {
            httpClient.get(constructUrl("/competitions")) {
                headers.append("X-Auth-Token", BuildConfig.API_KEY)
            }
        }.map { competitionsDto ->
            competitionsDto.competitions
        }
    }
}