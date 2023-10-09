interface SomeInterface{
    fun someMethod()
    fun anotherMathod()
}
fun main(){
    val someInterface = object : SomeInterface{
        override fun someMethod() {
            println("Что то выводит метод someMethod()")
        }

        override fun anotherMathod() {
            println("Как то решает метод anotherMethod()")
        }

    }
    someInterface.someMethod();
    someInterface.anotherMathod();
}