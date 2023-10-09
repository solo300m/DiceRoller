fun main(){
    var x:Int = 1;
    var y:Int = 1;
    for(i in 1..12){
        var tmp:Int;
        tmp = x;
        x = y;
        y = y + tmp;
        print("$y ");
    }
    println();
    println(y);
}