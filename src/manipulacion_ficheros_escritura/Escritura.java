package manipulacion_ficheros_escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritura {

	private File fichero;
	private FileOutputStream ficheroEscritura;
	private String ruta;

	public Escritura() throws FileNotFoundException {
		ruta = "ficheroEscrituraBytes.txt";
		fichero = new File(ruta);
		ficheroEscritura = new FileOutputStream(fichero);
	}

	public void escribirBytes() throws IOException {
		for (byte i = 100; i >= 0; i--) {
			// Si no existe el archivo, lo crea
			ficheroEscritura.write(i);
		}
	}

}
