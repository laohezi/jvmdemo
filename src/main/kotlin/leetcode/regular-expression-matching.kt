package leetcode

fun isMatch(s: String, p: String): Boolean {

    val f = Array(s.length+1){Array(p.length+1){false} }
    f[0][0] = true
    // i 表示的是前i个字符,而非 下标[i]
    for (i in 0 ..s.length){
        for (j in 1 ..  p.length){
          if (p[j-1]=='*'){
              if (matches(s,p, i, j-1)){
                  f[i][j] = f[i-1][j] || f[i][j-2]
              }else{
                  f[i][j] = f[i][j-2]
              }
          }else{
              if (matches(s,p,i,j)){
                  f[i][j] = f[i-1][j-1]
              }
          }
        }
    }

    return  f[s.length][p.length]

}

fun matches(s:String,p:String, i:Int,j:Int): Boolean {
    if (i==0){
        return false
    }
    if (p[j-1] =='.'){
        return true
    }else{
        return  s[i-1]==p[j-1]
    }

}

