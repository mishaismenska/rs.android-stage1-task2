package subtask5

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if(blockB == Int::class){
            var sum = 0
            for(i in blockA.indices){
                if(blockA[i] is Int){
                    sum += blockA[i] as Int
                }
            }
            return sum
        } else if(blockB == String::class){
            var sum = StringBuilder("")
            for(i in blockA.indices){
                if(blockA[i] is String){
                    sum.append(blockA[i] as String)
                }
            }
            return sum.toString()
        } else if(blockB == LocalDate::class){
            var latest: LocalDate = LocalDate.now()
            var check = false
            for(i in blockA.indices){
                if(blockA[i] is LocalDate){
                    if((!check) || ((blockA[i] as LocalDate).compareTo(latest) > 0)){
                        check = true
                        latest = blockA[i] as LocalDate
                    }
                }
            }
            return latest.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        }
        else throw NotImplementedError("Not implemented")
    }
}
