package Actividad5;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XStream xstream = new XStream(new DomDriver());
		
		Libro libro = new Libro();
		libro.setAutor("Carlos");
		libro.setCopias(7);
		libro.setEditorial("Planeta");
		libro.setIsbn(5555);
		libro.setPaginas(80);
		libro.setTitulo("El libro de Carlos");

		String xml = xstream.toXML(libro);
	}

}
