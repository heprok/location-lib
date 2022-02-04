package com.briolink.lib.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationMinInfoType(
    @JsonProperty
    override var id: Int,
    @JsonProperty
    override var name: String
) : LocationInfoTypeInterface
