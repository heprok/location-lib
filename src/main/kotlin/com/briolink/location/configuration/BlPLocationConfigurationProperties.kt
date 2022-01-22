package com.briolink.location.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "location-service.api")
@Suppress("ConfigurationProperties")
data class BlPLocationConfigurationProperties(
    val url: String,
    val version: String
)
