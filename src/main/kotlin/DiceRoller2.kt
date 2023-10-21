import kotlin.random.Random

class DiceRollerV2 {

    // сделайте интерфейс OnRollCallback функциональным
    fun interface OnRollCallback {
        fun call(firstDiceValue: Int, secondDiceValue: Int)
    }

    // сделайте интерфейс OnDoubleCallback функциональным
    fun interface OnDoubleCallback {
        fun call(diceValue: Int)
    }

    private var onRollCallback: OnRollCallback? = null
    private var onDoubleCallback: OnDoubleCallback? = null

    fun setCallbacks(onRollCallback: OnRollCallback, onDoubleCallback: OnDoubleCallback) {
        this.onRollCallback = onRollCallback
        this.onDoubleCallback = onDoubleCallback
    }

    fun roll():Int {
        if (onRollCallback == null || onDoubleCallback == null) {
            println("Вы должны вызвать функцию setCallbacks() прежде чем бросать кубики")
            return -1
        }

        val firstDiceValue = Random.nextInt(1, 7)
        val secondDiceValue = Random.nextInt(1, 7)

        if (firstDiceValue != secondDiceValue) {
            onRollCallback?.call(firstDiceValue, secondDiceValue)
            return 0
        } else {
            onDoubleCallback?.call(firstDiceValue)
            return 1
        }
    }
}

fun main() {
    // ваш код здесь
    val onRollCallback = DiceRollerV2.OnRollCallback{firstDiceValue: Int, secondDiceValue: Int ->
        println("На кубиках выпало $firstDiceValue и $secondDiceValue");
    }
    val onDoubleCallback = DiceRollerV2.OnDoubleCallback{diceValue: Int ->
        println("Ура!!! Дубль на $diceValue-ах! Бросаем ещё раз")
    }
    val x: DiceRollerV2 = DiceRollerV2();
    x.setCallbacks(onRollCallback,onDoubleCallback);
    var tmp:Int
    for(i in 1..10){
        tmp = x.roll();
        if(tmp == 1){
            tmp = x.roll();
        }else
            continue
    }
}