package com.briolink.location.model

import com.briolink.location.enumeration.TypeLocationEnum
import com.fasterxml.jackson.annotation.JsonProperty

data class LocationId(
    @JsonProperty
    var id: Int,
    @JsonProperty
    var type: TypeLocationEnum,
) {
    companion object {
        fun fromString(typeAndId: String): LocationId {
            val attribute = typeAndId.split(";")
            return LocationId(
                id = attribute[1].toInt(),
                type = TypeLocationEnum.valueOf(attribute[0]),
            )
        }
    }
}
