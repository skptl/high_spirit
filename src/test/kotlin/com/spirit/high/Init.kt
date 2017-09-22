package com.spirit.high

import org.junit.Test
import kotlin.test.assertEquals

class InitTest {

    @Test fun testInit() {
        val init = Init("test")
        assertEquals(init.arg, "test")
        assertEquals(init.rarg, "tset")
    }

}