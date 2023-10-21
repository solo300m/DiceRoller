import kotlin.math.abs
import kotlin.random.Random

class Lotto {

    var gamerList: List<Person> = mutableListOf();

    // определите поле, в котром будут храниться добавленные игроки `Person`
    // поле thrownNumbers должно хранить в себе набор выброшенных чисел.
    var thrownNumbers: MutableSet<Int> = mutableSetOf();  // определите подходящую структуру данных

    fun addPerson(person: Person) {
        gamerList = gamerList.plus(person);
        // добавить игрока в список игроков
    }

    fun start() {
        var winList: List<Person> = mutableListOf();
        var number: Int = 0;
        if (gamerList.size < 2) {
            println("Перед началом игры необходимо добавить хотя бы двух игроков");
            return;
        } else {
            var win: Boolean = false;
            while (!win) {
                var check: Boolean = false;
                while (!check) {
                    number = abs(Random.nextInt() % 99 + 1);
                    if (!thrownNumbers.contains(number)) {
                        thrownNumbers.add(number);
                        for (i in 0..gamerList.size - 1) {
                            for (j in 1..3) {
                                if (gamerList[i]?.card?.numbers[j]?.contains(number) == true) {
                                    gamerList[i].card.numbers[j]?.remove(number);
                                }
                            }
                        }
                        println("Выброшенное число: $number")
                        check = true;
                    }
                }
                for (i in 0..gamerList.size - 1) {
                    for (j in 1..3) {
                        if (gamerList[i]?.card?.numbers[j]?.size == 0) {
                            winList = winList.plus(gamerList[i]);
                        }
                    }
                }
                if (!winList.isEmpty()) {
                    win = true;
                    for (p in winList) {
                        println("Победитель: ${p.name}!!!");
                    }
                }
            }
        }
        // вывести сообщение "Перед началом игры необходимо добавить хотя бы двух игроков" и завершить работу, если количество добавленных игроков меньше 2

        // достать номер. Номер может быть в диапазоне от 1 до 99 включительно
        // после каждого выброшенного числа удалять это число из карточек всех игроков, если такое число имеется
        // выбрасывать новые числа до тех пор, пока не определится победитель
        // побеждает тот, у кого в одном из рядов нет больше чисел. Победителей может быть более одного
        // после того как появляется победитель, для каждого победителя вывести текст "Победитель: [имя_победителя]!!!"
    }
}


data class Card(val numbers: MutableMap<Int, MutableSet<Int>>)

class Person(val name: String) {

    val card: Card = createCard()

    private fun createCard(): Card {
        val numbers: Set<Int> = generateNumbers()

        val iterator: Iterator<Int> = numbers.iterator()
        var currentLine = 1

        val cardNumbers: MutableMap<Int, MutableSet<Int>> = mutableMapOf(
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to mutableSetOf()
        )

        while (iterator.hasNext()) {
            val number = iterator.next()
            cardNumbers[currentLine]?.add(number)

            if (currentLine < 3) {
                currentLine++
            } else {
                currentLine = 1
            }
        }

        return Card(cardNumbers)
    }

    private fun generateNumbers(): Set<Int> {
        val numbers: MutableSet<Int> = mutableSetOf()

        while (numbers.size < NUMBERS_COUNT) {
            numbers.add(Random.nextInt(MIN_NUMBER, MAX_NUMBER))
        }

        return numbers
    }

    private companion object {

        private const val NUMBERS_COUNT = 15
        private const val MAX_NUMBER = 100
        private const val MIN_NUMBER = 1
    }
}
fun main() {
    val person1: Person = Person("Sergey");
    val person2: Person = Person("Igor");
    val person3: Person = Person("Ivan");
    var lotto: Lotto = Lotto();
    lotto.addPerson(person1);
    lotto.addPerson(person2);
    lotto.addPerson(person3);
    lotto.start();
}