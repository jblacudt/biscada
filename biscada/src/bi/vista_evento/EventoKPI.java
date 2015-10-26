/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.vista_evento;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bi.vista_IU.VistaKpiAbstract;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class EventoKPI implements ChangeListener {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private VistaKpiAbstract vista_kpi;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public EventoKPI(VistaKpiAbstract vista_kpi) {
		this.vista_kpi = vista_kpi;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	@Override
	public void stateChanged(ChangeEvent e) {

		vista_kpi.getIndicador_kpi().Porcentaje((int) vista_kpi.getSpinner_porcentaje().getValue());
		vista_kpi.getIndicador_kpi().validate();
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

}