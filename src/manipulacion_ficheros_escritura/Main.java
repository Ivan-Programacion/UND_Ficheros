package manipulacion_ficheros_escritura;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Escritura miEscritura = new Escritura();
			miEscritura.escribirBytes();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: No se encontró archivo");
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}

}
