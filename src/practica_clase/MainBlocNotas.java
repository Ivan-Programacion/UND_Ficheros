package practica_clase;

public class MainBlocNotas {

	public static void main(String[] args) {
		String rutaFichero = "notas.txt";
		BlocNotas blocNotas;
		blocNotas = new BlocNotas(rutaFichero);
		blocNotas.menu();
		blocNotas.cerrarRecursos();
	}

}
