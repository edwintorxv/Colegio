/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Departamento;
import Facade.DepartamentoFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author edwin
 */
@FacesConverter(forClass = Departamento.class, value = "departamentoConverter")
public class DepartamentoConverter implements Converter {

    private DepartamentoFacadeLocal departamentoFacadeLocal;

    public DepartamentoConverter() {
        this.departamentoFacadeLocal = CDI.current().select(DepartamentoFacadeLocal.class).get();
    }

    public DepartamentoFacadeLocal getDepartamentoFacadeLocal() {
        return departamentoFacadeLocal;
    }

    public void setDepartamentoFacadeLocal(DepartamentoFacadeLocal departamentoFacadeLocal) {
        this.departamentoFacadeLocal = departamentoFacadeLocal;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return departamentoFacadeLocal.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Departamento) {
            Departamento departamento = (Departamento) value;
            return departamento.getCod().toString();
        }
        return null;
    }

}
