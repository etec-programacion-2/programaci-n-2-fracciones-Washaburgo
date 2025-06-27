
package org.example

class Fraccion(numerador: Int, denominador: Int) {
    var numerador: Int = numerador
        get() = field
        set(value) { field = value }
    
    var denominador: Int = denominador
        get() = field
        set(value) { 
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value 
        }
    
    private fun simplificar(): Fraccion {
        val mcd = calcularMCD(numerador, denominador)
        numerador /= mcd
        denominador /= mcd
        
        // Manejar signos
        if (denominador < 0) {
            numerador *= -1
            denominador *= -1
        }
        
        return this
    }
    
    private fun calcularMCD(a: Int, b: Int): Int {
        var num1 = Math.abs(a)
        var num2 = Math.abs(b)
        
        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        
        return num1
    }
    
    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = numerador * otra.denominador + otra.numerador * denominador
        val nuevoDenominador = denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }
    
    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = numerador * otra.denominador - otra.numerador * denominador
        val nuevoDenominador = denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }
}