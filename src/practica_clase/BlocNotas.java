package practica_clase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BlocNotas {

	private Scanner sc;
	private File fichero;
	private FileInputStream ficheroLectura;
	private Scanner leer;
	private FileOutputStream ficheroEscritura;
	private PrintWriter escribir;

	public BlocNotas(String fichero) throws IOException {
		sc = new Scanner(System.in);
		this.fichero = new File(fichero);
		if (!this.fichero.exists())
			this.fichero.createNewFile();
	}

	public void menu() {
		int opcion = 0;
		while (opcion != 3) {
			System.out.println("Bienvenido al Gestor de Notas");
			System.out.println("1. Añadir notas");
			System.out.println("2. Mostrar notas");
			System.out.println("3. Salir");
			System.out.print("Selecciona una opción: ");
			if (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("No es una opción válida");
			} else {
				opcion = sc.nextInt();
				if (opcion < 0 || opcion > 3)
					System.out.println("No es una opción válida");
				else if (opcion != 3)
					try {
						opcion(opcion);
					} catch (IOException e) {
						System.err.println("ERROR: Excepcion en menu()");
//						e.printStackTrace();
					}
				else
					System.out.println("Cerrando programa");
			}
		}
	}

	private void opcion(int opcion) throws IOException {
		if (opcion == 1) {
			String nota = "";
			// Puedes añadir el constructor con un segundo parámetro indicando si quieres
			// que haga el append o no
			ficheroEscritura = new FileOutputStream(fichero, true);
			escribir = new PrintWriter(ficheroEscritura, true);
			sc.nextLine();
			System.out.print("Introduce tu nota: ");
			nota = sc.nextLine();
			escribir.println(nota);
			cerrarRecursosEscritura();
		} else {
			ficheroLectura = new FileInputStream(fichero);
			leer = new Scanner(ficheroLectura);
			while (leer.hasNextLine())
				System.out.println(leer.nextLine());
			cerrarRecursosLectura();
		}
	}

	private void cerrarRecursosLectura() throws IOException {
		leer.close();
		ficheroLectura.close();
	}

	private void cerrarRecursosEscritura() throws IOException {
		escribir.close();
		ficheroEscritura.close();
	}

}
