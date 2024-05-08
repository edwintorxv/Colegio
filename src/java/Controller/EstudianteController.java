/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Curso;
import Entity.Departamento;
import Entity.Estudiante;
import Entity.Sede;
import Facade.EstudianteFacadeLocal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import util.ExportarController;

/**
 *
 * @author edwin
 */
@Named(value = "estudianteController")
@ConversationScoped
public class EstudianteController implements Serializable {

    @EJB
    private EstudianteFacadeLocal estudianteFacadeLocal;
    private Estudiante estudiante;
    private Estudiante estudianteSeleccionado;
    private Departamento departamento;
    private Sede sede;
    private Curso curso;
    private List<Estudiante> lstEstudiante;
    private boolean deshabilitado;
    private String identificacion;

    @Inject
    Conversation conversacion;

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {

    }

    @PostConstruct
    public void init() {
        this.lstEstudiante = this.estudianteFacadeLocal.findAll();
        this.estudiante = new Estudiante();
        this.deshabilitado = true;
    }

    public void crearEstudiante() {
        FacesContext fc = FacesContext.getCurrentInstance();

        this.lstEstudiante = this.estudianteFacadeLocal.buscarPorIdentificacion(identificacion);

        if (this.lstEstudiante.size() > 0) {
            FacesMessage nombre = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe el estudiante", "");
            fc.addMessage("formEstudiante", nombre);
            return;
        }

        if (this.estudiante.getNombre().isEmpty() && this.estudiante.getNombre().equals("")) {
            FacesMessage nombre = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Indique el nombre del estudiante", "");
            fc.addMessage("formEstudiante", nombre);
            return;
        }

        if (this.estudiante.getApellido().isEmpty() && this.estudiante.getApellido().equals("")) {
            FacesMessage apellido = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Indique el apellido del estudiante", "");
            fc.addMessage("formEstudiante", apellido);
            return;
        }

        if (this.identificacion.isEmpty() && this.identificacion.equals("")) {
            FacesMessage identificacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Indique el apellido del estudiante", "");
            fc.addMessage("formEstudiante", identificacion);
            return;
        }

        this.estudiante.setNumeroIdentificacion(identificacion);
        this.estudianteFacadeLocal.create(estudiante);
        FacesMessage creado = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estudiante creado", "");
        fc.addMessage("formEstudiante", creado);
    }

    public void elimniarEstudiante(Estudiante estudiante) {
        this.estudianteFacadeLocal.remove(estudiante);
    }

    public String alistaEditarEstudiante(Estudiante estudianteEditar) throws IOException {
        iniciaConversacion();
        estudiante = estudianteEditar;
        return "editarEstudiante.xhtml?faces-redirect=true";
    }

    public String guardarCambios() {
        this.estudianteFacadeLocal.edit(estudiante);
        return "listadoEstudiante.xhtml?faces-redirect=true";
    }

    public void crearReporte() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.lstEstudiante = this.estudianteFacadeLocal.ListadoEstudianteCriterio(this.curso.getId(), this.sede.getId(), this.departamento.getCod());
        try {
            if (this.lstEstudiante.size() > 0) {
                String archivo = "controlAsiatencia.csv";
                String ruta = "C:\\Users\\edwin\\OneDrive\\Documents";
                File directorio = new File(ruta + "//InformeActividades//");

                if (!directorio.exists()) {
                    directorio.mkdir();
                }

                try (FileWriter controlAsistencia = new FileWriter(directorio + "//" + archivo)) {
                    controlAsistencia.write("Nombre;Apellidos;"
                            + "Ciudad;Asistio\n");
                    for (int i = 0; i < this.lstEstudiante.size(); i++) {
                        controlAsistencia.write(
                                lstEstudiante.get(i).getNombre() + ";"
                                + lstEstudiante.get(i).getApellido() + ";"
                                + lstEstudiante.get(i).getFkDepartamentoCod().getNombre() + ";"
                                + "" + "\n");
                    }
                    //exportareporteActividad();

                } catch (Exception e) {
                    System.out.println("Error al exportar: " + e.getMessage());
                }
            } else {
                FacesMessage limiteExcedido = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay registro para exportar", "");
                fc.addMessage("frmLstEstudiante", limiteExcedido);
            }

        } catch (Exception e) {
        }
    }

    public void exportarFormatoAsistencia() {
        FacesContext mees = FacesContext.getCurrentInstance();
        try {
            String informe = "controlAsiatencia.csv";
            String ruta = "C:\\Users\\edwin\\OneDrive\\Documents";
            File directorio = new File(ruta + "\\InformeActividades\\");

            ExportarController exportarInforme = new ExportarController();
            exportarInforme.exportarInformeCSV(informe, directorio.toString());

        } catch (Exception e) {
            FacesMessage errorExportacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Primero debe buscar datos y despues si puede tratar de exportarlos", "");
            mees.addMessage("informeIndicador", errorExportacion);
        }
    }

    public void exportarReporte() {

    }

    public void iniciaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.begin();
        }
    }

    public void finalizaConversacion() {
        if (conversacion.isTransient()) {
            conversacion.end();
        }
    }

    public EstudianteFacadeLocal getEstudianteFacadeLocal() {
        return estudianteFacadeLocal;
    }

    public void setEstudianteFacadeLocal(EstudianteFacadeLocal estudianteFacadeLocal) {
        this.estudianteFacadeLocal = estudianteFacadeLocal;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiante> getLstEstudiante() {
        return lstEstudiante;
    }

    public void setLstEstudiante(List<Estudiante> lstEstudiante) {
        this.lstEstudiante = lstEstudiante;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Estudiante getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    public void setEstudianteSeleccionado(Estudiante estudianteSeleccionado) {
        this.estudianteSeleccionado = estudianteSeleccionado;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Conversation getConversacion() {
        return conversacion;
    }

    public void setConversacion(Conversation conversacion) {
        this.conversacion = conversacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isDeshabilitado() {
        return deshabilitado;
    }

    public void setDeshabilitado(boolean deshabilitado) {
        this.deshabilitado = deshabilitado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
