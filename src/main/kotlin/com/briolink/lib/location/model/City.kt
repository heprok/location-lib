package com.briolink.lib.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class City(
    @JsonProperty
    override var id: Int,

    @JsonProperty
    override var name: String,

    @JsonProperty
    var countryCode: String,

    @JsonProperty
    var countryId: Int,

    @JsonProperty
    var stateId: Int,

    @JsonProperty
    var latitude: Double? = null,

    @JsonProperty
    var longitude: Double? = null,

    @JsonProperty
    var wikiDataId: String? = null,
) : LocationInfoTypeInterface
