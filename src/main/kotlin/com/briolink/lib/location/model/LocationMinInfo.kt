package com.briolink.lib.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationMinInfo(
    @JsonProperty
    override val country: LocationMinInfoType,
    @JsonProperty
    override val state: LocationMinInfoType? = null,
    @JsonProperty
    override val city: LocationMinInfoType? = null,
) : LocationInfoInterface {
    override fun toString(): String {
        return super.asString()
    }
}
