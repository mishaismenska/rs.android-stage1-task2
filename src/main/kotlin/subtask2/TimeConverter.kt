package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val numbers = arrayOf(
            "one", "two", "three", "four",
            "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty"
        )
        val intHour = hour.toInt()
        val intMinute = minute.toInt()
        return when {
            intMinute > 60 -> ""
            intMinute == 0 -> numbers[intHour - 1] + " o' clock"
            intMinute == 15 -> "quarter past " + numbers[intHour - 1]
            intMinute == 30 -> "half past " + numbers[intHour - 1]
            intMinute == 45 -> "quarter to " + numbers[intHour]
            intMinute <= 20 -> numbers[intMinute - 1] + " minutes past " + numbers[intHour - 1]
            intMinute < 30 -> "twenty " + numbers[intMinute % 20 - 1] + " minutes past " + numbers[intHour - 1]
            intMinute <= 40 -> "twenty " + numbers[(60 - intMinute) % 20 - 1] + " minutes to " + numbers[intHour]
            else -> numbers[(60 - intMinute) - 1] + " minutes to " + numbers[intHour]
        }
    }
}
