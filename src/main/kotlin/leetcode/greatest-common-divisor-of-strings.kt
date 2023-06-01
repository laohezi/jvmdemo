package leetcode

fun main() {



}

fun gcdOfStrings(str1: String, str2: String): String {
    if (str1+str2 != str2 +str1) return ""
    else{
        return  str1.substring(0, gcd(str1.length,str2.length))
    }

}

fun gcd(a:Int,b:Int): Int {
   return  if (a%b ==0){
       b
   }else{
       gcd(b,a%b)
   }
}
