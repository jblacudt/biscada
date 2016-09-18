package etl.controles.servicios;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import comunes.fabrica.Constantes;
import comunes.fabrica.TipoDatoFabricable;
import etl.excepciones.CampoTextoAmbiguoExcepcion;

public class ServExpresionesRegulares {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static Logger log = Logger.getLogger(ServExpresionesRegulares.class);

	private Class<?> nueva_clase;

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	public TipoDatoFabricable asociar(TipoDatoFabricable dato_fabricado, String discriminante, String clase_objetivo)
			throws CampoTextoAmbiguoExcepcion {

		String expresion_regular = getExpresion_regular(clase_objetivo);
		TipoDatoFabricable nuevo_valor = null;

		if (discriminante.matches(Constantes.ABRE_EXP_REG + expresion_regular + Constantes.CIERRA_EXP_REG)) {

			if (dato_fabricado != null)
				throw new CampoTextoAmbiguoExcepcion(discriminante + " [ " + nueva_clase.getSimpleName() + " - "
						+ dato_fabricado.getClass().getSimpleName() + " ]");

			try {
				nuevo_valor = (TipoDatoFabricable) nueva_clase.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				log.error("ERROR: no se pudo pedir nueva instancia de clase " + nueva_clase.getSimpleName());
			}
		}
		return nuevo_valor;
	}

	private String getExpresion_regular(String clase_objetivo) {

		String expresion_regular = null;

		try {
			nueva_clase = Class.forName("etl.sitios." + clase_objetivo);
			Method nuevo_metodo = nueva_clase.getMethod("getExpresion_regular()");
			expresion_regular = (String) nuevo_metodo.invoke(nueva_clase);

		} catch (ClassNotFoundException e1 /* nueva clase */) {
			log.error("ERROR: clase no encontrada");
		} catch (NoSuchMethodException | SecurityException e /* nuevo metodo */) {
			log.error("ERROR: metodo no encontrado");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e /* invocar */) {
			log.error("ERROR: metodo no pudo ser invocado (ejecutado)");
		}
		return expresion_regular;
	}
}