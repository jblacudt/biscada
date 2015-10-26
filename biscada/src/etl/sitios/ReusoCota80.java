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

public class ReusoCota80 extends Sitio {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "([Cc][Oo][Tt][Aa]\\s?80|station\\s153)";

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

	public ReusoCota80() {
		super.setDescripcion(this.toString());
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "reuso cota80";
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}