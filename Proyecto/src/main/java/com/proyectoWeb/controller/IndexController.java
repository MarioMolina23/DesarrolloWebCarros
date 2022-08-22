package com.proyectoWeb.controller;

import com.proyectoWeb.service.AudiReportService;
import com.proyectoWeb.service.BmwReportService;
import com.proyectoWeb.service.HondaReportService;
import com.proyectoWeb.service.MitsubishiReportService;
import com.proyectoWeb.service.ToyotaReportService;
import com.proyectoWeb.service.VolvoReportService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @Autowired
    private AudiReportService audiReportService;

    @Autowired
    private BmwReportService bmwReportService;

    @Autowired
    private HondaReportService hondaReportService;

    @Autowired
    private MitsubishiReportService mitsubishiReportService;

    @Autowired
    private ToyotaReportService toyotaReportService;

    @Autowired
    private VolvoReportService volvoReportService;
    
    @GetMapping("/index")
    public String inicio() {
        return "index";
    }

    @GetMapping("/cliente/galeria")
    public String galeria() {
        return "/cliente/galeria";
    }

    @GetMapping("/cliente/contacto")
    public String contacto() {
        return "/cliente/contacto";
    }

    @GetMapping("/cliente/acercaDe")
    public String acercaDe() {
        return "/cliente/acercaDe";
    }

    @GetMapping("/cliente/terminosCondiciones")
    public String terminosCondiciones() {
        return "/cliente/terminosCondiciones";
    }

    @GetMapping("/cliente/login")
    public String login() {
        return "/cliente/login";
    }

    @GetMapping("/cliente/register")
    public String registro() {
        return "/cliente/register";
    }

    @GetMapping("/carros/audi")
    public String carroAudi() {
        return "/carros/audi";
    }

    @GetMapping("/carros/bmw")
    public String carrobmw() {
        return "/carros/bmw";
    }

    @GetMapping("/carros/honda")
    public String carroHonda() {
        return "/carros/honda";
    }

    @GetMapping("/carros/mitsubishi")
    public String carroMitsubishi() {
        return "/carros/mitsubishi";
    }

    @GetMapping("/carros/toyota")
    public String carroToyota() {
        return "/carros/toyota";
    }

    @GetMapping("/carros/volvo")
    public String carroVolvo() {
        return "/carros/volvo";
    }

    @GetMapping("/comprar/compra")
    public String compra() {
        return "/comprar/compra";
    }

    @GetMapping("/administrador/vehiculos")
    public String admiVehiculo() {
        return "/administrador/vehiculos";
    }

    @GetMapping("/cliente/MetodoPago")
    public String MetodoPago() {
        return "/cliente/MetodoPago";
    }

    @GetMapping(value = "/ReporteAudis", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(audiReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/ReporteBmws", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFilebmw() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(bmwReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @GetMapping(value = "/ReporteHondas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFilehonda() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(hondaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/ReporteMitsubishis", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFilemitsubishi() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(mitsubishiReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/ReporteToyotas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFiletoyota() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(toyotaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/ReporteVolvos", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFilevolvo() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(volvoReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }    
}
