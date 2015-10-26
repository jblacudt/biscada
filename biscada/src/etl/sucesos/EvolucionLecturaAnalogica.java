/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.sucesos;

import comunes.modelo.Suceso;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class EvolucionLecturaAnalogica extends Suceso {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "(FALLA EVO)";

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public static String getExpresion_regular() {
		return expresion_regular;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	public EvolucionLecturaAnalogica() {
		super.setDescripcion(this.toString());
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "evolucion excedida en entrada analogica";
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}