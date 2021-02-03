fun main() {
    // 1
    println("===== code 1 =====")
    fun sum(a: Int, b: Int): Int = a + b
    fun mul(a: Int, b: Int) = a * b
    fun funcFunc(): Int {
        return sum(2, 2)
    }

    val res1 = sum(3, 2)
    val res2 = mul(sum(3, 2), 3)
    println("res1: $res1, res2: $res2")
    println("funcFunc: ${funcFunc()}")

    // 2. 람다식을 이용한 함수
    println("\n===== code 2 =====")
    var result: Int
    val multi = { x: Int, y: Int -> x * y }
    result = multi(10, 20)
    println(result)

    // 3. 두줄 이상의 람다함수 -> 마지막줄의 결과값을 리턴
    println("\n===== code 3 =====")
    val multi2: (Int, Int) -> Int = { x: Int, y: Int ->
        println("x * y")
        x * y
    }
    println(multi2(20, 30))

    // 4. 모두 같은 표현
    println("\n===== code 4 =====")
    val multi3: (Int, Int) -> Int = { x: Int, y: Int -> x * y } // 생략되지 않은 전체 표현
    val multi4 = { x: Int, y: Int -> x * y } // 선언 자료형 생략
    val multi5: (Int, Int) -> Int = { x, y -> x * y } // 람다식 매개변수 자료형 생략
    // multi6 = {x, y -> x * y} // 선언과 매개변수 자료형 둘 다 생략 불가능 (자료형 추론 불가)
    multi3(2,9)
    multi4(2,9)
    multi5(2,9)

    // 5
    println("\n===== code 5 =====")
    val greet: () -> Unit = { println("Hello World!") }
    val greet2 = { println("Hello World Twice!") }
    greet()
    greet2()

    // 6
    println("\n===== code 6 =====")
    val square: (Int) -> Int = { x -> x * x }
    val square2 = { x: Int -> x * x }
    println(square(5))
    println(square2(6))

    // 7
    println("\n===== code 7 =====")
    val nestedLambda: () -> () -> Unit = { { println("nested") } }
    val nestedLambda2 = { { println("nested twice") } }
    nestedLambda()()
    nestedLambda2()()

    // 8
    println("\n===== code 8 =====")
    fun highOrder(sumsum: (Int, Int) -> Int, a: Int, b: Int): Int {
        return sumsum(a, b)
    }
    val res11 = highOrder({ x, y -> x + y }, 11, 22)
    val res22 = highOrder({ x, y -> x * y }, 11, 22)
    println(res11)
    println(res22)

    // 9
    println("\n===== code 9 =====")
    val out: () -> Unit = { println("Hello World!!!") }
    out()
    val new = out
    new()

    // 10 람다식의 흐름 확인 : 이름이 인자로 전달될 때 실행
    println("\n===== code 10 =====")
    fun callByValue(b: Boolean): Boolean {
        println("callByValue function")
        return b
    }
    val lambda: () -> Boolean = {
        println("lambda function")
        true
    }
    val result10 = callByValue(lambda())
    println(result10)

    // 11 람다식의 흐름 확인 : 실제로 호출될 때 실행
    println("\n===== code 11 =====")
    fun callByName(b: () -> Boolean): Boolean {
        println("callByName function")
        return b()
    }
    val otherLambda: () -> Boolean = {
        println("otherLambda function")
        false
    }
    val result11 = callByName(otherLambda)
    println(result11)



}
