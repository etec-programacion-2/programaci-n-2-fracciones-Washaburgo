// App.kt
package org.example

fun main() {
    try {
        val f1 = Fraccion(1, 2)
        println("Fracción 1: ${f1.toString()}")
        f1.mostrar()
        
        val f2 = Fraccion(3, 4)
        println("Fracción 2: $f2")
        
        // Esto debería lanzar una excepción
        // val f3 = Fraccion(1, 0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}