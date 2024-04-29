/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwin
 */
public class ExportarController {
    
    public void exportarInformeCSV(String informe, String directorio) throws FileNotFoundException, IOException {
        String archivo = informe;
        File informeCSV = new File(directorio + "//" + archivo);
        FacesContext ctx = FacesContext.getCurrentInstance();
        FileInputStream fis = new FileInputStream(informeCSV);
        byte[] bytes = new byte[1000];
        int read = 0;

        if (!ctx.getResponseComplete()) {
            String fileName = informeCSV.getName();
            String tipoFichero = "application/vnd.ms-excel";
            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType(tipoFichero);
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + fileName + "\"");
            ServletOutputStream servletOut = response.getOutputStream();

            while ((read = fis.read(bytes)) != -1) {
                servletOut.write(bytes, 0, read);
            }
            servletOut.flush();
            servletOut.close();
        }
    }
    
}
