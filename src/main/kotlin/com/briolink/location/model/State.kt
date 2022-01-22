package com.briolink.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class State(
    @JsonProperty
    var id: Int? = null,

    @JsonProperty
    var name: String,

    @JsonProperty
    var countryId: Int = 0,

    @JsonProperty
    var countryCode: String,

    @JsonProperty
    var stateCode: String,

    @JsonProperty
    var subtype: String? = null,

    @JsonProperty
    var latitude: Double? = null,

    @JsonProperty
    var longitude: Double? = null,
)
