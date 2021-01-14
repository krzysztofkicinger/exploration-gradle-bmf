package com.kicinger.exploration.gradle.contract

@ContractDsl
class PermissionDsl(
        var name: String = "SOME_PERMISSION"
) {

    fun toContract() = Permission(name)

}

fun permission(block: PermissionDsl.() -> Unit) = PermissionDsl().apply(block).toContract()

