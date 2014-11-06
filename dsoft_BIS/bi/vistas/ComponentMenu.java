/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import control_general.GestorETL;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class ComponentMenu extends JFrame {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static final long serialVersionUID = 1L;

	private JMenuBar barra_menu;

	private JMenu entrada_menu_archivo;
	private JMenu entrada_menu_ruido;
	private JMenu entrada_menu_etl;
	private JMenu entrada_menu_propiedades;

	private ComponentDuracionAlarma componente_ruido_minimo;
	private ComponentDuracionAlarma componente_ruido_maximo;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ComponentMenu(String titulo) {

		super(titulo);
		setBounds(100, 100, 1110, 701);
		configMenu();
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	private void configMenu() {

		// barra menu
		barra_menu = new JMenuBar();

		configMenuArchivo();
		configMenuRuido();
		configMenuETL();
		configMenuPropiedades();

		setJMenuBar(barra_menu);
	}

	private void configMenuArchivo() {

		// submeun
		entrada_menu_archivo = new JMenu("Archivo");
		entrada_menu_archivo.setMinimumSize(getMinimumSize());

		JMenuItem item_salir = new JMenuItem("Salir");
		item_salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

		item_salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});

		// agregar opciones del menu
		entrada_menu_archivo.add(item_salir);
		entrada_menu_archivo.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_archivo);
	}

	private void configMenuRuido() {

		// submeun
		entrada_menu_ruido = new JMenu("Ruido");
		entrada_menu_ruido.setMinimumSize(getMinimumSize());

		JMenu submenu_config_ruido = new JMenu("Configurar");

		componente_ruido_minimo = new ComponentDuracionAlarma("minimo para ser aceptada", true);
		componente_ruido_maximo = new ComponentDuracionAlarma("maximo para ser aceptada", false);

		submenu_config_ruido.add(componente_ruido_minimo);
		submenu_config_ruido.add(componente_ruido_maximo);

		// agregar opciones del menu
		entrada_menu_ruido.add(submenu_config_ruido);
		entrada_menu_ruido.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_ruido);
	}

	private void configMenuETL() {

		entrada_menu_etl = new JMenu("ETL");
		entrada_menu_etl.setMinimumSize(getMinimumSize());

		JMenuItem item_etl = new JMenuItem("Abrir ETL");
		item_etl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				GestorETL.getSingleton().mostrarVentana();
			}
		});

		// agregar opciones del menu
		entrada_menu_etl.add(item_etl);
		entrada_menu_etl.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_etl);
	}

	private void configMenuPropiedades() {

		entrada_menu_propiedades = new JMenu("Parametros");
		entrada_menu_propiedades.setMinimumSize(getMinimumSize());

		JMenuItem item_etl = new JMenuItem("Configurar...");
		item_etl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO hugo: hacer archivo propertys y levantar ventana desde aca
			}
		});

		// agregar opciones del menu
		entrada_menu_propiedades.add(item_etl);
		entrada_menu_propiedades.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_propiedades);
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public ComponentDuracionAlarma getComponente_ruido_minimo() {
		return componente_ruido_minimo;
	}

	public ComponentDuracionAlarma getComponente_ruido_maximo() {
		return componente_ruido_maximo;
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */
}