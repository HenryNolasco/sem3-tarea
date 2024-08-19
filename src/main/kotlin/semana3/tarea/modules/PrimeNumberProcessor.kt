package semana3.tarea.modules

class PrimeNumberProcessor(rango: IntRange) {
    private var primos = ArrayList<EvaluationResult>()
    private var pares = ArrayList<EvaluationResult>()
    private var inpares = ArrayList<EvaluationResult>()

    init {
        processRange(rango)
    }

    private fun processRange(rango: IntRange) {
        for (numero in rango){
            if (numero == 1) {
                continue
            } else {
                findDivisors(numero)
            }
        }

        println("primos")
        for (objeto in primos) {
           primeNumber(objeto.numero, objeto.divisores)
        }
        println()
        println("pares")
        for (objeto in pares){
            EvenNumber(objeto.numero,objeto.divisores)
        }
        println()
        println("inpares")
        for (objeto in inpares){
            OddNumber(objeto.numero,objeto.divisores)
        }
    }

    private fun findDivisors(numero: Int) {
        val divisores = findFactors(numero)

        if (divisores.size <= 2) {
            primos.add(EvaluationResult(numero, divisores, NumberType.PRIME))
        } else if (numero % 2 == 0){
            pares.add(EvaluationResult(numero, divisores, NumberType.EVEN))
        } else{
            inpares.add(EvaluationResult(numero,divisores, NumberType.ODD))
        }
    }

    private fun findFactors(numero: Int):ArrayList<Int> {
        val factores = ArrayList<Int>()

        for (i in 1..numero) {
            if (numero % i == 0){
                factores.add(i)
            }
        }
        return factores
    }
}

 data class EvaluationResult(val numero: Int, val divisores: ArrayList<Int>, val tipo: NumberType)