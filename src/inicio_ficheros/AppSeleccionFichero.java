package inicio_ficheros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppSeleccionFichero extends JFrame {

	private JFrame frame;
	private JButton btnSeleccionarArchivo;
	private JLabel lblMensaje;
	private JButton btnLectura;
	private String ruta = "./";
	private JFileChooser fichero;
	private File miFichero;
	private FileReader ficherLectura;
	private BufferedReader lectura;
	private Scanner sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AppSeleccionFichero window = new AppSeleccionFichero();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AppSeleccionFichero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(800, 150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnSeleccionarArchivo = new JButton("Seleccionar");
		btnSeleccionarArchivo.setFont(new Font("Serif", Font.PLAIN, 12));
		btnSeleccionarArchivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ruta = "./";
				fichero = new JFileChooser(ruta);
				// con .setFileSelecionMode(CONSANTE_CORRERSPONDIENTE) podemos decidir que se
				// pueda seleccionar entre ficheros y carpetas
				// Con FileFiltrer creas un filtro de tipos de archivos y despues con
				// fichero.addChoosableFileFilter se añade
				// ÚTIL: Utilizar fichero.isFile() o fichero.isDirectory para ver qué es
				fichero.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fichero.showDialog(null, "Abrir");
				miFichero = fichero.getSelectedFile();
				System.out.println(miFichero.getAbsolutePath());
				String ficheroSeleccionado;
				if (miFichero.isFile())
					ficheroSeleccionado = "Tamaño de " + miFichero.getName() + ": " + miFichero.length() + " bytes";
				else
					ficheroSeleccionado = miFichero.getName() + " es un directorio";

				lblMensaje.setText(ficheroSeleccionado);
				btnLectura.setEnabled(true);
			}
		});
		btnSeleccionarArchivo.setBounds(83, 148, 104, 30);
		frame.getContentPane().add(btnSeleccionarArchivo);

		lblMensaje = new JLabel("Tamaño: (Selecciona el archivo primero)");
		lblMensaje.setFont(new Font("Serif", Font.PLAIN, 16));
		lblMensaje.setBounds(83, 90, 282, 30);
		frame.getContentPane().add(lblMensaje);

		btnLectura = new JButton("Leer archivo");
		btnLectura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ficherLectura = new FileReader(miFichero);
					lectura = new BufferedReader(ficherLectura);
					// Desbloquea una de las opciones para ir probando
//					leerTodoConBuffered(lectura);
//					leerDiezCaracteres(lectura);
					leerScanner(miFichero);
				} catch (FileNotFoundException e1) {
					System.err.println("ERROR: No se pudo realizar la lectura");
				} catch (IOException e1) {
					System.err.println("ERROR: Buffered error");
				} finally {
					try {
						lectura.close();
						ficherLectura.close();
						sc.close();
					} catch (IOException e1) {
						System.err.println("ERROR: Alguno de los recursos no se pudo cerrar");
					}
				}

			}

		});
		btnLectura.setEnabled(false);
		btnLectura.setFont(new Font("Serif", Font.PLAIN, 12));
		btnLectura.setBounds(246, 148, 104, 30);
		frame.getContentPane().add(btnLectura);
	}

	// para leer el fichero entero
	private void leerTodoConBuffered(BufferedReader lectura) throws IOException {
		while (lectura.read() != -1) {
			System.out.print((char) lectura.read());
		}

	}

	private void leerDiezCaracteres(BufferedReader lectura) throws IOException {
		for (int i = 0; i < 10; i++) {
			System.out.print((char) lectura.read());
		}
	}

	private void leerScanner(File miFichero) throws FileNotFoundException {
		sc = new Scanner(miFichero);
		// Leer entero, si existe
		if (sc.hasNextInt())
			System.out.println("Primero número: " + sc.nextInt());
		else
			System.out.println("No se ha encontrado números");
		// Leer siguiente palabra, si la hay
		if (sc.hasNext())
			System.out.println("Siguiente palabra: " + sc.next());
		sc.nextLine();
		// Leer última línea
		System.out.println("Última linea:");
		String linea = "";
		while (sc.hasNextLine())
			linea = sc.nextLine();
		System.out.println(linea);
	}
}
