package subtask3

class Abbreviation {
    var result = false

    fun check(a: String, b: String, i: Int, j: Int){
        if(j == b.length){
            result = true
            return
        }
        if(i == a.length) return
        if(result) return
        else{
            if(a[i] == b[j]) check(a, b, i+1, j+1)
            else if(a[i] == b[j].toLowerCase()){
                check(a, b, i+1, j+1)
                check(a, b, i+1, j)
            }
            else if(a[i].isUpperCase()) return
            else check(a, b, i+1, j)
        }
    }

    fun abbreviationFromA(a: String, b: String): String {
        check(a, b, 0, 0)
        return if(result) "YES" else "NO"
    }
}
