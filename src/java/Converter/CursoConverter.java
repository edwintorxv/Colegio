/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Curso;
import Facade.CursoFacadeLocal;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author edwin
 */
@FacesConverter(forClass = Curso.class, value = "cursoConverter")
public class CursoConverter implements Converter {

    private CursoFacadeLocal cursoFacadeLocal;

    public CursoConverter() {
        cursoFacadeLocal = CDI.current().select(CursoFacadeLocal.class).get();
    }

    public CursoFacadeLocal getCursoFacadeLocal() {
        return cursoFacadeLocal;
    }

    public void setCursoFacadeLocal(CursoFacadeLocal cursoFacadeLocal) {
        this.cursoFacadeLocal = cursoFacadeLocal;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() > 0) {
            return cursoFacadeLocal.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Curso) {
            Curso curso = (Curso) value;
            return curso.getId().toString();
        }
        return null;
    }

}
