import kotlin.random.Random

class DiceRoller() {

    interface Callback {

        fun onRoll(firstDiceValue: Int, secondDiceValue: Int)

        fun onDouble(diceValue: Int)
    }

    fun roll(callback: Callback) {
        val firstDiceValue = Random.nextInt(1, 7)
        val secondDiceValue = Random.nextInt(1, 7)

        if (firstDiceValue != secondDiceValue) {
            callback.onRoll(firstDiceValue, secondDiceValue)
        } else {
            callback.onDouble(firstDiceValue)
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
    for(i in 1..10) {
        x.roll(interfaceBox);
    }
}