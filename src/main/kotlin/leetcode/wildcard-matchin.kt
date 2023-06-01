package leetcode


fun main() {
    val match = DPWildMatch()
    match.isMatch("aab","c*a*b")
}

class DPWildMatch{
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        val dp = Array(m+1){Array(n+1){false}}

      //  dp[0] = Array(n+1){true}
        dp[0][0] = true



        for (i in 0 .. m){
            for ( j in 1  ..n){
                if (i ==0){
                    if (p[j-1]=='*'){
                      dp[i][j] = dp[i][j-1]
                    }
                }else{
                    if (p[j-1]=='*'){
                        dp[i][j] = dp[i-1][j] ||dp[i][j - 1]
                    }else{
                        if (match(s,p,i,j)){
                            dp[i][j] = dp[i-1][j-1]
                        }else{
                            dp[i][j] = false
                        }
                    }
                }



            }
        }

        return  dp[m][n]


    }


    fun match(s:String,p:String,i:Int,j:Int): Boolean {
        if(p[j-1]=='?'){
            return true
        }
        return s[i-1] == p[j-1]
    }

}


