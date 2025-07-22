// Fraccion.kt
package org.example

class Fraccion(numerador: Int, denominador: Int) : Comparable<Fraccion> {
    // ... (código anterior se mantiene igual)
    
    operator fun compareTo(otra: Fraccion): Int {
        val valor1 = numerador.toDouble() / denominador
        val valor2 = otra.numerador.toDouble() / otra.denominador
        return valor1.compareTo(valor2)
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        
        val f1 = this.simplificar()
        val f2 = other.simplificar()
        
        return f1.numerador == f2.numerador && f1.denominador == f2.denominador
    }
    
    override fun hashCode(): Int {
        val simplified = simplificar()
        return 31 * simplified.numerador + simplified.denominador
    }
    
    fun esMayor(otra: Fraccion): Boolean = this > otra
    fun esMenor(otra: Fraccion): Boolean = this < otra
    
    fun aDecimal(): Double = numerador.toDouble() / denominador
    
    companion object {
        fun desdeDecimal(decimal: Double, precision: Int = 10000): Fraccion {
            val denominador = precision.toDouble()
            val numerador = decimal * denominador
            return Fraccion(numerador.toInt(), precision).simplificar()
        }
    }
}