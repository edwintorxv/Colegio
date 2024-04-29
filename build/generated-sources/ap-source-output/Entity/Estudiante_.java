package Entity;

import Entity.Curso;
import Entity.Departamento;
import Entity.Sede;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-29T08:11:31")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, Departamento> fkDepartamentoCod;
    public static volatile SingularAttribute<Estudiante, Sede> fkSedeId;
    public static volatile SingularAttribute<Estudiante, Curso> fkCursoId;
    public static volatile SingularAttribute<Estudiante, String> numeroIdentificacion;
    public static volatile SingularAttribute<Estudiante, String> apellido;
    public static volatile SingularAttribute<Estudiante, Integer> id;
    public static volatile SingularAttribute<Estudiante, String> nombre;

}