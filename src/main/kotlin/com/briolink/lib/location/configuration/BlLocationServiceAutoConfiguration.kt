package com.briolink.lib.location.configuration

import com.briolink.lib.location.service.LocationService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@ComponentScan("com.briolink.location.service")
@EnableConfigurationProperties(
    BlPLocationConfigurationProperties::class
)
@ConditionalOnProperty(prefix = "location-service.api", name = ["url", "version"])
class BlLocationServiceAutoConfiguration {
    @Value("\${location-service.api.url}")
    lateinit var urlApi: String

    @Value("\${location-service.api.version}")
    lateinit var apiVersion: String

    @Bean
    @Primary
    fun locationService() = LocationService(WebClient.create("$urlApi/api/v$apiVersion/"))
}
