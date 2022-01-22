package com.briolink.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ListLocationSuggestion(
    @JsonProperty
    val listLocationSuggestion: List<LocationSuggestion>
)

data class LocationSuggestion(
    @JsonProperty
    val locationId: LocationId,
    @JsonProperty
    val name: String,
)
