package com.briolink.lib.location.service

import com.briolink.lib.location.exception.FailedParseLocationIdException
import com.briolink.lib.location.exception.UnavailableLocationServiceException
import com.briolink.lib.location.model.LocationId
import com.briolink.lib.location.model.LocationInfoInterface
import com.briolink.lib.location.model.LocationSuggestion
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class LocationService(private val webClient: WebClient) {
    private val locationUrl = "locations"
    fun getSuggestionLocation(query: String? = null): List<LocationSuggestion>? {
        val listSuggestion = webClient.get()
            .uri("/$locationUrl/suggestions?query=${query.orEmpty()}")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntityList(LocationSuggestion::class.java)
            .block()

        return listSuggestion?.body?.ifEmpty { null }
    }

    fun <T : LocationInfoInterface> getLocationInfo(locationId: LocationId, type: Class<T>): T? {
        return try {
            webClient.get()
                .uri("/$locationUrl/info?type=${locationId.type.name}/${locationId.id}")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError) { throw UnavailableLocationServiceException() }
                .onStatus({ it.value() == HttpStatus.BAD_REQUEST.value() }) {
                    throw FailedParseLocationIdException(locationId.toString())
                }
                .bodyToMono(type)
                .block()
        } catch (e: Exception) {
            null
        }
    }
}
