package cl.bennu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

import cl.bennu.model.Archivo;

public class MenuUtil {
	
	/**
	 * 
	 * @return metodo menu estatico que recibe un int desde un scanner que ejecuta la opcion ingresa desde consola por el usuario
	 */
	public static int menu() {

        int opcion;
        Scanner input = new Scanner(System.in);

        /**
         * Ciclo que valida que la opcion ingresada por el usuario sea entre 1 y 5
         * Si la opción ingresada no es valida imprime a una alerta en pantalla
         * Se repite hasta que la opción ingresada sea valida
         */
        do {
        	do {
        		System.out.println(" ");
            	System.out.println("Selecciones una opción");
                System.out.println("-------------------------\n");
                System.out.println("1 - Generar archivo con numeros aleatorios");
                System.out.println("2 - Leer archivo con numeros aleatorios");
                System.out.println("3 - Ordenar archivo y listar");
                System.out.println("4 - Buscar numero en archivo");
                System.out.println("5 - Salir");

                opcion = input.nextInt();
                
                if (opcion < 1 || opcion > 5) {
                	System.out.println(" ");
    				System.out.println("¡INGRESE UNA OPCION VALIDA!");
    				System.out.println(" ");
    			}
                
            } while (opcion < 1 || opcion > 5);
        	
        	switch (opcion) {
        	
			case 1:
				//Llama al metodo de la clase Numero que genera numeros al azar y los almacena en un archivo "RandonFile.txt"
				Archivo.storeRandomFile();				
				break;
				
			case 2:
				//Llama al metodo de la clase Numero que lee el archivo "RandomFile.txt" y lo imprime en pantalla
				Archivo.readFile();
				break;
				
			case 3:
				//Llama al metodo de la clase Numero que orderna los numeros aleatorios del archivo "RandomFile.txt"y los imprime en consola				
				Archivo.sortFile();				
				break;
				
			case 4:
				//Llama al metodo de la clase numero que busca un numero ingresado por consola dentro del archivo creado
				Archivo.findNumber();
				break;

			case 5:
				//Termina la app
				System.out.println("-----Gracias por utilizar esta app----");
				break;

			default:
				
				break;
			}
        	
        } while (opcion !=5);        
        
        return opcion;    
    }
}
