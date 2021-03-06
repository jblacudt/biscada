/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.entidades;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

/**
 * Class Responsibility Collaborator (CRC) design:
 * 
 * ==== parte clase =========================
 * 
 * YO REPRESENTO, un componente grafico que se utiliza en la pantalla ETL
 * 
 * ==== parte responsabilidad ===============
 * 
 * LO QUE HAGO, doy al usuario la posibilidad de elegir la direccion en la
 * estrucutra de directorios desde la cual se leeran los archivos dbf, si es que
 * hay alguno alli.
 * 
 * LO QUE CONOZCO, la direccion en String que eligi� el usuario. disponible para
 * los servicios que la necesiten
 * 
 * ==== parte colaboracion ==================
 * 
 * MI COLABORADOR PRINCIPAL, es javax.swing.JFileChooser
 * 
 * COMO INTERACTUO CON MI COLABORADOR, puedo delegarle el manejo de ventana
 * desplegable con todos los botones de navegacion y seleccion de nueva
 * direccion.
 *
 * @author hdonato
 * 
 */
public class ComponenteSeleccionarDireccion extends JPanel implements ActionListener {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static final long serialVersionUID = 1L;

	private JButton btnCambiar;
	private JFileChooser chooser;

	private JTextField txtDireccionFuente;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ComponenteSeleccionarDireccion(JTextField txtDireccionFuente) {
		setBorder(null);

		this.txtDireccionFuente = txtDireccionFuente;
		File origen_datos = new File(txtDireccionFuente.getText());

		chooser = new JFileChooser();
		chooser.setCurrentDirectory(origen_datos);
		chooser.setDialogTitle("Seleccione origen/destino para los datos");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);

		if (!Beans.isDesignTime() && !origen_datos.exists())
			JOptionPane.showMessageDialog(new JFrame("Error"), "Carpeta origen de datos no existe", "Backup problem",
					JOptionPane.ERROR_MESSAGE);

		btnCambiar = new JButton("Cambiar...");
		btnCambiar.addActionListener(this);
		setLayout(new BorderLayout(0, 0));
		add(btnCambiar);

		actualizarDireccion();
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	/**
	 * cuando el usuario presiona el boton cambiar se despliega una ventana de
	 * navegacion para seleccionar la nueva carpeta origen de los datos para
	 * procesar por el ETL
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			actualizarDireccion();
	}

	/**
	 * carga en la barra de texto solo direcciones validades por el navegador de
	 * carpetas (en esta implementacion jfilechooser)
	 */
	private void actualizarDireccion() {

		String directorio_actual = null, archivo_seleccionado;

		try {
			directorio_actual = chooser.getCurrentDirectory().getPath();
			archivo_seleccionado = chooser.getSelectedFile().getPath();
			archivo_seleccionado = archivo_seleccionado.substring(archivo_seleccionado.lastIndexOf("\\"));
		} catch (NullPointerException excepcion) {
			archivo_seleccionado = "";
		}
		txtDireccionFuente.setText(directorio_actual + archivo_seleccionado);
	}
	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */
}