package leetcode

class TwoSumSolution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val ret = IntArray(2)
        val map  = HashMap<Int,Int>()
        for (i in 0 until nums.size ){
            if (map.containsKey(target -i)){
                ret[0] = i;
                ret[1] = map[target-i]!!
            }
            map[nums[i]] = i
        }
        return  ret

    }
}