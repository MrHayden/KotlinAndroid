package com.xiaoming.demoarithmetic

import kotlin.math.abs

/**
 * author: xxm
 * created on: 2020/6/24 11:02
 * description: 求和的工具类
 */
class SummationUtil {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {
//            println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
            println(twoSum(intArrayOf(2, 5, 5, 11), 10).joinToString { it.toString() })
        }

        /**
         * 求两数之和
         * @param nums IntArray
         * @param target Int
         * @return IntArray
         */
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val numPosArr = IntArray(2)
            val maxPos = nums.size - 1
            first@ for (i in 0..maxPos) {
                for (j in (i + 1)..maxPos) {
                    if (nums[i] + nums[j] == target) {
                        numPosArr[0] = i
                        numPosArr[1] = j
                        break@first
                    }
                }
            }
            return numPosArr
        }

        /**
         * 最接近的三数之和
         * @param nums IntArray
         * @param target Int
         * @return Int
         *
        给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
        返回这三个数的和。假定每组输入只存在唯一答案。

        链接：https://leetcode-cn.com/problems/3sum-closest

        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
         */
        fun threeSumClosest(nums: IntArray, target: Int): Int {
            nums.sort()
            val n = nums.size
            var best = 1000000

            // 枚举 a
            for (i in 0 until n) {
                // 保证和上一次枚举的元素不相等
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue
                }
                // 使用双指针枚举 b 和 c
                var j = i + 1
                var k = n - 1
                while (j < k) {
                    val sum = nums[i] + nums[j] + nums[k]
                    // 如果和为 target 直接返回答案
                    if (sum == target) {
                        return target
                    }
                    // 根据差值的绝对值来更新答案
                    if (abs(sum - target) < abs(best - target)) {
                        best = sum
                    }
                    if (sum > target) {
                        // 如果和大于 target，移动 c 对应的指针
                        var k0 = k - 1
                        // 移动到下一个不相等的元素
                        while (j < k0 && nums[k0] == nums[k]) {
                            --k0
                        }
                        k = k0
                    } else {
                        // 如果和小于 target，移动 b 对应的指针
                        var j0 = j + 1
                        // 移动到下一个不相等的元素
                        while (j0 < k && nums[j0] == nums[j]) {
                            ++j0
                        }
                        j = j0
                    }
                }
            }
            return best
        }
    }
}