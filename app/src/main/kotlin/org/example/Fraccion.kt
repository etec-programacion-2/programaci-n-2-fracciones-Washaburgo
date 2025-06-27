
package org.example

class Fraccion(numerador: Int, denominador: Int) {
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
    
    operator fun times(otra: Fraccion): Fraccion {
        val nuevoNumerador = numerador * otra.numerador
        val nuevoDenominador = denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }
    
    operator fun div(otra: Fraccion): Fraccion {
        if (otra.numerador == 0) {
            throw ArithmeticException("No se puede dividir por una fracción con numerador cero")
        }
        
        val nuevoNumerador = numerador * otra.denominador
        val nuevoDenominador = denominador * otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }
}