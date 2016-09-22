/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.controles.dimensiones.temporada;

import java.util.Calendar;

import bi.modelo.Temporada;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class TemporadaPrimavera extends Temporada {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static int dia_inicio = 21;
	private static int dia_fin = 20;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public TemporadaPrimavera() {

		super(dia_inicio, Calendar.SEPTEMBER, dia_fin, Calendar.DECEMBER);
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "primavera";
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}