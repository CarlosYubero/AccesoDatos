package Actividad2;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class ManejoFicheros implements InterfazManejoFicheros{

	Path path = Paths.get("\texto.txt");
	
	@Override
	public boolean existeFichero(Path fileExists) {
		// TODO Auto-generated method stub
		return fileExists.toFile().exists();
	}

	@Override
	public boolean puedeEscribirFichero(Path isWrittable) {
		// TODO Auto-generated method stub
		return isWrittable.toFile().canWrite();
	}

	@Override
	public boolean puedeEjecutarFichero(Path isExecutable) {
		// TODO Auto-generated method stub
		return isExecutable.toFile().canExecute();
	}

	@Override
	public long tamanoFichero(Path size) {
		// TODO Auto-generated method stub
		long salida = 0;
		if(size.toFile().exists()){
			try {
				salida=Files.size(size);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//la salida es en bytes
		return salida;
	}

	@Override
	public String rutaAbsoluta(Path absRoute) {
		// TODO Auto-generated method stub
		if (absRoute.toFile().exists()) {
			return absRoute.toAbsolutePath().toString();
		} else {
			return "La ruta no existe";
		}
	}

	@Override
	public String[] listarDirectorio(Path listDirectory) {
		// TODO Auto-generated method stub
		if (listDirectory.toFile().list() != null) {
			return listDirectory.toFile().list();
		} else {
			String[] salida = new String[1];
			salida[0] = "No se encuentra nada para listar";
			return salida;
		}

	}

	@Override
	public String[] listarDirectorio(Path dirRoute, String extension) {
		// TODO Auto-generated method stub
		ArrayList<String> paso = new ArrayList<String>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirRoute)) {
			for (Path indice : stream) {
				if (indice.getFileName().toString().endsWith(extension)) {
					paso.add(indice.getFileName().toString());
				}
			}
		} catch (IOException e) {
			System.out.println("Error en el metodo listarDirectorio");
		}
		if (paso.size() != 0) {
			String[] salida = new String[paso.size()];
			for (int i = 0; i < salida.length; i++) {
				salida[i] = paso.get(i);
			}
			return salida;
		} else {
			return null;
		}

	}

	@Override
	public String[] listarModificados(Path modRoute, FileTime givenDate) {
		// TODO Auto-generated method stub
		ArrayList<String> paso = new ArrayList<String>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(modRoute)) {
			for (Path indice : stream) {
				if (indice.toFile().lastModified() > givenDate.toMillis()) {
					paso.add(indice.getFileName().toString());
				}
			}
		} catch (IOException e) {
			System.out.println("Error en el metodo listarModificados");
		}
		if (paso.size() != 0) {
			String[] salida = new String[paso.size()];
			for (int i = 0; i < salida.length; i++) {
				salida[i] = paso.get(i);
			}
			return salida;
		} else {
			return null;
		}
	}

	@Override
	public boolean creaDirectorio(Path createDir) {
		// TODO Auto-generated method stub
		boolean salida = false;
		String ruta = createDir.toAbsolutePath().toString();
		Scanner entrada = new Scanner(System.in);
		// Comprobamos que exista la ruta
		if (Files.exists(createDir)) {
			System.out.println("Introduzca el nombre del nuevo directorio: ");
			//Añadimos el slash (/) para separar la ruta del nombre de la carpeta
			//y añadimos el nombre de la carpeta introducido por teclado
			ruta += "/" + entrada.next(); 

			Path carpeta = Paths.get(ruta);
			
			// Comprobamos que no exista la carpeta
			if (Files.notExists(carpeta)) {
				try {
					Files.createDirectory(carpeta);
					System.out.println("El directorio ha sido creado correctamente");
					salida = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("Esta carpeta ya existe.");
				salida = false;
			}
		} else {
			System.err.println("La ruta no existe");
			entrada.close();
			salida = false;
		}
		entrada.close();
		return salida;

	}

	@Override
	public boolean renombraFichero(Path renameFile) {
		// TODO Auto-generated method stub
		boolean salida = false;
		String rutaFile = renameFile.toAbsolutePath().toString();
		Scanner entrada = new Scanner(System.in);
		
		Path origen = Paths.get(rutaFile);
		
		if (Files.exists(origen))
			
			try {
				System.out.println("Intruduzca la ruta y el nuevo nombre del archivo: ");
				rutaFile = entrada.nextLine();
				
				Path destino = Paths.get(rutaFile);
				Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Todo ha salido correctamente");
				salida = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.err.println("No se encuentra el archivo. Compruebe que la ruta introducida es correcta.");
			salida = false;
		}
		entrada.close();
		return salida;

	}

	@Override
	public boolean borrar(Path deleteFile) {
		// TODO Auto-generated method stub
		boolean salida = false;
		if (Files.exists(deleteFile)) {
			try {
				Files.delete(deleteFile);
				salida = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			salida = false;
		}
		return salida;
	}

	@Override
	public boolean touch(Path createFile) {
		// TODO Auto-generated method stub
		boolean salida = false;
		if (Files.notExists(createFile)) {
			try {
				Files.createFile(createFile);
				salida = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			salida = false;
		}
		return salida;

	}

}
