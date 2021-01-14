package com.kicinger.exploration.application.users

import com.kicinger.exploration.gradle.application.users.UsersController
import com.kicinger.exploration.gradle.contract.user
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UsersControllerUnitTest {

    val controller: UsersController = UsersController()

    @Test
    internal fun `should return correct user`() {
        val expectedUser = user {
            username = "test"
        }

        assertThat(controller.gradleMessage).isEqualTo(expectedUser)
    }

}