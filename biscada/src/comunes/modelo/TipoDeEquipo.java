/* ............................................. */
/* ............................................. */
/* PRELIMINAR .................................. */
/* ............................................. */

package comunes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import comunes.fabrica.TipoDatoFabricable;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

@Entity
@Table(name = "tipo_de_equipo")
@NamedQueries({ @NamedQuery(name = "TipoDeEquipo.buscTodos", query = "SELECT tabla FROM TipoDeEquipo tabla"),
		@NamedQuery(name = "TipoDeEquipo.buscDescripcion", query = "SELECT tabla FROM TipoDeEquipo tabla WHERE tabla.descripcion = :descripcion"), })
public class TipoDeEquipo implements TipoDatoFabricable {

	/* ............................................. */
	/* ............................................. */
	/* ATRIBUTOS ................................... */
	/* ............................................. */

	@Column(name = "ID_TIPO_DE_EQUIPO")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_equipo")
	@TableGenerator(name = "gen_equipo", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String descripcion;

	/* ............................................. */
	/* ............................................. */
	/* CONSTRUCTOR ................................. */
	/* ............................................. */

	public TipoDeEquipo() {
	}

	public TipoDeEquipo(String descripcion) {
		this.descripcion = descripcion;
	}

	/* ............................................. */
	/* ............................................. */
	/* METODOS ..................................... */
	/* ............................................. */

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof TipoDeEquipo)) {
			return false;
		}
		TipoDeEquipo equipo_a_comparar = (TipoDeEquipo) object;
		if (this.descripcion.compareTo(equipo_a_comparar.getDescripcion()) == 0)
			return true;

		return false;
	}

	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Los objetos que son iguales deben tener el mismo codigo hash. Esto no
	 * implica Objetos desiguales tengan diferente hash, como asi tampoco que
	 * dos ojetos con el mismo codigo hash deben ser iguales.
	 * 
	 * +) Siempre que se implemente equals, se debe implementar hashCode. +)
	 * �hashcode no es clave!, pueden suceder colisiones. +) No usar en
	 * aplicaciones distribuidas.
	 * 
	 * En general, para un uso correcto de colecciones, los objetos que
	 * iteractuen con ellas deben implementar hascode.
	 * 
	 * @return el numero hash asociado al objeto.
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* ............................................. */
	/* ............................................. */
	/* SET'S ....................................... */
	/* ............................................. */

	@Override
	public String toString() {
		return descripcion;
	}
}