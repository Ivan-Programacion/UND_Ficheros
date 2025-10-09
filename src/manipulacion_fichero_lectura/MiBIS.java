package manipulacion_fichero_lectura;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MiBIS extends BufferedInputStream {

	public MiBIS(FileInputStream in) {
		super(in);
	}

	public byte[] read(int tam) throws IOException {
		// Creamos un array de bytes con los espacios que queremos guardar
		byte listaBytes[] = new byte[tam];
		// Dividimos el tamaño del fichero en el array de bytes hasta donde nos quepa
		// (definido por el tamaño)
		int recorrido = read(listaBytes);
		// Si el tamaño del archivo es igual o mayor (con igual nos vale porque solo
		// cogerá hasta el tamaño indicado)
		if (recorrido == tam)
			return listaBytes;
		// Si no, el array a devolver será del tamaño indicado
		else if (recorrido > 0) {
			byte[] listaBytes2 = new byte[recorrido];
			return listaBytes2;
		// Si el archivo está vacío, devolvemos array de 0 espacios
		} else if (recorrido == 0)
			return new byte[0];
		// Si hay cualquier problema, devuelve null
		else
			return null;
	}

}
