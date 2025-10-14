package manipulacion_ficheros_escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscrituraPrint {
	
	public static void main(String[] args) {
		File fichero = new File ("pruebaPrint.txt");
		try {
			PrintWriter escritura = new PrintWriter(fichero);
			System.out.println("Creando archivo " + fichero.getName());
			escritura.print("Probando");
			escritura.close();
			Scanner lectura = new Scanner(fichero);
			System.out.println(lectura.nextLine());
			lectura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
