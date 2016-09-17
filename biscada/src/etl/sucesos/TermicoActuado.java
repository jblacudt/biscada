/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.sucesos;

import comunes.fabrica.Constantes;
import comunes.fabrica.TipoDatoFabricable;
import comunes.modelo.Suceso;
import etl.excepciones.CampoTextoAmbiguoExcepcion;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class TermicoActuado extends Suceso {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "TERMIC[AO]|ARRANCADOR|(Falla|FALLA)(?!EVO)";

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

	public TermicoActuado() {
		super.setDescripcion(this.toString());
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "termico actuado";
	}

	public static void asociar(TipoDatoFabricable valor, String discriminante) throws CampoTextoAmbiguoExcepcion {

		if (discriminante
				.matches(Constantes.ABRE_EXP_REG + TermicoActuado.getExpresion_regular() + Constantes.CIERRA_EXP_REG)) {

			if (valor != null)
				throw new CampoTextoAmbiguoExcepcion(discriminante + " [ " + TermicoActuado.class.getSimpleName()
						+ " - " + valor.getClass().getSimpleName() + " ]");

			valor = new TermicoActuado();
		}
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}
