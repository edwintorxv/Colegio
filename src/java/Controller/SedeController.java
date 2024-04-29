/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Sede;
import Facade.SedeFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author edwin
 */
@Named(value = "sedeController")
@RequestScoped
public class SedeController {

    @EJB
    private SedeFacadeLocal sedeFacadeLocal;
    private List<Sede> lstSede = new ArrayList<>();
    private Sede sede;

    /**
     * Creates a new instance of SedeController
     */
    public SedeController() {
    }

    @PostConstruct
    public void init() {
        this.lstSede = this.sedeFacadeLocal.findAll();
    }

    public SedeFacadeLocal getSedeFacadeLocal() {
        return sedeFacadeLocal;
    }

    public void setSedeFacadeLocal(SedeFacadeLocal sedeFacadeLocal) {
        this.sedeFacadeLocal = sedeFacadeLocal;
    }

    public List<Sede> getLstSede() {
        return lstSede;
    }

    public void setLstSede(List<Sede> lstSede) {
        this.lstSede = lstSede;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

}
