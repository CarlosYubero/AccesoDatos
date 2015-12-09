package JavaNio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ImplementacionNIO {

	final static String FICHERO = "entrada.txt";
	final static String RUTA = "./entrada.txt";

	/*
	 * Para ejecutar Botón derecho --> Run as --> Run Configurations --> En
	 * argumentos escribir entrada.txt. Es necesario para probar toAbsolutePath
	 */
	public static void main(String[] args) {

		// Primer método toUri
		Path p1 = Paths.get(FICHERO);

		System.out.println("URI " + p1.toUri());	

		// -------------------------------------------------------------------------------

		// Segundo método toAbsolutePath

		if (args.length < 1) {
			System.out
					.println("debes pasar un nombre de archivo como argumento");
			System.exit(-1);
		}

		Path inputPath = Paths.get(args[0]);
		Path fullPath = inputPath.toAbsolutePath();

		System.out.println("Path absoluto " + fullPath);

		// -------------------------------------------------------------------------------

		// Tercer método toRealPath

		Path p2 = Paths.get(RUTA);
		try {

			Path fp = p2.toRealPath();

			System.out.println("Path real " + fp);
		} catch (NoSuchFileException x) {

			System.err.println(p2+": no existe" + " el fichero o directorio %n"	);

		} catch (IOException x) {

			System.err.println(x);

		}

	}
}
