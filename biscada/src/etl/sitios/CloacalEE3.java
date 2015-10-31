/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.sitios;

import comunes.modelo.Sitio;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class CloacalEE3 extends Sitio {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "([Ee][Ee]3|station\\s403)";

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

	public CloacalEE3() {
		super.setDescripcion(this.toString());
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "cloacal EE3";
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}