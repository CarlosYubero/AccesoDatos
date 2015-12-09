package Actividad2;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;


public abstract class ManejoFicheros implements InterfazManejoFicheros{

	Path path = Paths.get("\texto.txt");
	
	@Override
	public boolean existeFichero(Path fileExists) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedeEscribirFichero(Path isWrittable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedeEjecutarFichero(Path isExecutable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long tamanoFichero(Path size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String rutaAbsoluta(Path absRoute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listarDirectorio(Path listDirectory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listarDirectorio(Path dirRoute, String extension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listarModificados(Path modRoute, FileTime givenDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean creaDirectorio(Path createDir) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean renombraFichero(Path renameFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Path deleteFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touch(Path createFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
