object PiggyBank {

    val list:ArrayList<Money> = ArrayList<Money>();// список монеток/купюр

    var isCrash:Boolean = false;// свойство, определяющее, разбита ли копилка

    fun putMoney(money: Money) {
        if(!isCrash){
            this.list.add(money);
            println("Добавлено в копилку $money");
        }else{
            println("Вы разбили копилку, вы больше ничего положить туда не можете");// проверьте, не разбита ли копилка
        }
        // добавьте монетку в копилку
    }
    fun putMoney(amount:Double){
        if(!isCrash &&(((amount == Money.coins_10 || amount == Money.coins_50) || (amount == Money.coins_100 || amount == Money.bill_50)) || ((amount == Money.bill_100 || amount == Money.bill_500) || amount == Money.bill_1000))){
            val tmp = Money(amount);
            this.list.add(tmp);
            println("Добавлено в копилку $tmp");
        }else{
            println("Вы разбили копилку, вы больше ничего положить туда не можете");// проверьте, не разбита ли копилка
        }
    }

    fun shake(): Money? {
        if(!isCrash){
            for(m:Money in list){
                if(m.isCoin){
                    this.list.remove(m);
                    return m
                }
            }
            return null;
        } // проверьте, не разбита ли копилка
        else{
            println("Вы разбили копилку, больше оттуда ничего не вытрясти");// проверьте, не разбита ли копилка
            return null;
        }
        return null;// вытрясти монетку из копилки (если в копилке нет монетки, вернуть null). Помните, купюры вытрясти нельзя.
    }

    fun smash(): ArrayList<Money> {
        this.isCrash = true;
        return list;// установить флаг, что копилка разбита true, и вернуть все монетки, которые были в копилке
    }
}

data class Money(
    val isCoinParam:Boolean,
    val amountParam:Double
)// создайте класс Money, который будет отражать сущность монетки/купюры с двумя полями: amount и isCoin
{
    companion object{
        val coins_10:Double = 0.1;
        val coins_50:Double = 0.5;
        val coins_100:Double = 1.0;
        val bill_50:Double = 50.0;
        val bill_100:Double = 100.0;
        val bill_500:Double = 500.0;
        val bill_1000:Double = 1000.0;
    }
    var isCoin:Boolean = isCoinParam;
    var amount:Double = if(this.isCoin && ((amountParam == coins_10 || amountParam == coins_50) || amountParam == coins_100)) amountParam
        else if(!this.isCoin && ((amountParam == bill_50 || amountParam == bill_100) || (amountParam == bill_500 || amountParam == bill_1000))) amountParam
        else 1.0;
    constructor(amountParam: Double) : this(isCoinParam = false, amountParam) {
        if((amountParam == coins_10 || amountParam == coins_50) || amountParam == coins_100) {
            this.isCoin = true;
            this.amount = amountParam;
        }else if((amountParam == bill_50 || amountParam == bill_100) || (amountParam == bill_500 || amountParam == bill_1000)){
            this.isCoin = false;
            this.amount = amountParam;
        }else
            null;
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Money) return false

        other as Money

        if (isCoin != other.isCoin) return false
        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isCoin.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }

    override fun toString(): String {
        if(this.isCoin && this.amount != 1.0){
            val tmp:Int = (amount * 100).toInt();
            return "$tmp коп.";
        }else if (this.isCoin && this.amount == 1.0){
            val tmp:Int = (amount).toInt();
            return "$tmp руб."
        }else {
            val tmp:Int = (amount).toInt();
            return "$tmp руб."
        }
    }


} // переопределите метод toString() так, чтобы он возвращал строку типа "10 коп." или "1 руб.", если это монетка, и "100 руб.", если это купюра
// вы должны ограничить создание класса таким образом, чтобы можно было создать только ограниченный набор номиналов (см. задание)
fun main(){
    val pigi = PiggyBank;
    pigi.putMoney(Money.coins_10);
    pigi.putMoney(Money(true,0.5));
    pigi.putMoney(Money(true,0.5));
    pigi.putMoney(Money(false,100.0));
    pigi.putMoney(Money(true,0.5));
    var mon: Money? = pigi.shake();
    println("Выпало $mon");
    var mon2: Money? = pigi.shake();
    println("Выпало $mon2");
    val list:ArrayList<Money> = pigi.smash();
    println("Копилка разбита. Вы достали оттуда: $list");
}