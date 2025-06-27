// App.kt
package org.example

fun main() {
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)
    
    println("Suma: ${f1 + f2}")  // Debería mostrar 5/6
    println("Resta: ${f1 - f2}")  // Debería mostrar 1/6
    
    // Probando con simplificación
    val f3 = Fraccion(2, 4)
    val f4 = Fraccion(3, 6)
    println("Suma simplificada: ${f3 + f4}")  // Debería mostrar 1/1
}