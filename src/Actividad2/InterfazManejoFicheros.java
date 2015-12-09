package Actividad2;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public interface InterfazManejoFicheros {
	public boolean existeFichero(Path fileExists);

	public boolean puedeEscribirFichero(Path isWrittable);

	public boolean puedeEjecutarFichero(Path isExecutable);

	long tamanoFichero(Path size);

	public String rutaAbsoluta(Path absRoute);

	public String[] listarDirectorio(Path listDirectory);

	String[] listarDirectorio(Path dirRoute, String extension);

	public String[] listarModificados(Path modRoute, FileTime givenDate);

	public boolean creaDirectorio(Path createDir);

	public boolean renombraFichero(Path renameFile);

	public boolean borrar(Path deleteFile);

	public boolean touch(Path createFile);

}
