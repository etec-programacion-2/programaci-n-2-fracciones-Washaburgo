// App.kt
package org.example

fun main() {
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(2, 3)
    
    println("Multiplicación: ${f1 * f2}")  // Debería mostrar 1/3
    println("División: ${f1 / f2}")       // Debería mostrar 3/4
    
    try {
        val f3 = Fraccion(0, 1)
        println("División por cero: ${f1 / f3}")  // Debería lanzar excepción
    } catch (e: ArithmeticException) {
        println("Error: ${e.message}")
    }
}