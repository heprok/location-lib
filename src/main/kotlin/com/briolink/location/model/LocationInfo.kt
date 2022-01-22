package com.briolink.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationInfo(
    @JsonProperty
    val country: Country,
    @JsonProperty
    val state: State? = null,
    @JsonProperty
    val city: City? = null,
    @JsonProperty
    val location: String
)
