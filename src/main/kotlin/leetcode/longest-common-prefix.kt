package leetcode
fun longestCommonPrefix(strs: Array<String>): String {

    val stringBuilder = StringBuilder()
    for (i in 0 until Int.MAX_VALUE){
        if (strs[0].length <i-1){
            return stringBuilder.toString()
        }
        val current:Char = strs[0].get(i)
        for (j in 1 until  strs.size){
            if (strs[j].length <j-1 ||strs[j].get(i)!=current){
                return  stringBuilder.toString()
            }
        }
        stringBuilder.append(current)
    }

    return  stringBuilder.toString()




}