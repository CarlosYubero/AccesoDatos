package JavaNio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ImplementacionIO {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;

		try {

			String txt;

			br = new BufferedReader(new FileReader("texto.txt"));

			while ((txt = br.readLine()) != null) {
				System.out.println(txt);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}

	}
}
