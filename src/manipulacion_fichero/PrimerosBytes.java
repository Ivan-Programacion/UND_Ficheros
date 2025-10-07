package manipulacion_fichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrimerosBytes {

	private File fichero;
	private MiBIS miClase;

	public PrimerosBytes(String ruta) {
		fichero = new File(ruta);
		if (fichero.exists())
			try {
				miClase = new MiBIS(new FileInputStream(fichero));
			} catch (FileNotFoundException e) {
				System.err.println("ERROR");
				try {
					miClase.close();
				} catch (IOException e1) {
					System.out.println("ERROR: No se pudo cerrar conexión");
				}
			}
	}

	public void manipular() {
		try {
			// Utilizamos nuestra clase creada, que hereda de BufferedInputStream, para
			// crear nuestro propio método read que nos ayude a realizar el ejercicio de
			// forma más eficiente
			byte[] lista = miClase.read(10);
			for (int i = 0; i < lista.length; i++) {
				System.out.println(i + ": " + lista[i]);
			}
		} catch (IOException e) {
			System.err.println("ERROR:");
		}
	}

}
