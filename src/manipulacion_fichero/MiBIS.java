package manipulacion_fichero;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MiBIS extends BufferedInputStream {

	public MiBIS(FileInputStream in) {
		super(in);
	}

	public byte[] read(int tam) throws IOException {
		byte listaBytes[] = new byte[tam];
		int r = read(listaBytes);
		if (r == tam)
			return listaBytes;
		else if (r > 0) {
			byte[] listaBytes2 = new byte[r];
			return listaBytes2;
		} else if (r == 0)
			return new byte[0];
		else
			return null;
	}

}
