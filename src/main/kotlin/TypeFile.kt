
class Student(
    name:String,
    age:Int
){
    constructor(name:String):this(name,20){}
    init{
        println("Мы создали объект класса Student");
    }
    init{
        println("Имя $name, возраст $age");
    }
}

class Animal(

)
{
    var age:Int = 0
        set(value){
            field = value;
        }
    var name:String = ""
        set(value){
            if(age > 6){
                field = value.uppercase()
            }else if(age in 1..6){
                field = value.lowercase()
            }
        }
    //constructor(name:String):this(name,0){}
    init{
        println("$name");
    }
    // ваш код здесь
}

class Animal2(
    var age:Int,
    var name:String
){
    var nameThis = if(age > 6) name.uppercase() else name.lowercase();
    var ageThis = age;
    init{
        println("Объект $nameThis возраста $ageThis!");
    }
}

class Car(
    nameParam:String
){
    var name = nameParam;
    constructor(brand:String, model:String):this(nameParam = "$brand $model") {};
    init{
        println("Автомобиль $name");
    }
}

class Post(
    val authorName: String,
    var text: String,
    var likeCount: Int
) {
    fun like(isSuperLike: Boolean): Int {
        if (isSuperLike) {
            likeCount += 2
        } else {
            likeCount++
        }
        return likeCount
    }
    fun edit(text:String, isAppend:Boolean){
        if(isAppend){
            this.text += text
        }else{
            this.text = text
        }
    }

    // Создайте метод edit принимающий на вход два параметра:
    // text типа String и isAppend типа Boolean.
    // Если isAppend true, метод должен добавить text в конец строки text класса Post.
    // Иначе метод заменяет содержимое строки text класса Post на значение переменной text.
}
fun main() {
//    val one:Student = Student("Иван",26);
//    val two:Student = Student("Петр");
//    val an: Animal = Animal() // Ожидаемый вывод: ТУЗИК
//    an.name = "Тузик"
//    an.age = 1
//    val tot:Animal = Animal() // Ожидаемый вывод: мура
//    tot.name = "Мура"
//    tot.age = 2
    //Animal("мУхТаР") // Ожидаемый вывод: мУхТаР
    var an:Animal2 = Animal2(7, "Тузик");
    var tot:Animal2 = Animal2(2,"Мура");
    var car:Car = Car("BMW","1-series");
    val post : Post = Post("Jon","text Good",50);
    post.edit(" not", true);
    println(post.text);
    val a: IntRange = 1..5
    for(i in a){
        print("$i ");
    }
    println(a)
}