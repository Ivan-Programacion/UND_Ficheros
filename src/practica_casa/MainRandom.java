package practica_casa;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainRandom {

	public static void main(String[] args) {
		String fichero = "ficheroRandom.txt";
		String accion = "rwd";
		int numCaracteres = 100;
		try {
			FicheroRandom miFichero = new FicheroRandom(fichero, accion);
			System.out.println("Se ha creado el archivo correctamente");
			
//			miFichero.leerByteAByte();
			
//			System.out.println("Escribiendo...");
//			miFichero.escribir(numCaracteres);
//			System.out.println("Esribir cadena de texto");
//			miFichero.escribirTexto();
			
			System.out.println("Leyendo caracter a caractera");
			miFichero.leerByteAByte();
//			System.out.println("Leyendo líneas con Random");
//			miFichero.leerLineasConRandom();
//			System.out.println("Leyendo texto");
//			miFichero.leerTexto();
			miFichero.cerrarRecursos();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
