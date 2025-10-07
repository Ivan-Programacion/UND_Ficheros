package inicio_ficheros;

import java.io.File;
import java.io.IOException;

public class BuscandoFichero {

	public static void main(String[] args) {
		String fichero = ".project";
		final boolean eliminar = false;
		File miFichero = new File(fichero);
		if (eliminar) {
			miFichero.delete();
			if (!miFichero.exists())
				System.out.println("Fichero " + fichero + " eliminado.");
		}
		if (miFichero.exists()) {
			System.out.println("mi fichero elegido es: " + miFichero.getName() + " y SÍ existe.");
			System.out.println("Su longitud es de " + miFichero.length());
		} else {
			if (!eliminar) {
				System.out.println("El fichero NO existe.");
				System.out.println("Creando fichero " + fichero);
				try {
					miFichero.createNewFile();
				} catch (IOException e) {
					System.out.println("--ERROR--");
					e.printStackTrace();
				}
			}
		}
	}
}
