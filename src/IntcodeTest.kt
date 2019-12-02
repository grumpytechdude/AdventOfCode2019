import org.junit.jupiter.api.Assertions.*

internal class IntcodeTest {
    @org.junit.jupiter.api.Test
    fun calculateOneOpCode() {
        val code = "1,9,10,3,2,3,11,0,99,30,40,50"
        val expectedResult = "3500,9,10,70,2,3,11,0,99,30,40,50"
        assertEquals(expectedResult, Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun test1() {
        val code = "1,0,0,0,99"
        val expectedResult = "2,0,0,0,99"
        assertEquals(expectedResult, Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun test2() {
        val code = "2,3,0,3,99"
        val expectedResult = "2,3,0,6,99"
        assertEquals(expectedResult, Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun test3() {
        val code = "2,4,4,5,99,0"
        val expectedResult = "2,4,4,5,99,9801"
        assertEquals(expectedResult, Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun test4() {
        val code = "1,1,1,4,99,5,6,0,99"
        val expectedResult = "30,1,1,4,2,5,6,0,99"
        assertEquals(expectedResult, Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun day2Challenge1() {
        val code =
            "1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0"
        println(Intcode().parse(code))
    }

    @org.junit.jupiter.api.Test
    fun day2Challenge2() {
        for (input1 in 1..99) {
            for (input2 in 1..99) {
                val code =
                    "1,${input1},${input2},3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0"
                val result = Intcode().parse(code)
                val first = result.split(',').first()
                if (first == "19690720") {
                    println(100 * input1 + input2)
                }
            }
        }
    }
}
