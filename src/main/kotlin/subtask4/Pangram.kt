package subtask4

import java.lang.StringBuilder

class Pangram {
    private val vowels = arrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u', 'y', "Y")

    private fun isPangram(s:String):Boolean{
        val letters = Array<Boolean>(26){false}
        for(i in s.indices){
            if(s[i].isLetter())
                letters[s[i].toLowerCase() - 'a'] = true
        }
        return !letters.contains(false)
    }

    private fun vowelsCount(s: String): Int{
        var count = 0
        for(i in s.indices){
            if(vowels.contains(s[i])){
                count++
            }
        }
        return count
    }

    private fun consonantsCount(s: String): Int{
        var count = 0
        for(i in s.indices){
            if(s[i].isLetter() && !vowels.contains(s[i])){
                count++
            }
        }
        return count
    }
    fun getResult(inputString: String): String{
        val pangram = isPangram(inputString)
        val s = inputString.split(" ").filter { it.isNotEmpty() && it[0] !='\n' }.sortedBy {
            if(pangram) vowelsCount(it)
            else consonantsCount(it)
        }
        val result = ArrayList<String>()
        s.forEach(){
            val sb = StringBuilder("")
            var count = 0
            for(c in it){
                if(pangram){
                    if(vowels.contains(c)) {
                        count++
                        sb.append(c.toUpperCase())
                    }else sb.append(c)
                }
                else if(c.isLetter() &&  !vowels.contains(c)) {
                    count++
                    sb.append(c.toUpperCase())
                }else sb.append(c)
            }
            sb.insert(0, count.toString())
            result.add(sb.toString())
        }
        return result.joinToString(" ")
    }
}
