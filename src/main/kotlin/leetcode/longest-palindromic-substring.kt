package leetcode


fun main(args: Array<String>) {
    val solution = DynamicProgramming()
    val s = "aaaaaaaaaa"
    val res = solution.longestPalindrome(s)
    println(res)

}

class CentralDiffusion {
    fun longestPalindrome(s: String): String {

        var longestPalindrome: String = ""
        val chars = s.chars()
        for (i in 0 until s.length) {
            val stepMax = longestPalindrome(s, i)
            if (stepMax.length > longestPalindrome.length) {
                longestPalindrome = stepMax
            }
        }

        if (longestPalindrome.isEmpty()) {
            return s[0].toString()
        }

        return longestPalindrome

    }

    fun longestPalindrome(str: String, position: Int): String {
        var maxABA = ""
        var maxAA = ""

        var i = position - 1;
        var j = position + 1;
        while (i >= 0 && j <= str.length && str[i] == str[j]) {
            maxABA = str.substring(i, j + 1)
            i--;j++
        }
        var k = position - 1
        var l = position
        while (k >= 0 && l <= str.length && str[k] == str[l]) {
            maxAA = str.substring(k, l + 1)
            k--;l++
        }

        if (maxABA.length > maxAA.length) {
            return maxABA
        } else {
            return maxAA
        }
    }
}

class DynamicProgramming {

    fun longestPalindrome(s: String): String {
        val n = s.length
        val dp = Array(n){Array(n){false} }
        var maxStatrt = 0
        var maxEnd = 0
        for (i  in n-1 downTo   0){
            for (j in  0 until  n){
                if (s[i] == s[j]){
                    if (j-i<3){
                        dp[i][j] = true
                    }else{
                        dp[i][j] = dp[i+1][j-1]
                    }
                }

                if (dp[i][j]&& j-i> maxEnd-maxStatrt){
                    maxStatrt = i
                    maxEnd = j
                }
            }

        }

        return s.substring(maxStatrt,maxEnd+1)



    }

}




