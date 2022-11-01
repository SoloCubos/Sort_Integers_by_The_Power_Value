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
     *
     * @param lo receives the lower value for the interval [lo - hi]
     * @param hi receives the highest value for the interval [lo - hi]
     * @param k is needed for asking the k position of the array ordered power value of integer array in the range [lo, hi]
     * @return the position Kth in the array
     */
    public int getKth(int lo, int hi, int k) {
        int Kth = 0;
        int range = (hi - lo) + 1;
        System.out.println("Range is: " + range);
        int[] arr = new int[range];
        int[] arrPwr = new int[range];
        int[] arrLo2Hi = new int[range];
        int aux = lo;
        int contador = 0;
        
        for (int i = 0; i < arr.length; i++) {//here, program generates all the numbers in the range [lo, hi], and add it to two arrays
            arr[i] = aux;
            arrLo2Hi[i] = aux;
            aux++;
        }
        for (int i = 0; i < arr.length; i++) {//this algoritm calculates the power value of the number in the range [lo, hi]
            while(arr[i] != 1){
                if(arr[i] % 2 == 0){
                    arr[i] = arr[i] / 2;
                    contador++;
                }else{
                    arr[i] = 3 * arr[i] + 1;
                    contador++;
                }
            }arrPwr[i] = contador;
            contador = 0;
        }
        
        int[] arrRanOrdenado = bubbleSortModified(arrPwr, arrLo2Hi);//Here calls the bubblesort method, which is modified.
        
        Kth = arrRanOrdenado[k - 1];

        return Kth;     
    }

    /**
     * This is a normal bubbleSort method, but modified receive 2 arrays, sort the firstone by ascending orden, and the secondone acorrding to the another array.
     * @param arrPwr this param receives the array that contains the power value of the integers
     * @param arrLo2Hi this param receives the array than contains the integer
     * @return and retuns an array with the integers ordered by power value
     */
    public int[] bubbleSortModified(int[] arrPwr, int[] arrLo2Hi) {
       
        for(int i = 0; i < arrPwr.length; i++) {
            
            for (int j = 0; j < arrPwr.length - 1; j++) {
                
                if (arrPwr[j] > arrPwr[j + 1]) {
                    
                    int temp = arrPwr[j];
                    int aux = arrLo2Hi[j];
                    arrPwr[j] = arrPwr[j + 1];
                    arrLo2Hi[j] = arrLo2Hi[j + 1];
                    arrPwr[j + 1] = temp;
                    arrLo2Hi[j + 1] = aux;
                }
            }
        }return arrLo2Hi;
    }
}
