package com.briolink.location.service

import org.springframework.web.reactive.function.client.WebClient

class LocationService(private val webClient: WebClient) {

//    fun suggestionLocations(
//        query: String? = null,
//        type: TypeLocationEnum? = null
//    ): List<LocationSuggestion> {
//        val userPermissionRole = webClient.get()
//            .uri("/$permissionRoleUrl/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId")
//            .retrieve()
// //            .onStatus(HttpStatus::is4xxClientError) {
// //                it.bodyToMono(ErrorResponseDto::class.java)
// //            }
// //            .onStatus(HttpStatus::is4xxClientError) { _ ->
// //                Mono.error<PermissionRoleNotFoundException>(PermissionRoleNotFoundException(userId, accessObjectId))
// //            }
//            .bodyToMono(UserPermissionRoleDto::class.java)
//            .block()
//
//        return userPermissionRole?.let { PermissionRoleEnum.ofId(it.role.id) }
//    }
//
//    fun getUserPermissionRights(
//        userId: UUID,
//        accessObjectId: UUID,
//        accessObjectType: AccessObjectTypeEnum
//    ): UserPermissionRights? {
//        val listUserPermissionRightsDto = webClient.get()
//            .uri("/$permissionRightUrl/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId")
//            .accept(MediaType.APPLICATION_JSON)
//            .retrieve()
//            .bodyToMono(ListUserPermissionRightDto::class.java)
//            .block()
//
//        return listUserPermissionRightsDto?.let {
//            UserPermissionRights(
//                permissionRole = listUserPermissionRightsDto.userRole,
//                permissionRights = listUserPermissionRightsDto.rights,
//            )
//        }
//    }
//
//    fun isHavePermission(
//        userId: UUID,
//        accessObjectType: AccessObjectTypeEnum,
//        accessObjectId: UUID,
//        permissionRight: PermissionRightEnum
//    ): Boolean {
//        val isHavePermission = webClient.get()
//            .uri("/$permissionRightUrl/check-permission/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId&permissionRight=${permissionRight.name}")
//            .retrieve()
//            .bodyToMono(Boolean::class.java)
//            .block()
//
//        return isHavePermission ?: false
//    }
//
//    @Throws(PermissionRoleExistException::class)
//    fun createPermissionRole(
//        userId: UUID,
//        accessObjectType: AccessObjectTypeEnum,
//        accessObjectId: UUID,
//        permissionRole: PermissionRoleEnum
//    ): UserPermissionRole? {
//        val userPermissionRoleDto = webClient.post()
//            .uri("/$permissionRoleUrl/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId&permissionRole=${permissionRole.name}")
//            .retrieve()
//            .onStatus({ it == HttpStatus.CONFLICT }, { throw PermissionRoleExistException() })
//            .bodyToMono(UserPermissionRoleDto::class.java)
//            .block()
//
//        return userPermissionRoleDto?.let { UserPermissionRole.fromDto(it) }
//    }
//
//    fun editPermissionRole(
//        userId: UUID,
//        accessObjectType: AccessObjectTypeEnum,
//        accessObjectId: UUID,
//        permissionRole: PermissionRoleEnum
//    ): UserPermissionRole? {
//        val userPermissionRoleDto = webClient.put()
//            .uri("/$permissionRoleUrl/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId&permissionRole=${permissionRole.name}")
//            .retrieve().onStatus({ it == HttpStatus.NO_CONTENT }, { throw PermissionRoleExistException() })
//            .bodyToMono(UserPermissionRoleDto::class.java).block()
//
//        return userPermissionRoleDto?.let { UserPermissionRole.fromDto(it) }
//    }
//
//    fun deletePermissionRole(
//        userId: UUID,
//        accessObjectType: AccessObjectTypeEnum,
//        accessObjectId: UUID,
//    ): Boolean {
//        val isDeleted = webClient.delete()
//            .uri("/$permissionRoleUrl/?accessObjectId=$accessObjectId&accessObjectType=${accessObjectType.name}&userId=$userId")
//            .retrieve().onStatus({ it == HttpStatus.NO_CONTENT }, { throw PermissionRoleExistException() })
//            .bodyToMono(Boolean::class.java).block()
//
//        return isDeleted ?: false
//    }
}
