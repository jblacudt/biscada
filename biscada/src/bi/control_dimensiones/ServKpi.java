/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package bi.control_dimensiones;

/* ............................................. */
/* ............................................. */
/* INTERFASE ................................... */
/* ............................................. */

public interface ServKpi {

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	public float actualFilaMultiple(float[][] datos);

	public float promedioFilaMultiple(float[][] datos);

	public float totalFilaMultiple(float[][] datos);
}