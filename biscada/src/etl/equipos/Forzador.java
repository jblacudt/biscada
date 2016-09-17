/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.equipos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comunes.fabrica.Constantes;
import comunes.fabrica.TipoDatoFabricable;
import comunes.modelo.TipoDeEquipo;
import etl.excepciones.CampoTextoAmbiguoExcepcion;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class Forzador extends TipoDeEquipo {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static String expresion_regular = "FORZADOR";
	private static String descripcion = "forzador";

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

	public Forzador() {
		super(descripcion);
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return descripcion;
	}

	@Override
	public Integer getNumero(String discriminante) {

		Pattern p = Pattern.compile("-?\\d+");

		Matcher m = p.matcher(discriminante);
		m.find();

		return new Integer(m.group());
	}

	public static void asociar(TipoDatoFabricable valor, String discriminante) throws CampoTextoAmbiguoExcepcion {

		if (discriminante
				.matches(Constantes.ABRE_EXP_REG + Forzador.getExpresion_regular() + Constantes.CIERRA_EXP_REG)) {

			if (valor != null)
				throw new CampoTextoAmbiguoExcepcion(discriminante + " [ " + Forzador.class.getSimpleName() + " - "
						+ valor.getClass().getSimpleName() + " ]");

			valor = new Forzador();
		}
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

}