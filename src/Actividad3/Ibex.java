package Actividad3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;


public class Ibex {

	public static final int CAMPO_FECHA = 2;
	public static final int CAMPO_CLOSE = 7;
	public static final int COL_CLOSE = 7;
	public static final int COL_FECHA =2;


	final static String RUTA = "/res/bolsa.csv";

	/**
	 * Recibe la ruta de un fichero de texto CSV con la información bursatil de
	 * la bolsa de Madrid http://www.bolsaes.com/historico-cotizaciones/%5EIBEX/
	 * y en la fecha dada si existe
	 * 
	 * float getCloseValue(Date fecha, String path)
	 *
	 * @param fecha
	 *            en forma (<DTYYYYMMDD>)
	 * @param path
	 *            por defecto sea res/bolsa.csv
	 * @return devuelve el valor de cierre de la bolsa (<close>) si la fecha no
	 *         existe devolverá 0.0, si ocurriera algún error devolverá -1
	 * 
	 */
	static float getCloseValue(Date fecha, String path) {
		String record;
		Path ruta = Paths.get(path);
		float close = 0.0f;
		String sFecha = dateToString(fecha);
		
		if(sFecha==null) return -1;
		
		try (BufferedReader br = Files.newBufferedReader(ruta)) {

			while ((record = br.readLine()) != null) {

				ArrayList<String> lFields = leerCampos(record, ",");

				try {
					if (sFecha.equals(lFields.get(CAMPO_FECHA))) {
						close = Float.parseFloat(lFields.get(CAMPO_CLOSE));
					}

				} catch (Exception e) {
					System.err.println("Error al leer la linea");
				}

			}

		} catch (IOException e) {
			System.err.println("Error E/S con "+sFecha);
			close = -1;
		}

		return close;

	}

	private static String dateToString(Date fecha) {
		String sFecha =  null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try{
			sFecha = sdf.format(fecha);
		}
		catch(Exception e){
		}
		return sFecha;
	}
	
	/**
	 * Método que me obtiene los campos de un registro csv
	 * 
	 * @param record
	 * @return
	 */
	private static ArrayList<String> leerCampos(String record, String separador) {
		ArrayList<String> lista = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(record, separador);
		while (st.hasMoreTokens()) {
			lista.add(st.nextToken());
		}

		return lista;
	}

	static float getCloseValue(Date fecha) {
		return getCloseValue(fecha, RUTA);
	}

	static float getCloseAvg(Date ini, Date fin, String path ){
		String record;
		Path ruta = Paths.get(path);
		float close = 0.0f;
		String fechaIni = dateToString(ini);
		String fechaFin = dateToString(fin);
		int contador = 0;

		
		if (fechaIni == null || fechaFin == null)
			return -1;

		try (BufferedReader br = Files.newBufferedReader(ruta)) {

			while ((record = br.readLine()) != null) {

				ArrayList<String> lFields = leerCampos(record, ",");

				try {
					if ((Float.parseFloat(lFields.get(COL_FECHA))) >= (Float.parseFloat(fechaIni))
							&& (Float.parseFloat(lFields.get(COL_FECHA))) <= (Float.parseFloat(fechaFin))) {
						contador++;
						close += Float.parseFloat(lFields.get(COL_CLOSE));
					}

				} catch (Exception e) {
					System.err.print("");
				}

			}

		} catch (IOException e) {
			System.err.println("Error E/S con " + fechaIni);
			close = -1;
		}

		return close / contador;


	};

}