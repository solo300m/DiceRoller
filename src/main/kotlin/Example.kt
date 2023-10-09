data class Example(
    val name:String,
    val surname:String,
    val age:Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Example) return false

        other as Example

        if (name != other.name) return false
        if (surname != other.surname) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "Example(name='$name', surname='$surname', age=$age)"
    }

}
