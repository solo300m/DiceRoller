import kotlin.math.abs

fun getMinInt(rep:Int, vararg ints:Int):Int{
    val arr:IntArray = ints;
    var rez:Int = arr[0];
    var minDelta:Int = abs(arr[0] - rep);
    for(i in arr){
        if(abs(i - rep) <= minDelta){
            rez = i;
            minDelta = abs(i - rep);
        }
    }
    return rez;
}