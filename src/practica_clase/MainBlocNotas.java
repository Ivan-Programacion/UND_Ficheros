package practica_clase;

import java.io.IOException;

public class MainBlocNotas {

	public static void main(String[] args) throws IOException {
		String rutaFichero = "notas.txt";
		BlocNotas blocNotas;
		blocNotas = new BlocNotas(rutaFichero);
		blocNotas.menu();
		blocNotas.cerrarRecursos();
	}

}
