package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val result = IntArray(3){1}
        var t = 0
        while(result[0] * result[1] < n){
            t = result[0] + result[1]
            result[0] = result[1]
            result[1] = t
        }
        if(result[0] * result[1] != n) result[2] = 0
        return result
    }
}
