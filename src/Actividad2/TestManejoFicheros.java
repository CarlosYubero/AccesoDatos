package Actividad2;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;


public class TestManejoFicheros {

	public static void main(String[] args) {
		ManejoFicheros myFile = new ManejoFicheros() {};
		Path ruta = Paths.get(".");
		myFile.listarDirectorio(ruta , ".docx");
		Long time= 1467005900000L;
		FileTime tiempo = FileTime.fromMillis(time);
		myFile.listarModificados(ruta, tiempo);

	}

}
