package com.briolink.lib.location.model

import com.briolink.lib.location.enumeration.TypeLocationEnum

interface LocationInfoInterface {
    val country: LocationInfoTypeInterface
    val state: LocationInfoTypeInterface?
    val city: LocationInfoTypeInterface?

    fun asString(): String = if (city != null) "${city!!.name}, ${state!!.name}, ${country.name}"
    else if (state != null) "${state!!.name}, ${country.name}"
    else country.name

    fun locationId(): LocationId = if (city != null) LocationId(city!!.id, TypeLocationEnum.City)
    else if (state != null) LocationId(state!!.id, TypeLocationEnum.State)
    else LocationId(country.id, TypeLocationEnum.Country)
}
