package Actividad4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Quijote {

	private static boolean esCaracter(char c) {

		return Character.isLetter(c);

	}
	
	/*
	 * Contar el numero de letras (todas incluidas minusculas, mayusculas,
	 * acentuadas, etc., pero no los signos de puntuacion, cifras y otros
	 * caracteres)
	 */

	public static int ejercicio10(String nombrefichero) {

		File fichero = new File(nombrefichero);
		FileReader fr = null;
		int contar = 0;

		// Declaramos el fichero
		try {
			fr = new FileReader(fichero); // Creamos el flujo de entrada
			int i;

			while ((i = fr.read()) != -1) {
				// se va leyendo un caracter
				if (esCaracter((char) i))
					++contar;

				// System.out.print((char) i);

			}
			fr.close(); // cerramos el fichero
		} catch (FileNotFoundException fnfe) {
			System.out.println("El fichero " + nombrefichero
					+ " no se encuentra");
		} catch (IOException ioe) {
			System.out
					.println("El disco está lleno o protegido contra escritura ");
		}
		return contar;
	}

}

