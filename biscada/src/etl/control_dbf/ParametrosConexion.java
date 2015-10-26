/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package etl.control_dbf;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

public class ParametrosConexion {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	private int tamano_encabezado;
	private int tamano_fila_alarma;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public ParametrosConexion(int tamano_encabezado, int tamano_fila_alarma) {

		this.tamano_encabezado = tamano_encabezado;
		this.tamano_fila_alarma = tamano_fila_alarma;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public int getTamano_encabezado() {
		return tamano_encabezado;
	}

	public int getTamano_fila_alarma() {
		return tamano_fila_alarma;
	}
}
