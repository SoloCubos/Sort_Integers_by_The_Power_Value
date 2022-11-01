/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Solan
 * @version 1.2
 * 
 */
public class Solution {  
    /**
     * El poder de un entero x se define como el número de pasos 
     * necesarios para transformar x en 1 usando los siguientes pasos:
     * 
     * si x es par entonces x = x / 2
     * 
     * si x es impar entonces x = 3 * x + 1
     * 
     * Por ejemplo, el poder de x = 3 es 7 porque 3 necesita 7 pasos para convertirse en 1 
     * (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1) .
     * 
     * Dados tres enteros lo, hi y k. La tarea es ordenar todos los enteros en el intervalo [lo, hi] por el valor de potencia en orden ascendente, 
     * si dos o más enteros tienen el mismo valor de potencia ordenarlos en orden ascendente.
     * 
     * Retorna el k-gesimo entero en el rango [lo, hi] ordenado por el valor de potencia.
     * 
     * @param lo Recibe el limite inferior del intervalo
     * @param hi Recibe el limite superior del intervalo
     * @param k Recibe la posición K-gesima
     * @return Devuelve el entero en la posición K-gesima del intevalo [lo, hi]
     */
    public int getKth(int lo, int hi, int k) {
        int Kth = 0;
        int range = (hi - lo) + 1;//Se calcula el intervalo [lo, hi]
        
        System.out.println("El Intervalo [lo, hi] es: " + range);
        
        int[] arr = new int[range];
        int[] arrStep = new int[range];
        int[] arrLo2Hi = new int[range];
        
        int aux = lo;
        int contador = 0;
        
        for (int i = 0; i < arr.length; i++) {//Acá se agregan todos los enteros requeridos para el intervalo [lo, hi], agregandolos a 2 listas 
            arr[i] = aux;
            arrLo2Hi[i] = aux;
            aux++;
        }
        for (int i = 0; i < arr.length; i++) {//Acá se calcula el valor del poder de cada entero contenido en el intervalo [lo, hi]
            while(arr[i] != 1){
                if(arr[i] % 2 == 0){
                    arr[i] = arr[i] / 2;
                    contador++;
                }else{
                    arr[i] = 3 * arr[i] + 1;
                    contador++;
                }
            }arrStep[i] = contador;
            contador = 0;
        }
        
        int[] arrRanOrdenado = bubbleSortModified(arrStep, arrLo2Hi);//Llamamos al método de ordenamiento burbuja
        
        Kth = arrRanOrdenado[k - 1];

        return Kth;     
    }

    /**
     * Método de ordenamiento burbuja modificado para recibir dos arreglos y retornar la lista de enteros del intervalo [lo, hi] ordenadas por su poder
     * 
     * @param data Este parametro recibe la lista desordenada de los poderes de cada entero
     * @param arrLo2Hi Este parametro recibe la lista de enteros del intervalo [lo, hi]
     * @return Retorna arreglo de enteros ordenados por el valor de su poder
     * 
     * Al realizar el mismo desplazamiento de datos a ambos arreglos, pero siempre leyendo el primero, 
     * se logra ordenar los dos arreglos para obtener así los enteros del intervalo [lo, hi] ordenados por su poder
     * 
     */
    public int[] bubbleSortModified(int[] data, int[] arrLo2Hi) {
       
        for(int i = 0; i < data.length; i++) {
            
            for (int j = 0; j < data.length - 1; j++) {
                
                if (data[j] > data[j + 1]) {
                    
                    int temp = data[j];
                    int aux = arrLo2Hi[j];
                    data[j] = data[j + 1];
                    arrLo2Hi[j] = arrLo2Hi[j + 1];
                    data[j + 1] = temp;
                    arrLo2Hi[j + 1] = aux;
                }
            }
        }return arrLo2Hi;
    }
}
