package practica_clase;

import java.io.IOException;

public class MainBlocNotas {

	public static void main(String[] args) {
		String rutaFichero = "notas.txt";
		BlocNotas blocNotas;
		try {
			blocNotas = new BlocNotas(rutaFichero);
			blocNotas.menu();
		} catch (IOException e) {
			System.err.println("ERROR: Excepcion en MainBlocNotas");
//			e.printStackTrace();
		}
	}

}
