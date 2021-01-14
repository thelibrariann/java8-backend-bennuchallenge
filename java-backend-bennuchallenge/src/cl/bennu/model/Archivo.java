package cl.bennu.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Archivo {
	
	/**
	 * Metodo que genera un numero random y lo almacena en un archivo de nombre "RandomFile.txt"
	 */
	public static void storeRandomFile() {
		
		Random ran = new Random();
	    int number = 0;

	    try {
	        PrintWriter file = new PrintWriter(
	            new BufferedWriter(
	                    new FileWriter("RandomFile.txt")));

	        for (int i = 1; i <= 10; i++) {
	            number = ran.nextInt(50) + 1;
	            file.println(number);
	        }
	        file.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    System.out.println("File RandomFile.txt has been created!");
    }
	
	/**
	 * Metodo que le el archivo "RandomFile.txt" y lo imprime en pantalla
	 * Manejo de la excepcion
	 */
	public static void readFile() {
		
		try {
		      File file = new File("RandomFile.txt");
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Ha ocurrido un error");
		      e.printStackTrace();
		    }
	}	
	
	/**
	 * Metodo que orderna el contenido del archivo descendentemente y lo imprime en pantalla
	 * Lee el arhcivo.txt, pasa el contenido a un ArrayList int para mantenerlo en memoria y re ordenar el archivo para guardarlo ordenado de forma descendente
	 */
	public static void sortFile() {
		Scanner file = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try {
			file = new Scanner(new File("RandomFile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
			e.printStackTrace();
		}
		
		while(file.hasNext()){
			if (file.hasNextInt()) list.add(file.nextInt());
			else file.next();
		}
		
		Collections.sort(list);
		
		for (Integer i: list) System.out.println(i);
	}
	/**
	 * Metodo que transforma el contenido del archivo en un ArrayList para buscar la existencia del valor ingresado por consola
	 */
	public static void findNumber() {
		
		Scanner file = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try {
			file = new Scanner(new File("RandomFile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
			e.printStackTrace();
		}
		
		System.out.println("Ingrese numero a buscar");
		int opcion;
		Scanner toFind = new Scanner(System.in);
		boolean found = false;
		
		while(file.hasNext()){
			if (file.hasNextInt()) list.add(file.nextInt());
			else file.next();
		}
		
		opcion = toFind.nextInt(); 
		
		
		for (Integer i: list) {
			if (i == opcion ) {
				found = true;
				break;
			}
		}
		
		if(found)
            System.out.println(" Número existe en el archivo");
        else
            System.out.println(" Número no existe en el archivo");
	}
}
