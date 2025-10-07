package inicio_ficheros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class AppSeleccionFichero {

	private JFrame frame;
	private JButton btnSeleccionarArchivo;
	private JLabel lblMensaje;

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
				String ruta = "./";
				JFileChooser fichero = new JFileChooser(ruta);
				// con .setFileSelecionMode(CONSANTE_CORRERSPONDIENTE) podemos decidir que se
				// pueda seleccionar entre ficheros y carpetas
				// Con FileFiltrer creas un filtro de tipos de archivos y despues con
				// fichero.addChoosableFileFilter se añade
				// ÚTIL: Utilizar fichero.isFile() o fichero.isDirectory para ver qué es
				fichero.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fichero.showDialog(null, "Abrir");
				File miFichero = fichero.getSelectedFile();
				System.out.println(miFichero.getAbsolutePath());
				String ficheroSeleccionado;
				if (miFichero.isFile())
					ficheroSeleccionado = "Tamaño de " + miFichero.getName() + ": " + miFichero.length() + " bytes";
				else
					ficheroSeleccionado = miFichero.getName() + " es un directorio";

				lblMensaje.setText(ficheroSeleccionado);
			}
		});
		btnSeleccionarArchivo.setBounds(165, 148, 104, 30);
		frame.getContentPane().add(btnSeleccionarArchivo);

		lblMensaje = new JLabel("Tamaño: (Selecciona el archivo primero)");
		lblMensaje.setFont(new Font("Serif", Font.PLAIN, 16));
		lblMensaje.setBounds(83, 90, 282, 30);
		frame.getContentPane().add(lblMensaje);
	}
}
