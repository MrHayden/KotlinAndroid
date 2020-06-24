package com.xiaoming.kotlinandroid

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getMd5String() {
        val md5Str = "3A:4D:93:84:94:C9:18:2D:4D:02:58:F3:22:33:09:0D"
        md5Str.filter {
            it.toString() != ":"
        }.toLowerCase().apply {
            println(this)
        }
    }
}
