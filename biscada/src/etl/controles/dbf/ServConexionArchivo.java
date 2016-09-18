/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.controles.dbf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import comunes.modelo.ArchivoDBF;
import nl.knaw.dans.common.dbflib.CorruptedTableException;
import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Record;
import nl.knaw.dans.common.dbflib.Table;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

/**
 * establece la comunicacion con el archivo fuente extrae encabezado y filas de
 * alarmas. todo sin formato
 * 
 * @author hugo
 * 
 */
public class ServConexionArchivo {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private static Logger log = Logger.getLogger(ServConexionArchivo.class);

	private ArchivoDBF archivo_actual;

	private Table table;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ServConexionArchivo(ArchivoDBF archivo_actual) {

		super();
		this.archivo_actual = archivo_actual;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	public void cerrarArchivo() {

		try {
			table.close();
		} catch (IOException ex) {
			log.error("ERROR: no se puede cerrar la tabla asociada al archivo");
		}
	}

	public List<ArchAlarma> getAlarmas() {

		table = new Table(new File(archivo_actual.getRuta()));
		List<ArchAlarma> alarmas_extraidas = new ArrayList<ArchAlarma>();

		try {
			table.open(IfNonExistent.ERROR);

		} catch (CorruptedTableException e) {

			log.error("ERROR: tabla no se puede leer");
			e.printStackTrace();
		} catch (IOException e) {

			log.error("ERROR: tabla no encontrada");
			e.printStackTrace();
		}

		List<Field> fields = table.getFields();

		Iterator<Record> recordIterator = table.recordIterator();

		while (recordIterator.hasNext()) {

			final Record record = recordIterator.next();

			ServParser serv_parser = new ServParser(record, fields);
			alarmas_extraidas.add(serv_parser.separarCampos());
		}

		return alarmas_extraidas;
	}
}