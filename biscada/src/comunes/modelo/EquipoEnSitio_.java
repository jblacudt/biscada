package comunes.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-08-16T09:58:51.685-0300")
@StaticMetamodel(EquipoEnSitio.class)
public class EquipoEnSitio_ {
	public static volatile SingularAttribute<EquipoEnSitio, Integer> id;
	public static volatile SingularAttribute<EquipoEnSitio, Sitio> sitio;
	public static volatile SingularAttribute<EquipoEnSitio, TipoDeEquipo> tipo_de_equipo;
	public static volatile SingularAttribute<EquipoEnSitio, Integer> id_equipo;
}