
import java.util.*

interface Function{
    fun functionName():String
}

enum class Comands(val localName:String ):Function{
    enter("Включить"),
    fill("Наполнить"),
    status("Статус"),
    coffe("Кофе");

    override fun functionName():String =
        when (this) {
            enter -> "До свидания!"
            fill -> "Ингредиенты пополнены"
            status -> "Ингредиентов осталось:"
            coffe -> "Введите название напитка или \"назад\" для возврата в главное меню";
        }

}

class CoffeeMachine {
    private var scanner = Scanner(System.`in`)
    var water:Int = 0;
    var milk:Int = 0;
    var beans:Int = 0;
    // Начните написание программы с публичной функции start().
    // В этот раз мы не даём вам конкретных указаний, как должна быть написана программа.
    // У вас есть полная свобода действией, главное, что бы программа соответствовала ТЗ.
    // Удачи!
    fun fill(){
        //println("Вызван метод ${Comands.fill.localName}");
        if(this.water < 2000){
            this.water += (2000 - this.water);
        }
        if(this.milk < 1000){
            this.milk += (1000 - this.milk);
        }
        if(this.beans < 500){
            this.beans += (500 - this.beans);
        }
    }
    fun status(){
        //println("Вызван метод ${Comands.status.localName}");
        println("${this.water} мл воды\n${this.milk} мл молока\n${this.beans} гр кофе");
    }
    fun coffe(){
        //println("Вызван метод ${Comands.coffe.localName}");
//        println("Введите название напитка или \"back - назад\" для возврата в главное меню");
        var str:String;
        str = scanner.next();
        str = str.lowercase();
        if(str == "эспрессо"){
            if(this.water<60){
                println("Недостаточно воды!");
                return;
            }
            if(this.beans<10){
                println("Недостаточно кофе!");
                return;
            }
            this.water -= 60;
            this.beans -= 10;
            println("$str готов");
            return;
        }else if(str == "американо"){
            if(this.water<120){
                println("Недостаточно воды!");
                return;
            }
            if(this.beans<10){
                println("Недостаточно кофе!");
                return;
            }
            this.water -= 120;
            this.beans -= 10;
            println("$str готов");
            return;
        }else if(str == "капучино"){
            if(this.water<120){
                println("Недостаточно воды!");
                return;
            }
            if(this.beans<20){
                println("Недостаточно кофе!");
                return;
            }
            if(this.milk<60){
                println("Недостаточно молока!");
                return;
            }
            this.water -= 120;
            this.beans -= 20;
            this.milk -= 60;
            println("$str готов");
            return;
        }else if(str == "латте"){
            if(this.water<240){
                println("Недостаточно воды!");
                return;
            }
            if(this.beans<20){
                println("Недостаточно кофе!");
                return;
            }
            if(this.milk<120){
                println("Недостаточно молока!");
                return;
            }
            this.water -= 240;
            this.beans -= 20;
            this.milk -= 120;
            println("$str готов");
            return;
        }else if(str == "назад"){
            return;
        }
        else{
            println("Рецепт не найден!");
            return;
        }
    }
    fun start(){
        println("Кофемашина готова к работе");
        var control:String = "";
        while(true){
            println("Введите команду");
            //println("enter - включить, fill - наполнить, status - статус, coffe - кофе");
            control = scanner.next();
            control = control.lowercase();
            var cntrl:Comands
            if(control == "выключить") {
                cntrl = Comands.enter;
                println(cntrl.functionName());
                break;
            }
            else if(control == "наполнить") {
                cntrl = Comands.fill;
                println(cntrl.functionName());
                fill();
            }
            else if(control == "статус") {
                cntrl = Comands.status;
                println(cntrl.functionName());
                status();
            }
            else if(control == "кофе"){
                cntrl = Comands.coffe;
                println(cntrl.functionName());
                coffe();
            }
            else
                println("Введена не верная команда!");
        }
    }
}
fun main(){
    val coffeeMachine:CoffeeMachine = CoffeeMachine();
    coffeeMachine.start();
}