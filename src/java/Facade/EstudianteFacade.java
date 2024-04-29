/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwin
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "ColegioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public List<Estudiante> ListadoEstudianteCriterio(int curso, int sede, int ciudad) {
        List<Estudiante> lstEstudiante = null;
        try {
            Query q = getEntityManager().createNativeQuery("SELECT *"
                    + " FROM estudiante"
                    + " WHERE fk_curso_id = ?"
                    + " AND fk_sede_id = ?"
                    + " and fk_departamento_cod = ?", Estudiante.class);
            q.setParameter(1, curso);
            q.setParameter(2, sede);
            q.setParameter(3, ciudad);
            lstEstudiante = q.getResultList();
        } catch (Exception e) {
            System.out.println("Errro al consultar: " + e.getMessage());
        }
        return lstEstudiante;
    }

    @Override
    public List<Estudiante> buscarPorIdentificacion(String identificacion) {
        List<Estudiante> lstEstudiante = null;
        try {
            Query q = getEntityManager().createNativeQuery("SELECT *"
                    + " FROM estudiante"
                    + " WHERE numero_identificacion  = ?", Estudiante.class);
            q.setParameter(1, identificacion);
            lstEstudiante = q.getResultList();
        } catch (Exception e) {
            System.out.println("Errro al consultar: " + e.getMessage());
        }
        return lstEstudiante;
    }

}
