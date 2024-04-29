/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Curso;
import Facade.CursoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author edwin
 */
@Named(value = "cursoController")
@Dependent
public class CursoController {

    @EJB
    private CursoFacadeLocal cursoFacadeLocal;
    private List<Curso> lstCurso;

    /**
     * Creates a new instance of CursoController
     */
    public CursoController() {
    }

    @PostConstruct
    public void init() {
        this.lstCurso = this.cursoFacadeLocal.findAll();
    }

    public CursoFacadeLocal getCursoFacadeLocal() {
        return cursoFacadeLocal;
    }

    public void setCursoFacadeLocal(CursoFacadeLocal cursoFacadeLocal) {
        this.cursoFacadeLocal = cursoFacadeLocal;
    }

    public List<Curso> getLstCurso() {
        return lstCurso;
    }

    public void setLstCurso(List<Curso> lstCurso) {
        this.lstCurso = lstCurso;
    }

}
