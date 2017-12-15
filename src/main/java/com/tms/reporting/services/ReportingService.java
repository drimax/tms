package com.tms.reporting.services;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 12/15/2017.
 */

@Service
public class ReportingService implements IReportingService {
    @Override
    public void generateSalarySlip(String nic) {

        try {
            InputStream employeeReportStream
                    = getClass().getResourceAsStream("../java/com/tms/reporting/resources/employeeReport.jrxml");
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(employeeReportStream);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", "Employee Report");
            parameters.put("minSalary", 15000.0);
            parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource(1) );

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(
                    new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

            SimplePdfReportConfiguration reportConfig
                    = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            SimplePdfExporterConfiguration exportConfig
                    = new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("baeldung");
            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);

            exporter.exportReport();
        } catch (JRException je) {
            je.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
