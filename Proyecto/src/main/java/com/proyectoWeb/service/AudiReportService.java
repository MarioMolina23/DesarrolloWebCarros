package com.proyectoWeb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class AudiReportService {

    private String reportPath;

    public String generateReport() {
        try {
            File file = ResourceUtils.getFile("classpath:ReporteAudi.jasper");
            reportPath = file.getParent();

            // Carga el reporte
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);

            // Añade paramáteros (pero para este caso no hay)
            Map<String, Object> parameters = new HashMap<>();

            //Instanciar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/baseDatosVehiculo", "usuario", "password");

            // Llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

            // Exporta a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\ReporteAudis.pdf");
            return reportPath + "\\ReporteAudis.pdf";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}