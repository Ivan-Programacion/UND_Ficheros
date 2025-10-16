package practica_clase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BlocNotas {

	private Scanner sc;
	private File fichero;
	private FileInputStream ficheroLectura;
	private Scanner leer;
	private FileOutputStream ficheroEscritura;
	private PrintWriter escribir;

	public BlocNotas(String fichero) {
		sc = new Scanner(System.in);
		this.fichero = new File(fichero);
		if (!this.fichero.exists())
			try {
				this.fichero.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: Excepcion en Constrcutor de BlocNotas (fichero)");
				cerrarRecursos();
				System.exit(-1);
//				e.printStackTrace();
			}
	}

	public void menu() {
		int opcion = 0;
		while (opcion != 4) {
			System.out.println("Bienvenido al Gestor de Notas");
			System.out.println("1. Añadir notas");
			System.out.println("2. Mostrar notas");
			System.out.println("3. Eliminar nota");
			System.out.println("4. Salir");
			System.out.print("Selecciona una opción: ");
			if (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("No es una opción válida");
			} else {
				opcion = sc.nextInt();
				if (opcion < 0 || opcion > 4)
					System.out.println("No es una opción válida");
				else if (opcion != 4)
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
			sc.nextLine(); // Salto línea
			System.out.print("Introduce tu nota: ");
			nota = sc.nextLine();
			escribir.println(nota);
			cerrarRecursosEscritura();
		} else if (opcion == 2) {
			ficheroLectura = new FileInputStream(fichero);
			leer = new Scanner(ficheroLectura);
			while (leer.hasNextLine())
				System.out.println(leer.nextLine());
			cerrarRecursosLectura();
		} else {
			List<String> listaNotas = new LinkedList<>();
			ficheroLectura = new FileInputStream(fichero);
			leer = new Scanner(ficheroLectura);
			sc.nextLine(); // Salto línea
			while (leer.hasNextLine())
				listaNotas.add(leer.nextLine());
			eliminarNota(listaNotas);
			cerrarRecursosLectura();
		}
	}

	private void eliminarNota(List<String> lista) throws IOException {
		int notaSeleccionada = 0;
		System.out.println("Notas:");
		for (int i = 0; i < lista.size(); i++)
			System.out.println((i + 1) + ". " + lista.get(i));
		System.out.print("Selecciona la nota que quieras eliminar: ");
		if (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("No es una opción válida");
			System.out.println("Volviendo al menú inicial");
		} else {
			notaSeleccionada = sc.nextInt();
			if (notaSeleccionada < 1 || notaSeleccionada > lista.size()) {
				System.out.println("No es una opción válida");
				System.out.println("Volviendo al menú inicial");
			} else {
				for (int i = 0; i < lista.size(); i++)
					if ((i + 1) == notaSeleccionada) {
						lista.remove(i);
						i = lista.size() - 1;
					}
				ficheroEscritura = new FileOutputStream(fichero);
				escribir = new PrintWriter(ficheroEscritura);
				for (String nota : lista)
					escribir.println(nota);
				cerrarRecursosEscritura();
			}
			System.out.println("Nota eliminada");
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

	public void cerrarRecursos() {
		sc.close();
	}

}
