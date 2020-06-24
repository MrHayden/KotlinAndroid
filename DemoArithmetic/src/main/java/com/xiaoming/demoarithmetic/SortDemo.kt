package com.xiaoming.demoarithmetic

import org.jetbrains.annotations.TestOnly

/**
 * author: xxm
 * created on: 2019/11/29 10:13
 * description: 排序例子
 */
class SortMethodUtil {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {
            val array = arrayOf(2, 21, 32, 4, 3, 11, 5, 22, 51, 54, 12, 43, 75, 7)
            array.sort()
            println(array.joinToString { it.toString() })

            bubbleSort(array)
            selectSort(array)
            insertSort(array)
            binarySort(array)
            quickSort(array)
        }

        /**
         * 冒泡排序
         * @param array Array<Int>
         */
        fun bubbleSort(array: Array<Int>) {
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
            println("冒泡排序：${array.joinToString(",") { it.toString() }}")
        }

        /**
         * 选择排序
         * @param array Array<Int>
         */
        fun selectSort(array: Array<Int>) {
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
            println("选择排序：${array.joinToString(",") { it.toString() }}")
        }

        /**
         * 插入排序
         * @param array Array<Int>
         */
        fun insertSort(array: Array<Int>) {
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
            println("插入排序：${array.joinToString(",") { it.toString() }}")
        }

        /**
         * 二分排序
         * @param array Array<Int>
         */
        fun binarySort(array: Array<Int>) {
            val size = array.size
            for (index in 1 until size) {
                val temp = array[index]
                var leftIndex = 0
                var rightIndex = index - 1
                var mid = 0
                while (leftIndex <= rightIndex) {
                    mid = (leftIndex + rightIndex) / 2
                    if (temp > array[mid]) {
                        leftIndex = mid + 1
                    } else {
                        rightIndex = mid - 1
                    }
                }
                //比leftIndex右边大的值要往后移一位，等待temp插入进去
                for (i in index - 1 downTo leftIndex step 1) {
                    array[i + 1] = array[i]
                }
                if (leftIndex != index)
                    array[leftIndex] = temp
            }
            println("二分排序：${array.joinToString(",") { it.toString() }}")
        }

        /**
         * 快速排序
         * @param array Array<Int>
         */
        fun quickSort(array: Array<Int>) {
            quickMidIndex(array, 0, array.size - 1)
            println("快速排序：${array.joinToString(",") { it.toString() }}")
        }


        private fun quickMidIndex(array: Array<Int>, low: Int, high: Int) {
            if (low < high) {
                val mid = quickOneIndex(array, low, high)
                quickMidIndex(array, 0, mid - 1)
                quickMidIndex(array, mid + 1, high)
            }
        }

        /**
         * 获取当前基准元素所在排序好的数组的对应下标
         * @param array Array<Int>
         * @param low Int  比基准元素小的下标
         * @param high Int 比基准元素大的下标
         */
        private fun quickOneIndex(array: Array<Int>, low: Int, high: Int): Int {
            val temp = array[low] //基准元素
            var mLow = low
            var mHigh = high
            while (mLow < mHigh) {
                while (mLow < mHigh && array[mHigh] >= temp) {
                    mHigh--
                }
                array[mLow] = array[mHigh]

                while (mLow < mHigh && array[mLow] <= temp) {
                    mLow++
                }
                array[mHigh] = array[mLow]
            }
            array[mLow] = temp
            return mLow
        }
    }

}

