package com.briolink.lib.location.exception

import org.springframework.http.HttpStatus

class FailedParseLocationIdException(locationIdStr: String) :
    RuntimeException("Failed to parse locationId from string '$locationIdStr'"), ExceptionInterface {
    override val code: String = "location-id.failed-parse"
    override val httpsStatus: HttpStatus = HttpStatus.BAD_REQUEST
}
