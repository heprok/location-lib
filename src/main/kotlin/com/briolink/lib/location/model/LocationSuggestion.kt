package com.briolink.lib.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationSuggestion(
    @JsonProperty
    val locationId: LocationId,
    @JsonProperty
    val name: String,
)
