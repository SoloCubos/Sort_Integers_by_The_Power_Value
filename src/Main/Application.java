/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.lang.Math;
 
/**
 *
 * @author Solan
 */
public class Application {
    public static void main(String [] args){//Acá se crean los datos de prueba
        System.out.println("--------------------------------");
        
        int[] lo = new int[100];
        int[] hi = new int[100];
        int[] k = new int[100];
        int aux1 = 0;
        int aux2 = 0;
        
        for(int i = 0; i < 100; i++){

            aux1 =(int)(Math.random() * 150) + 2;           
            aux2 = (int)(Math.random() * 150) + 2;
                        
            if(aux2 > aux1){
                lo[i] = aux1;
                hi[i] = aux2;               
            }if(aux2 < aux1){
                hi[i] = aux1;
                lo[i] = aux2;       
            }if(aux2 == aux1){
                hi[i] = aux1;
                lo[i] = aux2;
            }
            k[i] = (int)(Math.random() * (hi[i] - lo[i])) + 1;  
            
        }
        injectTestCases(k, lo, hi);
        System.out.println("   SUCCESS!!");
    }
    
    public static void injectTestCases(int[] arrK, int[] arrLo, int[] arrHi){
        Solution s = new Solution();
        for (int i = 0; i < 100; i++) {
            System.out.println("|        Test Case #: " + (i + 1) + "      |");
            System.out.println("--------------------------------");
            System.out.println("Lower Limit is: " + arrLo[i]);
            System.out.println("Higher Limit is: " + arrHi[i]);
            System.out.println("Required K position is: " + arrK[i]);        
            System.out.println("Kth position is: " + s.getKth(arrLo[i], arrHi[i], arrK[i]));
            System.out.println("--------------------------------");
        }       
    }
}
