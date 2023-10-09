import kotlin.random.Random

class DiceRoller() {

    interface Callback {

        fun onRoll(firstDiceValue: Int, secondDiceValue: Int)

        fun onDouble(diceValue: Int)
    }

    fun roll(callback: Callback):Int {
        val firstDiceValue = Random.nextInt(1, 7)
        val secondDiceValue = Random.nextInt(1, 7)

        if (firstDiceValue != secondDiceValue) {
            callback.onRoll(firstDiceValue, secondDiceValue)
            return 0
        } else {
            callback.onDouble(firstDiceValue)
            return 1
        }
    }
}

fun main() {
    // ваш код здесь
    val interfaceBox = object : DiceRoller.Callback {
        override fun onRoll(firstDiceValue: Int, secondDiceValue: Int) {
            println("На кубиках выпало $firstDiceValue и $secondDiceValue")
        }

        override fun onDouble(diceValue: Int) {
            println("Ура!!! Дубль на $diceValue-ах! Бросаем еще раз")
        }
    }
    val x:DiceRoller = DiceRoller()
    var tmp:Int
    for(i in 1..10) {
        tmp = x.roll(interfaceBox);
        if(tmp == 1)
            tmp = x.roll(interfaceBox);
        else
            continue;
    }
}