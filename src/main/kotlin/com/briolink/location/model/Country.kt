package com.briolink.location.model

import com.fasterxml.jackson.annotation.JsonProperty

class Country(
    @JsonProperty
    override var id: Int,

    @JsonProperty
    override var name: String,

    @JsonProperty
    var iso3: String? = null,

    @JsonProperty
    var iso2: String? = null,

    @JsonProperty
    var numericCode: String? = null,

    @JsonProperty
    var phoneCode: String? = null,

    @JsonProperty
    var capital: String? = null,

    @JsonProperty
    var currency: String? = null,

    @JsonProperty
    var currencySymbol: String? = null,

    @JsonProperty
    var tld: String? = null,

    @JsonProperty
    var native: String? = null,

    @JsonProperty
    var region: String? = null,

    @JsonProperty
    var subregion: String? = null,

    @JsonProperty
    var timezones: String? = null,

    @JsonProperty
    var latitude: Double? = null,

    @JsonProperty
    var longitude: Double? = null,

    @JsonProperty
    var emoji: String? = null,

    @JsonProperty
    var emojiU: String? = null,
) : LocationInfoTypeInterface
