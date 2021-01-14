package com.kicinger.exploration.gradle.contract

@DslMarker
annotation class ContractDsl

@ContractDsl
class UserDsl(
        var username: String = "SOME_USERNAME",
        var permissions: MutableList<Permission> = mutableListOf()
) {

    fun withPermission(block: PermissionDsl.() -> Unit) =
            permissions.add(permission(block))

    fun toContract() = User(username, permissions)

}

fun user(block: UserDsl.() -> Unit) = UserDsl().apply(block).toContract()

//val user = user {
//    username = "Jan Kowalski"
//    withPermission { name = "editInvoicePermission" }
//}