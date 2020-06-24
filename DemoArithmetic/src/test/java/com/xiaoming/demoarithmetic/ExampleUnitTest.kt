package com.xiaoming.demoarithmetic

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testSelectSortMain() {
        val array = arrayOf(2, 4, 3, 11, 5, 22, 51, 54, 12, 43, 75, 7)
        array.sort()
        println(array.joinToString { it.toString() })
//        selectSort(array)
//        bubbleSort(array)
//        insertSort(array)
    }

    /**
     * 选择排序
     * @param array Array<Int>
     */
    private fun selectSort(array: Array<Int>) {
        var min: Int
        var temp: Int
        array.forEachIndexed { index, data ->
            min = data
            temp = data
            for (index2 in index until array.size) {
                if (array[index2] < min) {
                    min = array[index2]
                    array[index] = min
                    array[index2] = temp
                }
            }
        }
        array.forEach {
            println(it)
        }
    }

    /**
     * 冒泡排序
     * @param array Array<Int>
     */
    private fun bubbleSort(array: Array<Int>) {
        val size = array.size
        var isModify: Boolean//是否有位置替换，没有替换说明已经排序好了，则直接跳出循环
        array.forEachIndexed { index, data ->
            isModify = false
            for (indexTwo in 0 until (size - index - 1)) {
                if (array[indexTwo] > array[indexTwo + 1]) {
                    isModify = true
                    val temp = array[indexTwo]
                    array[indexTwo] = array[indexTwo + 1]
                    array[indexTwo + 1] = temp
                }
            }
            if (!isModify)
                return@forEachIndexed
        }
        println(array.joinToString(",") { it.toString() })
    }

    private fun insertSort(array: Array<Int>) {
        val size = array.size
        for (index in 1 until size) {
            val temp = array[index]
            var index3 = 0
            for (index2 in index - 1 downTo 0 step 1) {
                index3 = index2
                if (array[index2] > temp) {
                    array[index2 + 1] = array[index2]
                } else {
                    break
                }
            }
            array[index3 + 1] = temp
        }
        println(array.joinToString(",") { it.toString() })
    }
}
