/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Sede;
import Facade.SedeFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author edwin
 */
@FacesConverter(forClass = Sede.class, value = "sedeConverter")
public class SedeConverter implements Converter {

    private SedeFacadeLocal sedeFacadeLocal;

    public SedeConverter() {
        sedeFacadeLocal = CDI.current().select(SedeFacadeLocal.class).get();
    }

    public SedeFacadeLocal getSedeFacadeLocal() {
        return sedeFacadeLocal;
    }

    public void setSedeFacadeLocal(SedeFacadeLocal sedeFacadeLocal) {
        this.sedeFacadeLocal = sedeFacadeLocal;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return sedeFacadeLocal.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Sede) {
            Sede sede = (Sede) value;
            return sede.getId().toString();
        }
        return null;
    }

}
