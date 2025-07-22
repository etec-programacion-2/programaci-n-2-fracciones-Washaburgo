// App.kt
package org.example

fun main() {
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(2, 4)
    
    println("¿Son iguales? ${f1 == f2}")  // true
    println("Comparación: ${f1.compareTo(Fraccion(1, 3))}")  // positivo (f1 es mayor)
    println("¿f1 > Fraccion(1,3)? ${f1.esMayor(Fraccion(1, 3))}")  // true
    
    println("Decimal: ${f1.aDecimal()}")  // 0.5
    
    val f3 = Fraccion.desdeDecimal(0.75)
    println("Desde decimal: $f3")  // 3/4
    
    val f4 = Fraccion.desdeDecimal(0.3333)
    println("Desde decimal (1/3 aproximado): $f4")  // 3333/10000
}