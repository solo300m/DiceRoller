import java.util.*
import kotlin.random.Random

fun main(args: Array<String>) {
    val tmp: Int = Random.nextInt(from=1,until = 99);// ваш код тут
    val x:Char = tmp.toChar();
    when{
        x.isDigit()->println("$x - число");
        x.isLetter()->println("$x - буква");
        else -> println("$x - символ");
    }
}