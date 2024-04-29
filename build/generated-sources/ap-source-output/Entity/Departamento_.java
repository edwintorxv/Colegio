package Entity;

import Entity.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-29T08:11:31")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile ListAttribute<Departamento, Estudiante> estudianteList;
    public static volatile SingularAttribute<Departamento, Integer> cod;
    public static volatile SingularAttribute<Departamento, String> nombre;

}