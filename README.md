# Location library

## Installation

To connect to the project in gradle.kts connect the maven repository.

```kotlin
repositories {
    maven {
        url = uri("https://gitlab.com/api/v4/projects/33422039/packages/maven")
        authentication {
            create<HttpHeaderAuthentication>("header")
        }
        credentials(HttpHeaderCredentials::class) {
            name = "Deploy-Token"
            value = System.getenv("CI_DEPLOY_PASSWORD")
        }
    }
}

dependencies {
    implementation("com.briolink.lib:location")
}

```

In the project configuration add lines to connect to the api location-service

```yaml
location-service:
  api:
    url: https://location-service.${env.spring_profiles_active}.svc.cluster.local/
    version: 1
```

You can now access com.briolink.lib.service.LocationService

## Documentation

### Basic classes

[LocationId](https://gitlab.com/briolink/network/backend/location-lib/-/blob/main/src/main/kotlin/com/briolink/lib/location/model/LocationId.kt) - Unique location identifier

[LocationService](https://gitlab.com/briolink/network/backend/location-lib/-/blob/main/src/main/kotlin/com/briolink/lib/location/service/LocationService.kt) - Service that makes requests to the api location service 
### Basic interfaces
[LocationInfoInterface](https://gitlab.com/briolink/network/backend/location-lib/-/blob/main/src/main/kotlin/com/briolink/lib/location/model/LocationInfoInterface.kt) - it can be inherited to get location information

[LocationInfoTypeInterface](https://gitlab.com/briolink/network/backend/location-lib/-/blob/main/src/main/kotlin/com/briolink/lib/location/model/LocationInfoTypeInterface.kt) - Basic location type info

The service has 2 methods:

```kotlin
/**
 * 
 * Returns the suggestion for the location
 * @param query 
 * @return List suggestion with LocationId and Name
 * 
 */
fun getSuggestionLocation(query: String? = null): List<LocationSuggestion>?

fun <T : LocationInfoInterface> getLocationInfo(locationId: LocationId, type: Class<T>): T?
```

## Examples
### Suggestions
We should get suggestion when the user entered "Ark"

```kotlin
    locationService.getSuggestionLocation("Ark").forEach {
    println(it)
}
```

This example will return list "LocationSuggestion"
```
LocationSuggestion(locationId=State;1973, name=Arkhangai Province, Mongolia)
LocationSuggestion(locationId=State;1444, name=Arkansas, United States)
LocationSuggestion(locationId=State;1849, name=Arkhangelsk, Russia)
```
### Information about location

We need to get the currency state by LocationId(id = 1849, type = "State")

You need to override LocationInfoInterface and LocationInfoTypeInterface

LocationStateWithCurrency must be contained properties currency ([See Country](https://gitlab.com/briolink/network/backend/location-lib/-/blob/main/src/main/kotlin/com/briolink/lib/location/model/Country.kt))

```kotlin
data class LocationInfo(
    override val country: LocationStateWithCurrency,
    override val state: LocationMinInfoType? = null,
    override val city: LocationMinInfoType? = null,
) : LocationInfoInterface

data class LocationStateWithCurrency(
    override var id: Int,
    override var name: String,
    var currency: String? = null
) : LocationInfoTypeInterface
```

And call getLocationInfo

```kotlin
locationService.getLocationInfo(LocationId(type = TypeLocationEnum.State, id = 1849), LocationStateWithCurrency::class.java)?.also {
    println(it.country.currency)
}
```
This example will return currency "RUB"
