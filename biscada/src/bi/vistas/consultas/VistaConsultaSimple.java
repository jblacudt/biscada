/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.vistas.consultas;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import bi.modelo.ComponenteConsulta;
import bi.modelo.ComponenteMenuConsulta;
import bi.vistas.eventos.EventoConsultaSimple;
import comunes.vistas.EventoConfigurable;
import comunes.vistas.PanelIniciable;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class VistaConsultaSimple extends JPanel implements PanelIniciable, EventoConfigurable {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static final long serialVersionUID = 1L;

	private GroupLayout groupLayout;

	private ComponenteMenuConsulta frame_menu_bi;

	private JPanel panelDimensiones;

	private ComponenteConsulta componenteConsulta;

	private JButton btnTiempoDespeje;
	private JButton btnSuceso;
	private JButton btnSitio;
	private JButton btnTemporada;
	private JButton btnFamilia;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public VistaConsultaSimple(ComponenteMenuConsulta frame_menu_bi) {

		this.frame_menu_bi = frame_menu_bi;
		iniciarComponentes();
		configEventos();
	}

	@Override
	public void configEventos() {

		EventoConsultaSimple eventos = new EventoConsultaSimple(this);

		btnFamilia.addActionListener(eventos);
		btnSitio.addActionListener(eventos);
		btnSuceso.addActionListener(eventos);
		btnTiempoDespeje.addActionListener(eventos);
		btnTemporada.addActionListener(eventos);
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public JButton getBtnFamilia() {
		return btnFamilia;
	}

	public JButton getBtnSitio() {
		return btnSitio;
	}

	public JButton getBtnSuceso() {
		return btnSuceso;
	}

	public JButton getBtnTemporada() {
		return btnTemporada;
	}

	public JButton getBtnTiempoDespeje() {
		return btnTiempoDespeje;
	}

	public ComponenteConsulta getComponenteConsulta() {
		return componenteConsulta;
	}

	@Override
	public void iniciarComponentes() {

		panelDimensiones = new JPanel();
		panelDimensiones.setAlignmentX(Component.RIGHT_ALIGNMENT);

		componenteConsulta = new ComponenteConsulta(frame_menu_bi);

		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelDimensiones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 765,
										Short.MAX_VALUE)
								.addComponent(componenteConsulta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 765,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(componenteConsulta, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelDimensiones, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		btnTiempoDespeje = new JButton("tiempo despeje");
		btnTiempoDespeje.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnTiempoDespeje.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnSuceso = new JButton("suceso");
		btnSuceso.setPreferredSize(new Dimension(105, 23));
		btnSuceso.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnSuceso.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnSitio = new JButton("sitio");
		btnSitio.setPreferredSize(new Dimension(105, 23));
		btnSitio.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnSitio.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelDimensiones.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Segundo nivel evaluacion - Dimension",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDimensiones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnFamilia = new JButton("familia");
		btnFamilia.setPreferredSize(new Dimension(105, 23));
		btnFamilia.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnFamilia.setAlignmentX(1.0f);

		btnTemporada = new JButton("temporada");
		btnTemporada.setPreferredSize(new Dimension(105, 23));
		btnTemporada.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnTemporada.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		panelDimensiones.add(btnFamilia);
		panelDimensiones.add(btnSitio);
		panelDimensiones.add(btnSuceso);
		panelDimensiones.add(btnTiempoDespeje);
		panelDimensiones.add(btnTemporada);

		setLayout(groupLayout);
	}
}