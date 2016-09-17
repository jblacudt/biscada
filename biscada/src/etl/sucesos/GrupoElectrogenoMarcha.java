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

public class GrupoElectrogenoMarcha extends Suceso {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "GENO EN MARCHA|(ELETROGENO|GENERADOR|RUTNA)(?!FALLA)|(?<!FALLA)(ELECTROGENO|GENERADOR|RUTIA)";

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

	public GrupoElectrogenoMarcha() {
		super.setDescripcion(this.toString());
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return "G.E. en marcha";
	}

	public static void asociar(TipoDatoFabricable valor, String discriminante) throws CampoTextoAmbiguoExcepcion {

		if (discriminante.matches(
				Constantes.ABRE_EXP_REG + GrupoElectrogenoMarcha.getExpresion_regular() + Constantes.CIERRA_EXP_REG)) {

			if (valor != null)
				throw new CampoTextoAmbiguoExcepcion(
						discriminante + " [ " + GrupoElectrogenoMarcha.class.getSimpleName() + " - "
								+ valor.getClass().getSimpleName() + " ]");

			valor = new GrupoElectrogenoMarcha();
		}
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}