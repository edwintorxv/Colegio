/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findById", query = "SELECT e FROM Estudiante e WHERE e.id = :id")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Estudiante.findByNumeroIdentificacion", query = "SELECT e FROM Estudiante e WHERE e.numeroIdentificacion = :numeroIdentificacion")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 10)
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    @JoinColumn(name = "fk_departamento_cod", referencedColumnName = "cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento fkDepartamentoCod;
    @JoinColumn(name = "fk_sede_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sede fkSedeId;
    @JoinColumn(name = "fk_curso_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso fkCursoId;

    public Estudiante() {
    }

    public Estudiante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Departamento getFkDepartamentoCod() {
        return fkDepartamentoCod;
    }

    public void setFkDepartamentoCod(Departamento fkDepartamentoCod) {
        this.fkDepartamentoCod = fkDepartamentoCod;
    }

    public Sede getFkSedeId() {
        return fkSedeId;
    }

    public void setFkSedeId(Sede fkSedeId) {
        this.fkSedeId = fkSedeId;
    }

    public Curso getFkCursoId() {
        return fkCursoId;
    }

    public void setFkCursoId(Curso fkCursoId) {
        this.fkCursoId = fkCursoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Estudiante[ id=" + id + " ]";
    }
    
}
