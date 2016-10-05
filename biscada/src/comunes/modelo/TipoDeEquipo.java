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
import etl.partes_alarma.equipos.NumeroEquipoIdentificable;

/* ............................................. */
/* ............................................. */
/* CLASE ....................................... */
/* ............................................. */

/**
 * Class Responsibility Collaborator (CRC) design:
 * 
 * ==== parte clase =========================
 * 
 * YO REPRESENTO,
 * 
 * ==== parte responsabilidad ===============
 * 
 * LO QUE HAGO,
 * 
 * LO QUE CONOZCO,
 * 
 * ==== parte colaboracion ==================
 * 
 * MI COLABORADOR PRINCIPAL,
 * 
 * COMO INTERACTUO CON MI COLABORADOR,
 * 
 * @author hdonato
 *
 */
@Entity
@Table(name = "tipo_de_equipo")
@NamedQueries({ @NamedQuery(name = "TipoDeEquipo.buscTodos", query = "SELECT tabla FROM TipoDeEquipo tabla"),
		@NamedQuery(name = "TipoDeEquipo.buscDescripcion", query = "SELECT tabla FROM TipoDeEquipo tabla WHERE tabla.descripcion = :descripcion"), })
public class TipoDeEquipo implements TipoDatoFabricable, NumeroEquipoIdentificable {

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

		if (!(object instanceof TipoDeEquipo))
			return false;

		TipoDeEquipo equipo_a_comparar = (TipoDeEquipo) object;
		return this.descripcion.equals(equipo_a_comparar.getDescripcion());
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public Integer getNumero(String discriminante) {
		return null;
	}

	/* ............................................. */
	/* ............................................. */
	/* GET'S ....................................... */
	/* ............................................. */

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
	/* SET'S ....................................... */
	/* ............................................. */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}