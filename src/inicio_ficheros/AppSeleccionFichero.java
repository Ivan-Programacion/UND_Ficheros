package inicio_ficheros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
				JFileChooser ventanaSeleccionFichero = new JFileChooser(ruta);
				// con .setFileSelecionMode(CONSTANTE_CORRERSPONDIENTE) podemos decidir que se
				// pueda seleccionar entre ficheros y carpetas
				// Con FileFiltrer creas un filtro de tipos de archivos y despues con
				// fichero.addChoosableFileFilter se añade
				// ÚTIL: Utilizar ventanaSeleccionFichero.isFile() o
				// ventanaSeleccionFichero.isDirectory para ver qué es
				ventanaSeleccionFichero.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				// .showDialog --> muestra la ventana de seleccion
				// Devuelve un int indicando qué opción ha hecho el usuario:
				// - APPROVE_OPTION (aceptar = 0)
				// - CANCEL_OPTION (cancelar = 1)
				// - ERROR_OPTION (error = -1)
				// Si queremos abrir un archivo --> .showOpenDialog
				// Si queremos guardar un archivo --> .showSaveDialog
				ventanaSeleccionFichero.showDialog(null, "Abrir");
				// .getSelectedFile() --> de la ventana, el archivo que se ha seleccionado
				// pasamelo a un File para trabajar con el
				File miFichero = ventanaSeleccionFichero.getSelectedFile();
				System.out.println(miFichero.getAbsolutePath());
				String mensaje;
				if (miFichero.isFile())
					mensaje = "Tamaño de " + miFichero.getName() + ": " + miFichero.length() + " bytes";
				else
					mensaje = miFichero.getName() + " es un directorio";

				lblMensaje.setText(mensaje);
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
