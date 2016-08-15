/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.familias;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class ExpRegFamilia {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private String expresion_regular;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ExpRegFamilia() {

		expresion_regular = "" // expresion regular para identificar el tipo de
								// suceso
				+ "" + // 1 grupo = gpo 1 a gpo 1
				BackupActivo.getExpresion_regular()//
				+ "|" + // 1 grupo = gpo 2 a gpo 2
				Cloacal.getExpresion_regular()//
				+ "|" + // 1 grupo = gpo 3 a gpo 3
				ErrorComunicacion.getExpresion_regular()//
				+ "|" + // 1 grupo = gpo 4 a gpo 4
				Login.getExpresion_regular()//
				+ "|" + // 1 grupo = gpo 5 a gpo 5
				Potable.getExpresion_regular()//
				+ "|" + // 1 grupo = gpo 6 a gpo 6
				Reuso.getExpresion_regular()//
				;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public String getExpresion_regular() {
		return expresion_regular;
	}
}