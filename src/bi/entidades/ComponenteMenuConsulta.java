/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import bi.vistas.consultas.VistaConsultaSimple;
import etl.controles.GestorETL;
import propiedades.controles.GestorPropiedades;
import propiedades.controles.servicios.ServPropiedades;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

/**
 * Class Responsibility Collaborator (CRC) design:
 * 
 * ==== parte clase =========================
 * 
 * YO REPRESENTO, un componente grafico que se utiliza en la pantalla BI
 * 
 * ==== parte responsabilidad ===============
 * 
 * LO QUE HAGO, doy a la pantalla de consultas del BI un marco de contencion
 * para todos sus componentes. extiendo de JFrame y mi especializacion incluye
 * el agregado de un menu superior.
 * 
 * LO QUE CONOZCO, como soy el marco de la primer pantalla que se ve al ejecutar
 * la aplicacion, a traves de mis menues es posible acceder a las demas
 * pantallas (aplicar dimension elegida sobre la consulta, proceso etl,
 * configuracion de propiedades).
 * 
 * ==== parte colaboracion ==================
 * 
 * MI COLABORADOR PRINCIPAL,
 * 
 * COMO INTERACTUO CON MI COLABORADOR,
 *
 * @author hdonato
 * 
 */
public class ComponenteMenuConsulta extends JFrame {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static final long serialVersionUID = 1L;

	private JMenuBar barra_menu;

	private JMenu entrada_menu_archivo;
	private JMenu entrada_menu_alarma;
	private JMenu entrada_menu_ruido;
	private JMenu entrada_menu_etl;
	private JMenu entrada_menu_propiedades;

	private JCheckBox componente_ini_incompleta;
	private JCheckBox componente_ack_incompleta;
	private JCheckBox componente_fin_incompleta;

	private ComponenteDuracionAlarma componente_ruido_minimo;
	private ComponenteDuracionAlarma componente_ruido_maximo;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ComponenteMenuConsulta(String titulo) {

		super(titulo);

		setBounds(100, 100, 714, 585);
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
		configMenuAlarmaIncompleta();
		configMenuRuido();
		configMenuETL();
		configMenuPropiedades();

		setJMenuBar(barra_menu);
	}

	private void configMenuAlarmaIncompleta() {

		// submeun
		entrada_menu_alarma = new JMenu("Alarma");
		entrada_menu_alarma.setMinimumSize(getMinimumSize());

		JMenu submenu_fecha_incompleta = new JMenu("incluir incompleta");

		componente_ini_incompleta = new JCheckBox("inicio");
		componente_ack_incompleta = new JCheckBox("ack", true);
		componente_fin_incompleta = new JCheckBox("fin");

		submenu_fecha_incompleta.add(componente_ini_incompleta);
		submenu_fecha_incompleta.add(componente_ack_incompleta);
		submenu_fecha_incompleta.add(componente_fin_incompleta);

		// agregar opciones del menu
		entrada_menu_alarma.add(submenu_fecha_incompleta);
		entrada_menu_alarma.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_alarma);
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

				JPanel panel = (JPanel) getContentPane();

				if (panel instanceof VistaConsultaSimple)
					System.exit(0);
				else
					dispose();
			}
		});

		// agregar opciones del menu
		entrada_menu_archivo.add(item_salir);
		entrada_menu_archivo.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_archivo);
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

		JMenuItem item_propiedades = new JMenuItem("Configurar...");

		item_propiedades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				GestorPropiedades.getSingleton().mostrarVentana();
			}
		});

		// agregar opciones del menu
		entrada_menu_propiedades.add(item_propiedades);
		entrada_menu_propiedades.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_propiedades);
	}

	private void configMenuRuido() {

		// submeun
		entrada_menu_ruido = new JMenu("Ruido");
		entrada_menu_ruido.setMinimumSize(getMinimumSize());

		JMenu submenu_config_ruido = new JMenu("Configurar");

		int valor_inicial = Integer.valueOf(ServPropiedades.getInstancia().getProperty("Ruido.MINIMA_DURACION_ALARMA"));
		componente_ruido_minimo = new ComponenteDuracionAlarma("minima duracion", valor_inicial, true);

		valor_inicial = Integer.valueOf(ServPropiedades.getInstancia().getProperty("Ruido.MAXIMA_DURACION_ALARMA"));
		componente_ruido_maximo = new ComponenteDuracionAlarma("maxima duracion", valor_inicial, false);

		submenu_config_ruido.add(componente_ruido_minimo);
		submenu_config_ruido.add(componente_ruido_maximo);

		// agregar opciones del menu
		entrada_menu_ruido.add(submenu_config_ruido);
		entrada_menu_ruido.addSeparator();

		// agregar menu a la barra
		barra_menu.add(entrada_menu_ruido);
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public JCheckBox getComponente_ack_incompleta() {
		return componente_ack_incompleta;
	}

	public JCheckBox getComponente_fin_incompleta() {
		return componente_fin_incompleta;
	}

	public JCheckBox getComponente_ini_incompleta() {
		return componente_ini_incompleta;
	}

	public ComponenteDuracionAlarma getComponente_ruido_maximo() {
		return componente_ruido_maximo;
	}

	public ComponenteDuracionAlarma getComponente_ruido_minimo() {
		return componente_ruido_minimo;
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */
}