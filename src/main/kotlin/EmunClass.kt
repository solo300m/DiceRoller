enum class Week(val localizedName:String){
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота"),
        SUNDAY("Воскресенье");
    fun isWeekend():String =
        when (this){
            MONDAY -> "будний"
            TUESDAY -> "будний"
            WEDNESDAY -> "будний"
            THURSDAY -> "будний"
            FRIDAY -> "будний"
            SATURDAY -> "выходной"
            SUNDAY -> "выходной"
        }

    }
fun main(){
    for(i in Week.values()){
        println("${i.localizedName} - ${i.isWeekend()} день");
    }
}
