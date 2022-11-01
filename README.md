### Sort Integers by The Power Value (Ordenamiento de numeros enteros por valor de su poder)

## Table of contents
* [Introduccion](#introducción)
* [Desarrollo](#desarrollo)
* [Uso](#uso)
* [Métodos](#metodos)
* [Ejecución](#ejecución)
## Introduccion

Vídeo Demostrativo: 

La potencia de un entero x se define como el número de pasos necesarios para transformar x en 1 usando los siguientes pasos:

* si x es par entonces x = x / 2
* si x es impar entonces x = 3 * x + 1

Por ejemplo, la potencia de x = 3 es 7 porque 3 necesita 7 pasos para convertirse en 1

    (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1) .

Dados tres enteros lo, hi y k. Se deben ordenar todos los enteros del intervalo [lo, hi] por el valor de su poder en orden ascendente, si dos o más enteros tienen el mismo valor de potencia ordenarlos en orden ascendente.

Devuelve el k-gesimo entero en el intervalo [lo, hi] ordenado por el valor de su poder.

    Ejemplo:

Entrada: lo = 12, hola = 15, k = 2

Salida: 13

Explicación: El poder de 12 es 9 

El poder de 13 es 9
El poder de 14 es 17
El poder de 15 es 17

El intervalo ya está ordenado por el valor de su poder [12,13,14,15]. Para k = 2 la respuesta es el segundo elemento que es 13.

Observe que 12 y 13 tienen el mismo valor de poder y los ordenamos en orden ascendente. Lo mismo para el valor de poder del 14 y 15
	
## Desarrollo

La aplicación fue creada usando el lenguaje de programación Java, en NetBeans IDE 8.2 con el JDK V8, usando el algoritmo de ordenamiento BubbleSort o Burbuja

## Uso

La aplicación por defecto generará 100 casos de prueba con un rango maximo superior de 150, sin embargo el usuario podrá personalizar dichos valores al momento de ejecutar el programa, pudiendo elegir tanto la cantidad de casos de prueba, como el rango maximo superior.

Teniendo en cuenta la introducción, la aplicación imprimirá por consola para cada Caso de prueba, su numero, los limites Inferior y superior (intervalo [lo, hi]), la K-gesima posición requerida, el tamaño del intervalo [lo, hi] y finalmente la posición K-gesima 

## Metodos

La aplicación cuenta con Dos metodos muy importantes, getKth y bubbleSortModified, además de métodos secundarios, como injectTestCases y el Main

# Método "int getKth(int lo, int hi, int k)"

Este método recibe 3 parametros, "lo" hace referencia al limite inferiór del intervalo, "hi" hace referencia al limite superior del intervalo, y "k" recibe la posición para hallar el K-gesimo elemento de la lista ordenada

Primeramente se establece el intervalo [lo, hi] 

Luego se crean 3 arreglos con el tamaño de este intervalo, "arr" se encargará de almacenar los numeros contenidos en dicho intervalo, junto con una variable auxiliar, para mas adelante hallar el valor del poder de cada uno, "arrStep" se encarga de almacenar el valor del poder de cada entero en el orden encontrado en el arreglo "arr" utlizando un contador para agregar la cantidad de pasos requeridos para que x numero se convierta en 1 luego de aplicar el algoritmo correspondiente y "arrHi2Lo" el cual almacena los numeros enteros contenidos en el ya mencionado intervalo.

Finalmente se crea un array mas "arrRanOrdenado", mediante el cual se llama al proximo método, que retorna los enteros del intervalo [lo, hi] ordenados por el valor de su poder ascendentemente, para así hallar el entero en la posición K.

# Método "int[] bubbleSortModified(int[] data, int[] arrLo2Hi)"

Este método se encarga de ordenar ascendentemente una lista de enteros, el cual se ha modificado para recibir dos arreglos, el primero que recibe una lista que se ordena ascendentemente y el segundo, el cual se ordena con el dezplazamiento de datos provocado por el primero. 

Así pues, el método se invoca pasandole como parametro principal el arreglo "arrStep" el cual contiene los valores del poder de cada entero del intervalo [lo, hi] y el otro, "arrLo2Hi", que contiene los enteros de dicho intervalo

Finalmente, despues de ordenar los valores del poder de cada entero, debido al dezplazamiento de datos realizado en ambos arreglos, el arreglo "arrLo2Hi" se ordena según el valor del poder de cada entero, retornando esta lista al método


# Método "main"

Este método cumple varias funciones, se usa para iniciar la ejecución del programa, provee una interfaz de usuario básica por consola, la cual se usar para definir los valores de los parametros que el programa necesita para funcionar, tales como la cantidad de casos de prueba a generar, y el rango maximo superior para los casos

Acá se generan todos los casos de prueba, por defecto se generarán 100 casos de prueba con un limite maximo superior de 150, y un limite inferior de 2, el cual no debería de ser modificable para el usuario.

Los casos de prueba garantizan que el limite superior siempre sea mayor que el limite inferior y que ninguno tome valor de  cero, así como el valor de Kth no sea superior al intervalo anteriormente mencionado [lo, hi].

Este método llamará a otro método, pasandole como parametro los casos de prueba, para que este finalmente los inyecte al método "getKth" y así se logre la ejecución exitosa el programa

# Método "void injectTestCases(int[] arrK, int[] arrLo, int[] arrHi)"

Este método se encarga de inyectar los casos de prueba generados al método "getKth", se hizo así con el fín de ser mas flexible

El método recibe 3 arreglos con todos los casos de prueba generados, y por medio de un ciclo, prueba el programa, tantas veces como casos de prueba se hayan generado, ofreciendo una vista or consola de: Numero del caso de Prueba, Limites superior e inferior, la posición K-gesima requerida, el tamaño de Intervalo [lo, hi] y finalmente el entero en la posición K-gesima

## Ejecución

Para ejecutar este proyecto se requiere de tener Java Instalado en la maquina, se puede ejecutar tanto por ventana de comandos con los comandos correspondientes, como con un IDE de desarrollo

