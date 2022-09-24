import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
//    var signatureDrink = "맥주"
//    signatureDrink = null
    // 첫 번째 방법: 안전 호출 연산자
//    var beverage = readLine()?.capitalize()

    // 안전 호출 연산자와 함께 let 함수 사용하기
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "맥주"
//        }
//    }

    // 두 번째 방법: non-null 단언 연산자
//    var beverage = readLine()!!.capitalize()

    // 세 번째 방법: 값이 null 인지 if로 검사하기
//    var beverage = readLine()

//    if (beverage != null) {
//        beverage = beverage.capitalize()
//    } else {
//        println("beverage가 null입니다!")
//    }

    // null 복합 연산자
//    val beverageServed: String = beverage ?: "맥주"

//    beverage = null

//    println(beverage)
//    println(beverageServed)
    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder("elixir,Shirly's Temple,5.91")
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("지갑 전체 금액: 금화 $totalPurse")
    println("금화 $price 로 술을 구입함")
    val remainingBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSeilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSeilver
    displayBalance()
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]

    // 해체 선언(destructuring declaration)
    val (type, name, price) = menuData.split(',')
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    performPurchase(price.toDouble())

//    val phrase = "와, $name 진짜 좋구나"
//    println("마드리갈이 감탄한다: ${toDragonSpeak(phrase)}")
    val phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나")}"
    } else {
        "마드리갈이 말한다: 감사합니다 $name"
    }
    println(phrase)
}