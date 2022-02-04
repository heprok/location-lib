package com.briolink.lib.location.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationFullInfo(
    @JsonProperty
    override val country: Country,
    @JsonProperty
    override val state: State? = null,
    @JsonProperty
    override val city: City? = null,
) : LocationInfoInterface {
    override fun toString(): String {
        return super.asString()
    }
}
