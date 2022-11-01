/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.Scanner;
 
/**
 *
 * @author Solan
 */
public class Application {
    
    /**
     * Este método genera los casos de prueba para el algoritmo
     * ademas, permite al usuario cambiar los valores predeterminados, 
     * con el fin de modificar la cantidad de casos de prueba, así como
     * el rango de trabajo para los generadores de los limites superiores e inferiores
     * 
     * En caso de que el usuario no desee personalizar dichos valores, el programa está 
     * configurado para genera 100 casos de pruebas totalmente aleatorios
     * con un rango de 150
     */
    public static void main(String [] args){//Acá se crean los datos de prueba
        Scanner sc = new Scanner(System.in);
        int testCases = 100;
        int range = 150;
        byte auto = 1;
        System.out.println("Bienvenido!!!");
        System.out.println("El programa por defecto contará con 100 casos de prueba y un rango de 150");
        System.out.println("Si quiere modificar la cantidad de casos de prueba, así como el rango, presione 1, de lo contrario presione 0");
        
        auto = sc.nextByte();
        
        if(auto == 1){
            System.out.println("Evite introducir valores tan altos, puede provocar ralentización en el equipo");
            System.out.println("Introduzca el numero de casos de prueba:(Se recomienda max 3000 para para un rango de 250)");
            testCases = sc.nextInt();
            System.out.println("Introduzca el rango: (Se recomiendo max 650 para 1500 Casos de prueba)");
            range = sc.nextInt();
        }
        
        System.out.println("--------------------------------");
        
        int[] lo = new int[testCases];
        int[] hi = new int[testCases];
        int[] k = new int[testCases];
        int aux1 = 0;
        int aux2 = 0;
        
        for(int i = 0; i < testCases; i++){

            aux1 =(int)(Math.random() * range) + 2;           
            aux2 = (int)(Math.random() * range) + 2;
                        
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
        System.out.println("Ejecución Exitosa");
    }
    
    /**
     * Este método inyecta todos los casos de prueba al algoritmo
     */
    public static void injectTestCases(int[] arrK, int[] arrLo, int[] arrHi){
        Solution s = new Solution();
        for (int i = 0; i < arrK.length; i++) {
            System.out.println("|     Caso de Prueba #: " + (i + 1) + "     |");
            System.out.println("--------------------------------");
            System.out.println("El Límite Inferior (lo): " + arrLo[i]);
            System.out.println("El Límite Superior (hi): " + arrHi[i]);
            System.out.println("La Posición K Requerida: " + arrK[i]);        
            System.out.println("La Posición K-gesima es: " + s.getKth(arrLo[i], arrHi[i], arrK[i]));
            System.out.println("--------------------------------");
        }       
    }
}
