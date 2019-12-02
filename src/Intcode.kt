class Intcode {
    fun parse(code: String): String {
        val ops: MutableList<Int> = code.split(',').map { it.toInt() }.toMutableList()
        var index = 0;
        while (true) {
            val op = ops[index];
            if (op == 1)
                index = addition(ops, index)
            else if (op == 2)
                index = multiplication(ops, index)
            else if (op == 99)
                break
        }
        return ops.joinToString(",")
    }
}

fun addition(ops: MutableList<Int>, index: Int): Int {
    val num1 = ops[ops[index + 1]]
    val num2 = ops[ops[index + 2]]
    ops[ops[index+3]] = num1 + num2
    return index + 4
}

fun multiplication(ops: MutableList<Int>, index: Int): Int {
    val num1 = ops[ops[index + 1]]
    val num2 = ops[ops[index + 2]]
    ops[ops[index+3]] = num1 * num2
    return index + 4
}
