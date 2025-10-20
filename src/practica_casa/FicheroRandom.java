package practica_casa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class FicheroRandom {

	private File miFichero;
	private RandomAccessFile fichero;

	public FicheroRandom(String miFichero, String accion) {
		try {
			this.miFichero = new File(miFichero);
			fichero = new RandomAccessFile(miFichero, accion);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: desde constructor FicherRandom");
//			e.printStackTrace();
		}
	}

	public void leerByteAByte() throws IOException {
		if (miFichero.length() == 0)
			System.out.println("Está vacío");
		else {
			int letra = 0;
			System.out.println("Leyendo fichero...");
			for (int i = 0; i < fichero.length(); i++) {
				letra = fichero.read();
				System.out.println(letra);
			}
			fichero.seek(0); // reseteamos puntero
		}
	}

	public void leerLineasConRandom() throws IOException {
		if (miFichero.length() == 0)
			System.out.println("Está vacío");
		else {
			String texto = "";
			System.out.println("Leyendo fichero...");
			for (int i = 0; i < fichero.length(); i++) {
				texto = fichero.readLine();
				if (texto != null)
					System.out.println(texto);
				else
					i = (int) (fichero.length() - 1);
			}

			fichero.seek(0); // reseteamos puntero
		}
	}

	public void leerTexto() throws IOException {
		FileInputStream ficheroLectura = new FileInputStream(miFichero);
		Scanner lectura = new Scanner(ficheroLectura);
		while (lectura.hasNextLine())
			System.out.println(lectura.nextLine());
		lectura.close();
		ficheroLectura.close();
	}

	public void escribir(int caracteres) throws IOException {
		for (int i = 1; i <= caracteres; i++)
			fichero.writeChar(i);
		fichero.seek(0);
	}

	public void escribirTexto() throws IOException {
		Scanner sc = new Scanner(System.in);
		FileOutputStream ficheroEscritura = new FileOutputStream(miFichero, true);
		PrintWriter escritura = new PrintWriter(ficheroEscritura, true);
		System.out.println("Escribe el texto que quieras añadir a la nota:");
		String cadena = sc.nextLine();
		escritura.println(cadena);
		while (!cadena.equalsIgnoreCase("fin")) {
			cadena = sc.nextLine();
			escritura.println(cadena);
		}
		sc.close();
		escritura.close();
		ficheroEscritura.close();
	}

	public void cerrarRecursos() throws IOException {
		fichero.close();
	}
}
