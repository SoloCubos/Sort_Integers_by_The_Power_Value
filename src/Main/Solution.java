/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Solan
 */
public class Solution {
    public static void main(String [] args){
        Solution s = new Solution();
        s.getKth(7, 11, 2);
    }
    
    public int getKth(int lo, int hi, int k) {
        int Kth = 0;
        int[] arr = new int[(hi - lo) + 1];
        int[] arrPwr = new int[(hi - lo) + 1];
        int aux = lo;
        int contador = 0;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux;
            aux++;
        }

        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != 1){
                if(arr[i] % 2 == 0){
                    arr[i] = arr[i] / 2;
                    contador++;
                }else{
                    arr[i] = 3 * arr[i] + 1;
                    contador++;
                }
            }
            arrPwr[i] = contador;
            contador = 0;
        }
        
        for (int i = 0; i < arrPwr.length; i++) {
            System.out.println(arrPwr[i]);
        }
        return Kth;     
    }
}
