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
    var beverage = readLine()

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("beverage가 null입니다!")
    }

    // null 복합 연산자
    val beverageServed: String = beverage ?: "맥주"

//    beverage = null

//    println(beverage)
    println(beverageServed)
}