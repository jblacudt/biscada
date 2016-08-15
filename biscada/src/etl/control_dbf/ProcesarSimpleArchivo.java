/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.control_dbf;

import java.util.List;

import org.apache.log4j.Logger;

import comunes.control_general.ObjetosBorrables;
import comunes.modelo.ArchivoDBF;
import etl.control_CRUDs.ServCRUDArchivoDBF;
import etl.control_etl.CampoTextoDefectuoso;
import etl.control_etl.ETL0Extraer;
import etl.control_etl.ETL1Transformar;
import etl.control_etl.ETL2Cargar;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class ProcesarSimpleArchivo implements ObjetosBorrables {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static Logger log = Logger.getLogger(ProcesarSimpleArchivo.class);

	private static int totalizador_extraidas = 0;
	private static int totalizador_transformadas = 0;

	private ETL0Extraer extractor;
	private ETL1Transformar transformador;
	private ETL2Cargar cargador;

	private List<ArchAlarma> alarmas_extraidas;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ProcesarSimpleArchivo() {
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	public void insertarSimpleArchivo(ServCRUDArchivoDBF dbf_servicio_crud, ArchivoDBF archivo_actual,
			ParametrosConexion parametros) {

		int extraidas;
		CampoTextoDefectuoso alarmas_defectuosas = new CampoTextoDefectuoso();

		dbf_servicio_crud.actualizar(archivo_actual);

		extractor = new ETL0Extraer(archivo_actual, parametros);
		alarmas_extraidas = extractor.extraerAlarmas();
		extraidas = alarmas_extraidas.size();

		transformador = new ETL1Transformar(alarmas_extraidas);
		transformador.transformarAlarmas(archivo_actual, alarmas_defectuosas);

		cargador = new ETL2Cargar(transformador.getAlarmas_transformadas(), dbf_servicio_crud);

		if (!transformador.getAlarmas_transformadas().isEmpty())
			cargador.cargarAlarmasAceptadas();
		else
			cargador.rechazarArchivo(archivo_actual);

		reportar(extraidas, transformador.getAlarmas_transformadas().size(), alarmas_defectuosas);
		actualizarTotalizadores(extraidas, transformador.getAlarmas_transformadas().size());

		dbf_servicio_crud.actualizar(archivo_actual);
	}

	public void borrarSimpleArchivo(ServCRUDArchivoDBF dbf_servicio_crud, ArchivoDBF archivo_actual) {

		dbf_servicio_crud.borrar(archivo_actual);
	}

	private void actualizarTotalizadores(int extraidas, int transformadas) {

		totalizador_extraidas += extraidas;
		totalizador_transformadas += transformadas;
	}

	private void reportar(int extraidas, int transformadas, CampoTextoDefectuoso alarmas_defectuosas) {

		log.info("se extrajeron " + extraidas + " filas del archivo DBF");
		log.info("se transformaron " + transformadas + " filas de las extraidas");

		if (!alarmas_defectuosas.estaVacia()) {
			log.info("se encontraron defectos en...");
			log.trace(alarmas_defectuosas.toString());
			log.info("de las defectuosas se aceptaron aquellas con sitio y suceso");
		}
	}

	/**
	 * muestra resultados creacion de un archivo
	 * 
	 * @param archivo_actual
	 * @param totales
	 * @param totales
	 */
	public void mostarInfo(ArchivoDBF archivo_actual, int totales, int actual) {

		log.info("ETL en archivo " + archivo_actual.getRuta().substring(archivo_actual.getRuta().lastIndexOf("\\") + 1)
				+ " [" + actual + "-" + totales + "]");
	}

	/**
	 * muestra resultados eliminacion de un archivo
	 * 
	 * @param archivo_actual
	 */
	public void mostarInfo(ArchivoDBF archivo_actual) {
		log.info("Se elimino archivo "
				+ archivo_actual.getRuta().substring(archivo_actual.getRuta().lastIndexOf("\\") + 1));
	}

	@Override
	public void liberarObjetos() {

		extractor.liberarObjetos();
		transformador.liberarObjetos();
		cargador.liberarObjetos();
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public static int getTotalizador_extraidas() {
		return totalizador_extraidas;
	}

	public static int getTotalizador_transformadas() {
		return totalizador_transformadas;
	}
}
