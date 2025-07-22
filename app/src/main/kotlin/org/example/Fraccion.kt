// CalculadoraFracciones.kt
package org.example

import java.util.Scanner

fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    print("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
    println(mensaje)
    print("Numerador: ")
    val numerador = scanner.nextInt()
    print("Denominador: ")
    val denominador = scanner.nextInt()
    return try {
        Fraccion(numerador, denominador)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}. Intente nuevamente.")
        leerFraccion(scanner, mensaje)
    }
}

fun realizarSuma(scanner: Scanner) {
    println("\n=== SUMA DE FRACCIONES ===")
    val f1 = leerFraccion(scanner, "Primera fracción:")
    val f2 = leerFraccion(scanner, "Segunda fracción:")
    println("Resultado: $f1 + $f2 = ${f1 + f2}")
}

fun realizarResta(scanner: Scanner) {
    println("\n=== RESTA DE FRACCIONES ===")
    val f1 = leerFraccion(scanner, "Primera fracción:")
    val f2 = leerFraccion(scanner, "Segunda fracción:")
    println("Resultado: $f1 - $f2 = ${f1 - f2}")
}

fun realizarMultiplicacion(scanner: Scanner) {
    println("\n=== MULTIPLICACIÓN DE FRACCIONES ===")
    val f1 = leerFraccion(scanner, "Primera fracción:")
    val f2 = leerFraccion(scanner, "Segunda fracción:")
    println("Resultado: $f1 * $f2 = ${f1 * f2}")
}

fun realizarDivision(scanner: Scanner) {
    println("\n=== DIVISIÓN DE FRACCIONES ===")
    val f1 = leerFraccion(scanner, "Primera fracción:")
    val f2 = leerFraccion(scanner, "Segunda fracción:")
    try {
        println("Resultado: $f1 / $f2 = ${f1 / f2}")
    } catch (e: ArithmeticException) {
        println("Error: ${e.message}")
    }
}

fun realizarComparacion(scanner: Scanner) {
    println("\n=== COMPARACIÓN DE FRACCIONES ===")
    val f1 = leerFraccion(scanner, "Primera fracción:")
    val f2 = leerFraccion(scanner, "Segunda fracción:")
    
    when {
        f1 == f2 -> println("$f1 es igual a $f2")
        f1 > f2 -> println("$f1 es mayor que $f2")
        else -> println("$f1 es menor que $f2")
    }
}

fun convertirADecimal(scanner: Scanner) {
    println("\n=== CONVERSIÓN A DECIMAL ===")
    val f = leerFraccion(scanner, "Ingrese la fracción a convertir:")
    println("$f en decimal es ${f.aDecimal()}")
}

fun crearDesdeDecimal(scanner: Scanner) {
    println("\n=== CREAR FRACCIÓN DESDE DECIMAL ===")
    print("Ingrese el número decimal: ")
    val decimal = scanner.nextDouble()
    val f = Fraccion.desdeDecimal(decimal)
    println("$decimal como fracción es aproximadamente $f")
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")
    
    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)
    
    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
    println("0.75 como fracción: ${Fraccion.desdeDecimal(0.75)}")
}

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int
    
    do {
        mostrarMenu()
        opcion = try {
            scanner.nextInt()
        } catch (e: Exception) {
            scanner.nextLine() // Limpiar el buffer
            -1
        }
        
        when (opcion) {
            1 -> realizarSuma(scanner)
            2 -> realizarResta(scanner)
            3 -> realizarMultiplicacion(scanner)
            4 -> realizarDivision(scanner)
            5 -> realizarComparacion(scanner)
            6 -> convertirADecimal(scanner)
            7 -> crearDesdeDecimal(scanner)
            8 -> mostrarEjemplos()
            0 -> println("¡Hasta luego!")
            else -> println("Opción inválida. Intente de nuevo.")
        }
        
        if (opcion != 0) {
            println("\nPresione Enter para continuar...")
            scanner.nextLine() // Limpiar buffer
            scanner.nextLine() // Esperar Enter
        }
    } while (opcion != 0)
    
    scanner.close()
}