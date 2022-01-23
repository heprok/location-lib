package com.briolink.location.service

import com.briolink.location.model.ListLocationSuggestion
import com.briolink.location.model.LocationId
import com.briolink.location.model.LocationInfo
import com.briolink.location.model.LocationSuggestion
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

class LocationService(private val webClient: WebClient) {
    private val locationUrl = "locations"
    fun getSuggestionLocations(query: String? = null): List<LocationSuggestion>? {
        val listSuggestion = webClient.get()
            .uri("/$locationUrl/?query=${query.orEmpty()}")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ListLocationSuggestion::class.java)
            .block()

        return listSuggestion?.listLocationSuggestion?.ifEmpty { null }
    }

    fun getLocationInfo(locationId: LocationId): LocationInfo? {
        return webClient.get()
            .uri("/$locationUrl/info?type=${locationId.type.name}/${locationId.id}")
            .retrieve()
            .bodyToMono(LocationInfo::class.java)
            .block()
    }
}
