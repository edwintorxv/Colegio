/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Departamento;
import Facade.DepartamentoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author edwin
 */
@Named(value = "departamentoController")
@RequestScoped
public class DepartamentoController implements Serializable {

    @EJB
    private DepartamentoFacadeLocal departamentoFacadeLocal;
    private List<Departamento> lstDepartamento;

    /**
     * Creates a new instance of DepartamentoController
     */
    public DepartamentoController() {
    }

    @PostConstruct
    public void init() {
        this.lstDepartamento = this.departamentoFacadeLocal.findAll();
    }

    public DepartamentoFacadeLocal getDepartamentoFacadeLocal() {
        return departamentoFacadeLocal;
    }

    public void setDepartamentoFacadeLocal(DepartamentoFacadeLocal departamentoFacadeLocal) {
        this.departamentoFacadeLocal = departamentoFacadeLocal;
    }

    public List<Departamento> getLstDepartamento() {
        return lstDepartamento;
    }

    public void setLstDepartamento(List<Departamento> lstDepartamento) {
        this.lstDepartamento = lstDepartamento;
    }

}
