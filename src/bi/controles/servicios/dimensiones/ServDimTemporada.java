/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.controles.servicios.dimensiones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bi.controles.dimensiones.temporada.FabricaTemporada;
import bi.controles.servicios.mediciones.ServMedAbstract;
import bi.controles.servicios.periodos.ServPeriodoAbstract;
import bi.entidades.Temporada;
import comunes.entidades.Alarma;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

/**
 * Class Responsibility Collaborator (CRC) design:
 * 
 * ==== parte clase =========================
 * 
 * YO REPRESENTO los servicios concretos que necesitan las vistas
 * bi.vistas.dimensiones.VistaDimTemporadaSimple y
 * bi.vistas.dimensiones.VistaDimTemporadaCompuesta
 * 
 * ==== parte responsabilidad ===============
 * 
 * LO QUE HAGO soy responsable de los servicios de dimension en las superclases
 * bi.vistas.dimensiones.VistaDimAbstractSimple y
 * bi.vistas.dimensiones.VistaDimAbstractCompuesta
 * 
 * LO QUE CONOZCO el mapa hash {clave, valor} para agrupar la consulta (simil
 * "group by" de sql) segun la dimension elegida
 * 
 * ==== parte colaboracion ==================
 * 
 * MI COLABORADOR PRINCIPAL, las herramientas de hash y ordenamiento de
 * colecciones
 * 
 * COMO INTERACTUO CON MI COLABORADOR, las herramientas hash me permiten crear
 * el mapa, dada una clave pedir los valores y visceversa. con el ordenamiento
 * de colecciones aseguro que mis mapa tenga sus valores (las alarmas) ordenadas
 * siempre de menor a mayor.
 *
 */
public class ServDimTemporada extends ServDimAbstract {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	/*
	 * An instance of HashMap has two parameters that affect its performance:
	 * initial capacity and load factor. The capacity is the number of buckets
	 * in the hash table, and the initial capacity is simply the capacity at the
	 * time the hash table is created. The load factor is a measure of how full
	 * the hash table is allowed to get before its capacity is automatically
	 * increased. When the number of entries in the hash table exceeds the
	 * product of the load factor and the current capacity, the hash table is
	 * rehashed (that is, internal data structures are rebuilt) so that the hash
	 * table has approximately twice the number of buckets.
	 */
	private Map<Temporada, List<Alarma>> map;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	@Override
	public float[][] completarTabla(ServMedAbstract serv_medicion, ServPeriodoAbstract serv_periodo,
			boolean contar_periodos_nulos) {

		int indice = 0;

		float[][] valor_retorno = new float[map.size()][0];
		List<Alarma> lista_alarmas_una_clave = null;

		for (Map.Entry<Temporada, List<Alarma>> hash_alarmas_una_clave : map.entrySet()) {

			lista_alarmas_una_clave = hash_alarmas_una_clave.getValue();

			valor_retorno[indice] = serv_medicion.completarFila(lista_alarmas_una_clave, serv_periodo);
			indice++;
		}
		return postProcesarTabla(valor_retorno, contar_periodos_nulos);
	}

	/**
	 * pide los nombres de los grupos que se obtienen de observar una lista
	 * desde una dimension espec�fica.
	 * 
	 * @return con estos nombres se llenara una tabla de simple columna que
	 *         simula la seguda entrada de la que posee los datos.
	 */
	@Override
	public Object[] getGrupos() {

		List<Temporada> lista_segun_temporada = new ArrayList<Temporada>();

		Set<Temporada> keys = map.keySet();

		for (Temporada rango_encontrado : keys)
			lista_segun_temporada.add(rango_encontrado);

		Temporada arreglo_tiempos[] = new Temporada[lista_segun_temporada.size()];
		arreglo_tiempos = lista_segun_temporada.toArray(arreglo_tiempos);
		lista_segun_temporada.clear();

		return arreglo_tiempos;
	}

	@Override
	public void realizarHash(List<Alarma> consultas) {

		map = new HashMap<Temporada, List<Alarma>>();
		FabricaTemporada fabrica_key = new FabricaTemporada();

		for (Alarma alarma_actual : consultas) {

			Temporada key = fabrica_key.buscarRango(alarma_actual);

			if (map.get(key) == null)
				map.put(key, new ArrayList<Alarma>());

			map.get(key).add(alarma_actual);
		}

		Iterator<Entry<Temporada, List<Alarma>>> it = map.entrySet().iterator();

		while (it.hasNext()) {

			Entry<Temporada, List<Alarma>> pair = it.next();

			List<Alarma> lista = pair.getValue();
			Collections.sort(lista);

			map.put(pair.getKey(), lista);
		}
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */
}