package com.briolink.location.model

import com.briolink.location.enumeration.TypeLocationEnum
import com.briolink.location.exception.FailedParseLocationIdException
import com.fasterxml.jackson.annotation.JsonProperty

data class LocationId(
    @JsonProperty
    var id: Int,
    @JsonProperty
    var type: TypeLocationEnum,
) {
    override fun toString(): String {
        return "${type.name};$id"
    }

    companion object {
        fun fromString(typeAndId: String): LocationId {
            val attribute = typeAndId.split(";")
            if (attribute.count() != 2) throw FailedParseLocationIdException(typeAndId)
            return LocationId(
                id = attribute[1].toInt(),
                type = TypeLocationEnum.valueOf(attribute[0]),
            )
        }
    }
}
