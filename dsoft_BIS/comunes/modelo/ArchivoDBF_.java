package modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-02T16:45:54.625-0300")
@StaticMetamodel(ArchivoDBF.class)
public class ArchivoDBF_ {
	public static volatile SingularAttribute<ArchivoDBF, Integer> id;
	public static volatile SingularAttribute<ArchivoDBF, String> ruta;
	public static volatile SingularAttribute<ArchivoDBF, Calendar> comienzo;
	public static volatile SingularAttribute<ArchivoDBF, Calendar> fin;
	public static volatile SingularAttribute<ArchivoDBF, Boolean> valido;
	public static volatile CollectionAttribute<ArchivoDBF, Alarma> lista_alarmas;
}
