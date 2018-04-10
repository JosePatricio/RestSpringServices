/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

import com.innovaciones.reporte.model.CabeceraCatalogoReporte;
import com.innovaciones.reporte.model.DetalleCatalogoReporte;
import com.innovaciones.reporte.model.Modelo;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.model.ProductoClienteReporte;
import com.innovaciones.reporte.model.ProductoRepuestoReporte;
import com.innovaciones.reporte.model.Reporte;
import com.innovaciones.reporte.model.ReporteMantenimiento;
import com.innovaciones.reporte.model.Rol;
import com.innovaciones.reporte.model.UsuarioRoles;
import com.innovaciones.reporte.model.Usuarios;
import com.innovaciones.reporte.service.ParametrosService;
import com.innovaciones.reporte.service.RolService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.context.RequestContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.faces.component.behavior.AjaxBehavior;
import javax.mail.MessagingException;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author pisama
 */
public class Utilities implements Serializable {

    public static String DIR_LOGO_INNOVACIONES = "/resources/images/logo-innovaciones.png";
    public static String DIR_LOGO_USUARIO = "/resources/images/logo-usuario.png";

    private static JasperPrint jasperPrint;
    public final static String CODE_CATEGORIA_REPUESTO = "CAT-REP";

    private static String getFullPath(String reportPath) {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath(reportPath);
    }

    public static List<DetalleCatalogoReporte> listCorrectivoOtros(CabeceraCatalogoReporte cabeceraCatalogoReporte) {

        CabeceraCatalogoReporte cabeceraCatalogoReporte1 = cabeceraCatalogoReporte;
        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte catalogoReporte;
        for (int i = 0; i < 6; i++) {
            catalogoReporte = new DetalleCatalogoReporte();
            catalogoReporte.setId(i);
            catalogoReporte.setDescripcion("");
            catalogoReporte.setEstado(true);
            catalogoReporte.setCodigoRepuesto("");
            catalogoReporte.setIdCabecera(cabeceraCatalogoReporte1);
            list.add(catalogoReporte);
        }
        return list;
    }

    public static void warn(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", msg));

    }

    public static void info(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));

    }

    public static void error(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));

    }

    public static String fomatearFecha(Date fecha) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(fecha);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String result = getDiaSemana(dayOfWeek) + ", " + dayOfMonth + " de " + getNombreMes(month) + " del " + year;
        return result;

    }

    private static String getDiaSemana(int dia) {
        String result = "";
        switch (dia) {
            case 0: {
                result = "";
                break;
            }
            case 1: {
                result = "Domingo";
                break;
            }
            case 2: {
                result = "Lunes";
                break;
            }
            case 3: {
                result = "Martes";
                break;
            }
            case 4: {
                result = "Miércoles";
                break;
            }
            case 5: {
                result = "Jueves";
                break;
            }
            case 6: {
                result = "Viernes";
                break;
            }
            case 7: {
                result = "Sábado";
                break;
            }

        }
        return result;
    }

    private static String getNombreMes(int month) {
        String result = "";
        switch (month) {
            case 0: {
                result = "Enero";
                break;
            }
            case 1: {
                result = "Febrero";
                break;
            }
            case 2: {
                result = "Marzo";
                break;
            }
            case 3: {
                result = "Abril";
                break;
            }
            case 4: {
                result = "Mayo";
                break;
            }
            case 5: {
                result = "Junio";
                break;
            }
            case 6: {
                result = "Julio";
                break;
            }
            case 7: {
                result = "Agosto";
                break;
            }
            case 8: {
                result = "Septiembre";
                break;
            }
            case 9: {
                result = "Octubre";
                break;
            }
            case 10: {
                result = "Noviembre";
                break;
            }
            case 11: {
                result = "Diciembre";
                break;
            }
            default: {
                result = "";
                break;
            }
        }
        return result;
    }

    public static String fomatearHora(Date fecha) {
        String result;
        DateFormat df = new SimpleDateFormat("HH:mm");
        result = df.format(fecha);
        return result;
    }

    public static String fomatearFechaCorto(Date fecha) {
        String result;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        result = df.format(fecha);
        return result;
    }

    public static String UUID_CODE() {

        return String.valueOf(UUID.randomUUID()).substring(0, 6);
    }

    public static String getParameter(String parameter) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String reportId = paramMap.get(parameter);
        return reportId;

    }

    public static void redirectToPage(String url) throws IOException {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + url);

    }

    public static void redireccionar(String pagina) {
        try {

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" + pagina);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setSessionText(String parameter, String mensaje) {
        setValueInSession(parameter, mensaje);
    }

    public static String getSessionText(String parameter) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String mensaje = "";
        if (fc.getExternalContext().getSessionMap().get(parameter) != null) {
            return fc.getExternalContext().getSessionMap().get(parameter).toString();
        }
        return mensaje;
    }

    public static void killSession(String parameter) {
        setValueInSession(parameter, null);
    }

    public static void setIdReporteSession(Integer idReporte) {
        setValueInSession(Enums.PARAMETRO_ID_REPORTE.getValue(), idReporte);
    }

    public static Integer getIdReporteSession() {
        Integer mensaje = 0;

        if (getValueInSession(Enums.PARAMETRO_ID_REPORTE.getValue()) != null) {
            return Integer.parseInt(getValueInSession(Enums.PARAMETRO_ID_REPORTE.getValue()).toString());
        }

        return mensaje;
    }

    public static void killIdReporteSession() {
        setValueInSession(Enums.PARAMETRO_ID_REPORTE.getValue(), null);
    }

    public static void setMensajeSession(String mensaje) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mensaje", mensaje);
    }

    public static String getMensajeSession() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String mensaje = "";
        if (fc.getExternalContext().getSessionMap().get("mensaje") != null) {
            return fc.getExternalContext().getSessionMap().get("mensaje").toString();
        }

        return mensaje;
    }

    public static void showSessionMensaje() {

        if (!getMensajeSession().isEmpty()) {
            info(getMensajeSession());
            killSession("mensaje");
        }
    }

    public static void openDialog(String dialog) {
        RequestContext.getCurrentInstance().execute("PF('" + dialog + "').show();");
    }

    public static void closeDialog(String dialog) {
        RequestContext.getCurrentInstance().execute("PF('" + dialog + "').hide();");
    }

    public static void update(String componente) {
        RequestContext.getCurrentInstance().update(componente);
    }

    public static void updateMany(String componentes) {
        String[] vec = componentes.split(",");
        for (int i = 0; i < vec.length; i++) {
            RequestContext.getCurrentInstance().update(vec[i].trim());
        }
    }

    public static Boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void clearTableFilters(String wgId) {
        RequestContext.getCurrentInstance().execute("PF('" + wgId + "').clearFilters()");
    }

    public static String formatoNumeroFactura(Integer integer) {
        return String.format("%07d", integer);
    }

    public static String numeroReporteTecnico(Usuarios tecnico, Integer reporte) {
        return tecnico.getCodigo() + "-" + String.format("%07d", reporte);
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    private static String hashString(String message, String algorithm) throws Exception {

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));

            return convertByteArrayToHexString(hashedBytes);
        } catch (Exception ex) {
            throw new Exception("Could not generate hash from String" + ex);
        }
    }

    public static String encrypt(String value) {
        try {
            return hashString(value, "MD5");
        } catch (Exception e) {
            return value;
        }

    }

    public static List<EstadosEnum> cargarEstadosBoolean() {
        List<EstadosEnum> estados = new ArrayList<>();
        estados.add(EstadosEnum.ACTIVO);
        estados.add(EstadosEnum.INACTIVO);
        return estados;
    }

    public static List<Enums> cargarTiposIngresoInvetarios() {
        List<Enums> tipoIngresos = new ArrayList<>();
        tipoIngresos.add(Enums.TIPO_INGRESO_LOCAL);
        tipoIngresos.add(Enums.TIPO_INGRESO_IMPORTACION);
        return tipoIngresos;
    }

    public static List<AsignacionReparacionEnum> cargarPrioridadAsignaciones() {
        List<AsignacionReparacionEnum> prioridades = new ArrayList<AsignacionReparacionEnum>();
        prioridades.add(AsignacionReparacionEnum.PRIORIDAD_DEFAULT);
        prioridades.add(AsignacionReparacionEnum.PRIORIDAD_BAJA);
        prioridades.add(AsignacionReparacionEnum.PRIORIDAD_NORMAL);
        prioridades.add(AsignacionReparacionEnum.PRIORIDAD_ALTA);
        return prioridades;
    }

    public static List<Enums> cargarTiposReporte() {
        List<Enums> tiposReporte = new ArrayList<Enums>();

        tiposReporte.add(Enums.TIPO_REPORTE_DIAGNOSTICO);
        tiposReporte.add(Enums.TIPO_REPORTE_REPARACION);
        tiposReporte.add(Enums.TIPO_REPORTE_CONTADORES);
        tiposReporte.add(Enums.TIPO_REPORTE_ETIQUETADORAS);
        tiposReporte.add(Enums.TIPO_REPORTE_TRITURADORAS);
        tiposReporte.add(Enums.TIPO_REPORTE_SCANNERS);
        tiposReporte.add(Enums.TIPO_REPORTE_MONITORES);

        tiposReporte.add(Enums.INSTALACION_NUEVA);
        tiposReporte.add(Enums.INSTALACION_TEMPORAL);

        return tiposReporte;
    }

    public static Date getDateServer() {
        Date date = new Date();
        return date;
    }

    public static void sendPost(String parameter) throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher(parameter);
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
    }

    public static String contrasenia(String nombre, String apellido) {

        if (!nombre.isEmpty()) {
            if (nombre.trim().split("\\s+").length > 1) {
                nombre = nombre.split("\\s+")[0].toLowerCase().trim();
            } else {
                nombre = nombre.toLowerCase().trim();
            }
        }

        if (!apellido.isEmpty()) {
            if (apellido.trim().split("\\s+").length > 1) {
                apellido = apellido.split("\\s+")[0].toLowerCase().trim();
            } else {
                apellido = apellido.toLowerCase().trim();
            }
        }

        return encrypt(nombre + "." + apellido);

    }

    public static Boolean habilitarGestionReporte(Usuarios usuarios) {
        Boolean Estado = Boolean.FALSE;
        for (UsuarioRoles usuarioRoles : usuarios.getUsuarioRolesList()) {
            if (usuarioRoles.getIdRol().getRol().equals(Enums.ROLE_POSTVENTAS.getValue())
                    || usuarioRoles.getIdRol().getRol().equals(Enums.ROLE_ADMIN.getValue())) {
                Estado = Boolean.TRUE;
                break;
            }
        }
        return Estado;
    }

    public static Boolean habilitarMenuCorto(Usuarios usuario) {
        Boolean Estado = Boolean.FALSE;
        for (UsuarioRoles usuarioRoles : usuario.getUsuarioRolesList()) {
            if (usuarioRoles.getIdRol().getRol().equals(Enums.ROLE_POSTVENTAS.getValue())
                    || usuarioRoles.getIdRol().getRol().equals(Enums.ROLE_ADMIN.getValue())
                    || usuarioRoles.getIdRol().getRol().equals(Enums.ROLE_TECNICO.getValue())) {
                Estado = Boolean.TRUE;
                break;
            }
        }
        return Estado;
    }

    public static String getAppUrl() throws MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException, MalformedObjectNameException, UnknownHostException {

        String ipAddress = "";

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getScheme(); //http - https

            if (request.getLocalAddr().equals("127.0.0.1")) {
                ipAddress += "://" + InetAddress.getLocalHost().getHostAddress();
            } else {
                ipAddress += "://" + request.getLocalAddr();
            }

            ipAddress += ":" + request.getServerPort();
            ipAddress += "/" + request.getContextPath();

        }
        return ipAddress;

    }

    private static String headerEmail(String cid) {
        StringBuilder header = new StringBuilder();

        header.append("	<table border='0' style='width:100%; margin-top: 0px; font-family:Century Gothic,arial,sans-serif;'>");
        header.append("<tr >");
        header.append("<td style='width:150px;'>");
        header.append("<a href='https://www.innovaciones.ec' target='_blank'>");
        header.append("<img style='width:150px; height:45px' alt=' ' src='cid:");

        header.append(cid);
        header.append("'/>");
        header.append("</a>");
        header.append("</td>");
        header.append("<td/>");
        header.append("<td/>");
        header.append("<td style='vertical-align: bottom;'>");
        header.append("<a style='color:#2B6CA3; text-decoration: none;' href='https://www.innovaciones.ec' target='_blank'>");
        header.append("<span style='font-size:25; font-weight:bold;'>Innovaciones Tecnol&oacute;gicas Imaginarium S.A.</span><br/>");
        header.append("</a>");
        header.append("</td>");
        header.append("</tr>");
        header.append("</table>");
        header.append("<hr style='color: #2B6CA3'/>");

        return header.toString();
    }

    private static MimeBodyPart putLogoInsideEmail(String cid) throws IOException, MessagingException {
        MimeBodyPart imagePart = new MimeBodyPart();
        String pathLogo = FacesContext.getCurrentInstance()
                .getExternalContext().getRealPath(DIR_LOGO_INNOVACIONES);

        imagePart.attachFile(pathLogo);
        imagePart.setContentID("<" + cid + ">");
        imagePart.setDisposition(MimeBodyPart.INLINE);
        return imagePart;
    }

    private static String getTitleEmail(String title) {
        StringBuilder tittle = new StringBuilder();

        tittle.append("<p style='font-weight: bold; font-size: 16px; font-family:Century Gothic,arial,sans-serif;'>");
        tittle.append(title);
        tittle.append("</p> <br/>");

        return tittle.toString();
    }

    private static String getHeaderEmail(String cid, String title) {
        StringBuilder result = new StringBuilder();
        result.append(headerEmail(cid));
        result.append(getTitleEmail(title));
        return result.toString();
    }

    private static String getContentAsignacionEmail(List<Object> listContent, String tipoAsignacion) throws ParseException {
        StringBuilder content = new StringBuilder();

        // String[] listDatos = datos.split(";");
        content.append("<p style='font-size: 14px; font-family:Century Gothic,arial,sans-serif;'>El requerimiento de ");
        content.append(tipoAsignacion);
        content.append(" para su equipo fu&eacute; registrado con la siguiente informaci&oacute;n:</p>");
        content.append("<br/>");

        content.append("<table border='0'  style='font-size:13px ;font-family:Century Gothic,arial,sans-serif;'>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Caso:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>");
        content.append(listContent.get(0));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Cliente:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span>");
        content.append(listContent.get(1));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Equipo:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span>");
        content.append(listContent.get(2));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Serie del equipo:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span>");
        content.append(listContent.get(3));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>T&eacute;cnico asignado:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span>");
        content.append(listContent.get(4));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Fecha ");
        content.append(tipoAsignacion);
        content.append("&nbsp;:</span>");
        content.append("</td>");
        content.append("<td>");
        content.append("<span>");
        content.append(fomatearFechaCorto((Date) listContent.get(5)));
        content.append("</span>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Hora ");
        content.append(tipoAsignacion);
        content.append("&nbsp;:</span>");
        content.append("</td>");
        content.append("</td>");
        content.append("<td>");

        content.append("<span>");
        content.append(fomatearHora((Date) listContent.get(6)));
        content.append("</span>");
        content.append("<br/>");
        content.append("</td>");
        content.append("</tr>");

        content.append("<tr>");
        content.append("<td>");
        content.append("<span style='font-weight: bold;'>Estado requerimiento:&nbsp;</span>");
        content.append("</td>");
        content.append("<td>");
        content.append(listContent.get(7));
        content.append("<br/>");
        content.append("</td>");
        content.append("</tr>");

        content.append("</table>");
        content.append("<br/>");

        return content.toString();
    }

    private static String footerMail() {
        StringBuilder footer = new StringBuilder();

        footer.append("<p style='color: gray;font-size: 13px; font-family:Century Gothic,arial,sans-serif;'>");
        footer.append("Cada vez que se procese su requerimiento se le notificar&aacute; mediante este mismo medio.</p>");
        footer.append("<br/><hr style='color: gray'/>");
        footer.append("<table border='0' style='width:100%;font-family:Century Gothic,arial,sans-serif;'>");
        footer.append("<tr >");
        footer.append("<td style='vertical-align: bottom;'>");
        footer.append("<div style='color: gray; font-size: 12px'>");
        footer.append("<span>Innovaciones Tecnol&oacute;gicas Imaginarium S.A</span><br/>");
        footer.append("<span>Av. Atahualpaa Oe3-109 y Pje. Orbigny<span><br/>");
        footer.append("<span>PBX: (02) 5 101-101 &#8226; (02) 2 541-600<span><br/>");
        footer.append("<a href='mailto:web@innovaciones.ec?subject=Proformar%20Equipo'>web@innovaciones.ec</a></span><br/>");
        footer.append("<span>Quito - Ecuador<span><br/>");
        footer.append("</div>");
        footer.append("</td>");
        footer.append("</tr>");
        footer.append("</table>");

        return footer.toString();
    }

    private static InternetAddress[] convertRecipientsAddress(String recipients) {
        String[] recipientList = recipients.split(";");
        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
        try {
            int counter = 0;
            for (String recipient : recipientList) {

                if (!recipient.trim().isEmpty()) {
                    recipientAddress[counter] = new InternetAddress(recipient.trim());
                }
                counter++;
            }
        } catch (Exception e) {
            System.out.println("No se pudo convertir los destinatarios de emails: " + e.getMessage());
        }
        return recipientAddress;
    }

    public static Boolean enviarMail(ParametrosService parametrosService, String recipient, String body, String subject) {
        try {
            Message message = new MimeMessage(getSessionEmail(parametrosService));
            message.setFrom(new InternetAddress(parametrosService.getByParametro(Enums.MAIL_ADDRESS.getValue()).getValor()));
            message.setRecipients(Message.RecipientType.TO, convertRecipientsAddress(recipient));
            message.setSubject(subject);
            //body = headerEmail("") + body;
            // ContentID is used by both parts            
            String cid = String.valueOf((new Date()).getTime());
            StringBuilder textEmail = new StringBuilder();
            textEmail.append(headerEmail(cid));
            textEmail.append(body);
            textEmail.append(footerMail());

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(textEmail.toString(), "UTF-8", "html");
            MimeMultipart contentMultipart = new MimeMultipart("related");
            contentMultipart.addBodyPart(textPart);
            contentMultipart.addBodyPart(putLogoInsideEmail(cid));
            message.setContent(contentMultipart);
            Transport.send(message);
            return true;
        } catch (IOException | MessagingException e) {
            System.out.println("Error enviarMail(String recipient, String body, String subject): " + e.getMessage());
            return false;

        }

    }

    private static Session getSessionEmail(ParametrosService parametrosService) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", parametrosService.getByParametro(Enums.MAIL_SMTP_HOST.getValue()).getValor());
        props.put("mail.smtp.host", parametrosService.getByParametro(Enums.MAIL_SMTP_HOST.getValue()).getValor());
        props.put("mail.smtp.port", Integer.parseInt(parametrosService.getByParametro(Enums.MAIL_SMTP_PORT.getValue()).getValor()));
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(parametrosService.getByParametro(Enums.MAIL_ADDRESS.getValue()).getValor(), parametrosService.getByParametro(Enums.MAIL_PASS.getValue()).getValor());
            }
        });
        return session;
    }

    public static Boolean enviarMail(ParametrosService parametrosService, String recipient, String title, List<Object> dataMail, String body, String subject, String tipoNotififacion) {
        try {
            if (parametrosService.getByParametro(Enums.MAIL_STATUS.getValue()).getEstado()) {

                String cid = String.valueOf((new Date()).getTime());

                MimeMessage mimeMessage = new MimeMessage(getSessionEmail(parametrosService));
                mimeMessage.setFrom(new InternetAddress(parametrosService.getByParametro(Enums.MAIL_ADDRESS.getValue()).getValor()));
                mimeMessage.setRecipients(Message.RecipientType.TO, convertRecipientsAddress(recipient));
                mimeMessage.setSubject(subject);

                // ContentID is used by both parts            
                StringBuilder textEmail = new StringBuilder();
                textEmail.append(getHeaderEmail(cid, title));

                if (tipoNotififacion.equals(Enums.REPORTE.getValue())) {
                    textEmail.append(getContentAsignacionEmail(dataMail, "reparaci&oacute;n"));
                } else if (tipoNotififacion.equals(Enums.INSTALACION.getValue())) {
                    textEmail.append(getContentAsignacionEmail(dataMail, "instalaci&oacute;n"));
                }

                textEmail.append(body);

                textEmail.append(footerMail());

                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText(textEmail.toString(), "UTF-8", "html");

                MimeMultipart contentMultipart = new MimeMultipart("related");
                contentMultipart.addBodyPart(textPart);
                contentMultipart.addBodyPart(putLogoInsideEmail(cid));
                mimeMessage.setContent(contentMultipart);

                Transport.send(mimeMessage);
                return true;
            } else {
                return false;
            }

        } catch (IOException | ParseException | MessagingException e) {
            System.out.println("Error enviarMail(String recipient, String title, List<Object> dataMail, String body, String subject, String tipoNotififacion): " + e.getMessage());
            return false;

        }

    }

    public static boolean enviarMail(ParametrosService parametrosService, ByteArrayOutputStream archivo, String recipient, String subject, String nombreArchivo) {

        try {
            if (parametrosService.getByParametro(Enums.MAIL_STATUS.getValue()).getEstado()) {

                byte[] bytes = archivo.toByteArray();
                DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
                MimeBodyPart pdfBodyPart = new MimeBodyPart();
                pdfBodyPart.setDataHandler(new DataHandler(dataSource));
                pdfBodyPart.setFileName(nombreArchivo + ".pdf");
                InternetAddress iaSender = new InternetAddress(parametrosService.getByParametro(Enums.MAIL_ADDRESS.getValue()).getValor());
                MimeMessage mimeMessage = new MimeMessage(getSessionEmail(parametrosService));
                mimeMessage.setSender(iaSender);
                mimeMessage.setSubject(subject);
                mimeMessage.setRecipients(Message.RecipientType.TO, convertRecipientsAddress(recipient));
                //InternetAddress iaRecipient = new InternetAddress(recipient);

                String cid = String.valueOf((new Date()).getTime());
                StringBuilder textEmail = new StringBuilder();
                textEmail.append(getHeaderEmail(cid, "Nuevo Reporte Creado"));
                textEmail.append(footerMail());
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText(textEmail.toString(), "UTF-8", "html");
                MimeMultipart contentMultipart = new MimeMultipart("related");
                contentMultipart.addBodyPart(textPart);
                // contentMultipart.addBodyPart(putLogoInsideEmail(cid)); // ERRORRRRR

                try {

                    System.out.println("  " + putLogoInsideEmail(cid));
                } catch (IOException | MessagingException e) {
                    System.out.println("fallo al poner imagen en mail  " + e.getMessage());
                }

                contentMultipart.addBodyPart(pdfBodyPart);
                mimeMessage.setContent(contentMultipart);
                Transport.send(mimeMessage);
                return true;
            } else {

                return false;
            }

        } catch (MessagingException ex) {
            System.out.println("Error enviarMail(ByteArrayOutputStream archivo ...: " + ex.getMessage());
            return false;
        } finally {
            //clean off
            if (null != archivo) {
                try {
                    archivo.close();
                    archivo = null;
                } catch (IOException ex) {
                    System.out.println("Error enviarMailPdf.archivo.close.finally(): " + ex.getMessage());
                    return false;
                }
            }
        }

    }

    public static void setValueInSession(String key, Object value) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put(key, value);
    }

    public static Object getValueInSession(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getSessionMap().get(key);
    }

    public static void openModalBS(String modal) {
        try {
            ejecutarScript("$('#" + modal + "').modal('show');");
        } catch (Exception e) {
        }
    }

    public static void closeModalBS(String modal) {
        try {
            ejecutarScript("$('#" + modal + "').modal('hide');");
        } catch (Exception e) {
        }
    }

    public static <T> Object toUpperCaseStrings(Object object) {
        try {
            Class<?> objectClass = object.getClass();
            java.lang.reflect.Field[] declaredFields = objectClass.getDeclaredFields();

            for (java.lang.reflect.Field field : declaredFields) {

                if (field.getType().getSimpleName().equalsIgnoreCase("String")) {

                    field.setAccessible(true);
                    Object objectValue = field.get(object);

                    if (!field.getName().toLowerCase().contains("firma")
                            && !field.getName().toLowerCase().contains("matrizubicacionbase64")
                            && !field.getName().toLowerCase().contains("firmaclientebase64")
                            && !field.getName().equalsIgnoreCase("usuario")
                            && !field.getName().equalsIgnoreCase("clave")
                            && !field.getName().toLowerCase().contains("mail")
                            && !field.getName().toLowerCase().contains("correoequipo")
                            && !field.getName().toLowerCase().contains("url")) {

                        if (objectValue != null) {
                            String value = String.valueOf(field.get(object));
                            value = value.trim().toUpperCase();
                            field.set(object, value);
                        }
                    } else {

                        if (field.getName().toLowerCase().contains("mail")) {
                            if (objectValue != null) {
                                String value = String.valueOf(field.get(object));
                                value = value.trim().toLowerCase();
                                field.set(object, value);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Boolean comparePropertiesObject(Object object1, Object object2) {
        Boolean result = Boolean.TRUE;
        try {

            Class<?> objectClass = object1.getClass();
            java.lang.reflect.Field[] declaredFields = objectClass.getDeclaredFields();

            for (java.lang.reflect.Field field : declaredFields) {

                if (!field.getType().getSimpleName().equalsIgnoreCase("List")) {

                    if (!result) {
                        break;
                    }

                    field.setAccessible(true);

                    Object objectValue1 = field.get(object1);
                    Object objectValue2 = field.get(object2);

                    if (objectValue1 != null && objectValue2 != null) {
                        result = objectValue1.equals(objectValue2);
                        //System.out.println("Property().!null: " + field.getName() + " -> " + objectValue1 + " == " + objectValue2 + " " + (objectValue1.equals(objectValue2)));
                        continue;
                    }

                    if (objectValue1 != null && objectValue2 == null) {
                        result = objectValue1.equals(objectValue2);
                        //System.out.println("Property()1!null: " + field.getName() + " -> " + objectValue1 + " == " + objectValue2 + " " + (objectValue1.equals(objectValue2)));
                        continue;
                    }

                    if (objectValue1 == null && objectValue2 != null) {
                        result = objectValue2.equals(objectValue1);
                        // System.out.println("Property()2!null: " + field.getName() + " -> " + objectValue1 + " == " + objectValue2 + " " + (objectValue2.equals(objectValue1)));
                        continue;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void resetDataTable(String idDataTable) {
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(idDataTable);
        dataTable.reset();
    }

    public static String obtenerClassByPrioridad(Integer idPrioridad) {
        String result = "";

        if (AsignacionReparacionEnum.PRIORIDAD_DEFAULT.getValue().equals(idPrioridad)) {
            result = "label label-default";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_BAJA.getValue().equals(idPrioridad)) {
            result = "label label-success";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_NORMAL.getValue().equals(idPrioridad)) {
            result = "label label-warning";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_ALTA.getValue().equals(idPrioridad)) {
            result = "label label-danger";
        }
        return result;
    }

    public static String obtenerColorByPrioridad(Integer idPrioridad) {
        String result = "";

        if (AsignacionReparacionEnum.PRIORIDAD_DEFAULT.getValue().equals(idPrioridad)) {
            result = "#777";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_BAJA.getValue().equals(idPrioridad)) {
            result = "#5cb85c";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_NORMAL.getValue().equals(idPrioridad)) {
            result = "#f0ad4e";
        }
        if (AsignacionReparacionEnum.PRIORIDAD_ALTA.getValue().equals(idPrioridad)) {
            result = "#d9534f";
        }
        return result;
    }

    public static String obtenerNameByPrioridad(Integer idPrioridad) {
        String result = "";

        if (AsignacionReparacionEnum.PRIORIDAD_DEFAULT.getValue().equals(idPrioridad)) {
            result = AsignacionReparacionEnum.PRIORIDAD_DEFAULT.getPropertyName();
        }
        if (AsignacionReparacionEnum.PRIORIDAD_BAJA.getValue().equals(idPrioridad)) {
            result = AsignacionReparacionEnum.PRIORIDAD_BAJA.getPropertyName();
        }
        if (AsignacionReparacionEnum.PRIORIDAD_NORMAL.getValue().equals(idPrioridad)) {
            result = AsignacionReparacionEnum.PRIORIDAD_NORMAL.getPropertyName();
        }
        if (AsignacionReparacionEnum.PRIORIDAD_ALTA.getValue().equals(idPrioridad)) {
            result = AsignacionReparacionEnum.PRIORIDAD_ALTA.getPropertyName();
        }
        return result;
    }

    public static List<DetalleCatalogoReporte> listaDeRadioButton(DetalleCatalogoReporte catalogoReporte, List<DetalleCatalogoReporte> detalleCatalogoReportes) {
        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte detalleCatalogoReporte;

        for (DetalleCatalogoReporte object : detalleCatalogoReportes) {
            detalleCatalogoReporte = new DetalleCatalogoReporte();
            detalleCatalogoReporte = object;
            if (catalogoReporte.getDescripcion().equals(object.getDescripcion())) {
                detalleCatalogoReporte.setTipoRepuesto(object.getTipoRepuesto());
                detalleCatalogoReporte.setEstado(true);
                detalleCatalogoReporte.setSeleccion(true);
            }
            list.add(detalleCatalogoReporte);
        }
        return list;
    }

    public static List<DetalleCatalogoReporte> listaDeTextField(DetalleCatalogoReporte catalogoReporte, List<DetalleCatalogoReporte> detalleCatalogoReportes, Modelo modelo) {
        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte detalleCatalogoReporte;
        for (DetalleCatalogoReporte object : detalleCatalogoReportes) {
            detalleCatalogoReporte = new DetalleCatalogoReporte();
            detalleCatalogoReporte = object;
            if (catalogoReporte.getId().equals(object.getId())) {
                detalleCatalogoReporte.setCodigoRepuesto(object.getCodigoRepuesto());
                detalleCatalogoReporte.setEstado(true);
            }
            if (modelo.getId() != null) {
                detalleCatalogoReporte.setIdModelo(modelo.getId());
            }
            list.add(detalleCatalogoReporte);
        }
        return list;
    }

    public static List<DetalleCatalogoReporte> listaDeReset(DetalleCatalogoReporte catalogoReporte, List<DetalleCatalogoReporte> detalleCatalogoReportes) throws Exception {
        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte detalleCatalogoReporte;
        for (DetalleCatalogoReporte object : detalleCatalogoReportes) {
            detalleCatalogoReporte = new DetalleCatalogoReporte();
            detalleCatalogoReporte = object;
            if (catalogoReporte.getId() == object.getId()) {
                detalleCatalogoReporte.setCodigoRepuesto(null);
                detalleCatalogoReporte.setPorcentaje(null);
                detalleCatalogoReporte.setEstado(false);
                detalleCatalogoReporte.setSeleccion(Boolean.FALSE);
            }
            list.add(detalleCatalogoReporte);
        }
        return list;
    }

    public static List<DetalleCatalogoReporte> listaDeResetOtros(DetalleCatalogoReporte catalogoReporteSeleccionado, List<DetalleCatalogoReporte> detalleCatalogoReportes) {

        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte detalleCatalogoReporte;
        for (DetalleCatalogoReporte object : detalleCatalogoReportes) {
            detalleCatalogoReporte = new DetalleCatalogoReporte();
            detalleCatalogoReporte = object;

            if (Objects.nonNull(detalleCatalogoReporte.getProductoRepuestoReporte())) {

                if (detalleCatalogoReporte.getProductoRepuestoReporte().getId().intValue()
                        == catalogoReporteSeleccionado.getProductoRepuestoReporte().getId().intValue()) {
                    detalleCatalogoReporte = new DetalleCatalogoReporte();
                    detalleCatalogoReporte.setEstado(false);
                    detalleCatalogoReporte.setSeleccion(Boolean.FALSE);
                    detalleCatalogoReporte.setProductoRepuestoReporte(object.getProductoRepuestoReporte());
                    detalleCatalogoReporte.setDescripcion(null);
                    detalleCatalogoReporte.setTipoRepuesto(null);
                    detalleCatalogoReporte.setId(0);
                }
            }
            list.add(detalleCatalogoReporte);
        }

        return list;
    }

    public static List<DetalleCatalogoReporte> repuestosCodigoActualizado(List<DetalleCatalogoReporte> list,
            ProductoRepuestoReporte seleccion) {
        List<DetalleCatalogoReporte> catalogoReportes = new ArrayList<>();

        DetalleCatalogoReporte eliminarDetalleCatalogo = new DetalleCatalogoReporte(), agregar = new DetalleCatalogoReporte();

        for (DetalleCatalogoReporte detalleCatalogo : list) {
            if (detalleCatalogo.getId().intValue() == seleccion.getIdDetalleCatalogoReporte().getId().intValue()) {
                eliminarDetalleCatalogo = detalleCatalogo;
            }
            catalogoReportes.add(detalleCatalogo);
        }

        agregar.setTipoRepuesto(eliminarDetalleCatalogo.getTipoRepuesto());
        catalogoReportes.remove(eliminarDetalleCatalogo);
        agregar.setId(seleccion.getIdDetalleCatalogoReporte().getId());
        agregar.setDescripcion(seleccion.getIdDetalleCatalogoReporte().getDescripcion());
        agregar.setIdCabecera(new CabeceraCatalogoReporte());
        agregar.setIdCabecera(seleccion.getIdDetalleCatalogoReporte().getIdCabecera());
        agregar.setCodigoRepuesto(seleccion.getIdProducto().getCodigoFabricante());
        agregar.setSeleccion(seleccion.isSeleccion());
        agregar.setOrden(eliminarDetalleCatalogo.getOrden());
        agregar.setEstado(seleccion.getEstado());
        agregar.setIdReporteMantenimiento(eliminarDetalleCatalogo.getIdReporteMantenimiento());
        agregar.setProductoRepuestoReporte(seleccion);
        catalogoReportes.add(agregar);
        ordenar(catalogoReportes, DetalleCatalogoReporte.sortByOrden);

        return catalogoReportes;

    }

    private static void fillReport(String reportPath, Map<String, Object> parameters) throws JRException {
        jasperPrint = JasperFillManager.fillReport(reportPath, parameters, new JREmptyDataSource());

    }

    private static String getFullPath2(String reportPath) {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath(reportPath);
    }

    public static byte[] jasperBytes(Map<String, Object> parameters, String reportPath) {

        try {

            String pathh = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRealPath(reportPath);

            // String fullReportPath = getFullPath(reportPath);
            String fullReportPath = pathh;
            fillReport(fullReportPath, parameters);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            return baos.toByteArray();
        } catch (JRException e) {
            System.out.println("Error enviarMailPdf: " + e.getMessage());

        }
        return null;
    }

    public static boolean enviarMailPdf(ParametrosService parametrosService, String reportPath, Map<String, Object> parameters,
            String recipient, String subject, String nombreArchivo) {

        try {

            String fullReportPath = getFullPath(reportPath);
            fillReport(fullReportPath, parameters);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            return enviarMail(parametrosService, baos, recipient, subject, nombreArchivo);

        } catch (JRException e) {
            System.out.println("Error enviarMailPdf: " + e.getMessage());
            return false;
        }
    }

    public static List<DetalleCatalogoReporte> llenarRepuestosCorrectivos(List<DetalleCatalogoReporte> repuestos, ProductoClienteReporte productoClienteReporte) {
        DetalleCatalogoReporte detalleCatalogo;
        List<DetalleCatalogoReporte> list = new ArrayList<>();
        for (DetalleCatalogoReporte catalogoReporte : repuestos) {

            detalleCatalogo = new DetalleCatalogoReporte();
            detalleCatalogo = catalogoReporte;

            for (ReporteMantenimiento mantenimiento : productoClienteReporte.getReporteMantenimientoList()) {

                if (mantenimiento.getIdProductoRepuestoReporte() != null && mantenimiento.getIdDetalleCatalogoReporte() == null) {

                    if (mantenimiento.getIdProductoRepuestoReporte().getIdDetalleCatalogoReporte().getDescripcion().equals(catalogoReporte.getDescripcion())
                            && mantenimiento.getIdProductoRepuestoReporte().getIdDetalleCatalogoReporte().getIdCabecera().getCodigo().equals(catalogoReporte.getIdCabecera().getCodigo())
                            && mantenimiento.getEstado() == Boolean.TRUE) {

                        detalleCatalogo.setIdReporteMantenimiento(mantenimiento.getId());
                        detalleCatalogo.setId(mantenimiento.getIdProductoRepuestoReporte().getIdDetalleCatalogoReporte().getId());
                        detalleCatalogo.setTipoRepuesto(mantenimiento.getTipoRepuesto());
                        detalleCatalogo.setCodigoRepuesto(mantenimiento.getCodigoRepuesto());
                        // detalleCatalogo.setStock(mantenimiento.getIdProductoRepuestoReporte().getStock());
                        detalleCatalogo.setProductoRepuestoReporte(mantenimiento.getIdProductoRepuestoReporte());
                        detalleCatalogo.setIdProductoRepuestoReporte(mantenimiento.getIdProductoRepuestoReporte().getId());
                        detalleCatalogo.setSeleccion(true);
                        detalleCatalogo.setPorcentaje(mantenimiento.getPorcentaje());

                        break;
                    }
                }
            }
            list.add(detalleCatalogo);
        }
        return list;
    }

    public static List<DetalleCatalogoReporte> llenarRepuestosPreventivos(List<DetalleCatalogoReporte> repuestos, ProductoClienteReporte productoClienteReporte) {

        List<DetalleCatalogoReporte> list = new ArrayList<>();
        DetalleCatalogoReporte catalogo;

        for (DetalleCatalogoReporte catalogoReporte : repuestos) {
            catalogo = new DetalleCatalogoReporte();
            catalogo = catalogoReporte;
            for (ReporteMantenimiento mantenimiento : productoClienteReporte.getReporteMantenimientoList()) {
                if (mantenimiento.getIdProductoRepuestoReporte() == null && mantenimiento.getIdDetalleCatalogoReporte() != null) {

                    if (catalogoReporte.getId().intValue() == mantenimiento.getIdDetalleCatalogoReporte().getId().intValue() && mantenimiento.getEstado() == Boolean.TRUE) {
                        catalogo.setSeleccion(true);
                        catalogo.setIdReporteMantenimiento(mantenimiento.getId());
                        break;
                    }

                }
            }
            list.add(catalogo);
        }

        return list;
    }

    public static List<DetalleCatalogoReporte> llenarRepuestosOtros(List<DetalleCatalogoReporte> repuestos, ProductoClienteReporte productoClienteReporte, CabeceraCatalogoReporte cabeceraCatalogoReporte) {

        List<DetalleCatalogoReporte> listOtro = new ArrayList<>();
        DetalleCatalogoReporte otro;

        for (ReporteMantenimiento mantenimiento : productoClienteReporte.getReporteMantenimientoList()) {
            if (mantenimiento.getIdProductoRepuestoReporte() != null
                    && mantenimiento.getIdProductoRepuestoReporte().getIdDetalleCatalogoReporte().getIdCabecera().getCodigo().equals(cabeceraCatalogoReporte.getCodigo())
                    && mantenimiento.getEstado() == true) {
                otro = new DetalleCatalogoReporte();
                otro.setId(mantenimiento.getIdProductoRepuestoReporte().getIdDetalleCatalogoReporte().getId());
                otro.setCodigoRepuesto(mantenimiento.getCodigoRepuesto());
                otro.setTipoRepuesto(mantenimiento.getTipoRepuesto());
                otro.setDescripcion(mantenimiento.getIdProductoRepuestoReporte().getIdProducto().getIdCategoria().getNombre());
                otro.setEstado(mantenimiento.getEstado());
                otro.setIdCabecera(cabeceraCatalogoReporte);
                otro.setProductoRepuestoReporte(mantenimiento.getIdProductoRepuestoReporte());
                otro.setIdProductoRepuestoReporte(mantenimiento.getId());
                otro.setSeleccion(true);
                listOtro.add(otro);
            }
        }

        int tamanio = listOtro.size();
        List<DetalleCatalogoReporte> otros = listCorrectivoOtros(cabeceraCatalogoReporte);
        //   reporteBean.setListCorrectivoOtros(new ArrayList<>());

        List<DetalleCatalogoReporte> listaEliminar = new ArrayList<>();

        int c = 0;
        for (DetalleCatalogoReporte catalogoReporte : otros) {

            if (c < tamanio) {
                listaEliminar.add(catalogoReporte);
            }
            c++;
            //  reporteBean.getListCorrectivoOtros().add(catalogoReporte);
        }

        otros.removeAll(listaEliminar);
        listOtro.addAll(otros);

        return listOtro;
    }

    public static List<DetalleCatalogoReporte> noId(List<DetalleCatalogoReporte> listIn) {
        List<DetalleCatalogoReporte> listOut = new ArrayList<>();
        DetalleCatalogoReporte dcr;
        for (DetalleCatalogoReporte detalleCatalogoReporte : listIn) {
            dcr = new DetalleCatalogoReporte();
            dcr = detalleCatalogoReporte;
            dcr.setId(null);
            listOut.add(dcr);
        }
        return listOut;
    }

    public static boolean containsIdDetalle(List<DetalleCatalogoReporte> list, Integer id) {
        for (DetalleCatalogoReporte object : list) {
            if (object.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static <T> void ordenar(List<T> list, Comparator<? super T> c) {
        Collections.sort(list, c);
    }

    public static String getCurrentPage() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
        return pagina(servletRequest.getRequestURI());
    }

    public static String pagina(String fullPage) {
        String vect[] = fullPage.split("paginas");
        return vect[1];
    }

    public static String nombreArchivo(Reporte reporte) {
        try {
            String nombre = reporte.getTipo() + "_" + reporte.getSubtipo() + "_" + reporte.getIdUsuario().getCodigo() + "_" + formatoNumeroFactura(reporte.getNumerofactura());
            return nombre.toLowerCase();
        } catch (Exception e) {
            return "reporte";
        }
    }

    public static <T> SelectEvent selectevent(T t) {
        return new SelectEvent(FacesContext.getCurrentInstance().getViewRoot().findComponent("form"), new AjaxBehavior(), t);
    }

    public static String tituloAdministracion(String enums) {

        String titulo = " ";

        if (enums == null) {
            titulo = " ";
        }
        if (enums != null && enums.equals(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue())) {
            titulo = " ";
        }
        if (enums != null && enums.equals(Enums.TIPO_REPORTE_REPARACION.getValue())) {
            titulo = " ";
        }
        if (enums != null && enums.equals(Enums.TIPO_REPORTE_CONTADORES.getValue())) {
            titulo = " ";
        }
        if (enums != null && enums.equals(Enums.ADMINISTRACION_ETIQUETADORAS.getValue()) || enums.equals(Enums.TIPO_REPORTE_ETIQUETADORAS.getValue()) || enums.contains(Enums.TIPO_REPORTE_ETIQUETADORAS.getValue())) {
            titulo = "" + Enums.ADMINISTRACION_ETIQUETADORAS.getPropertyName();
        }
        if (enums != null && enums.equals(Enums.ADMINISTRACION_TRITURADORES.getValue()) || enums.equals(Enums.TIPO_REPORTE_TRITURADORAS.getValue()) || enums.contains(Enums.TIPO_REPORTE_TRITURADORAS.getValue())) {
            titulo = Enums.ADMINISTRACION_TRITURADORES.getPropertyName();
        }
        if (enums != null && enums.equals(Enums.ADMINISTRACION_SCANNERS.getValue()) || enums.equals(Enums.TIPO_REPORTE_SCANNERS.getValue()) || enums.contains(Enums.TIPO_REPORTE_SCANNERS.getValue())) {
            titulo = Enums.ADMINISTRACION_SCANNERS.getPropertyName();
        }
        if (enums != null && enums.equals(Enums.ADMINISTRACION_MONITORES.getValue()) || enums.equals(Enums.TIPO_REPORTE_MONITORES.getValue()) || enums.contains(Enums.TIPO_REPORTE_MONITORES.getValue())) {
            titulo = Enums.ADMINISTRACION_MONITORES.getPropertyName();
        }
        if (enums != null && enums.equals(Enums.ADMINISTRACION_MONITORES.getValue()) || enums.equals(Enums.TIPO_REPORTE_MONITORES.getValue()) || enums.contains(Enums.TIPO_REPORTE_MONITORES.getValue())) {
            titulo = Enums.ADMINISTRACION_MONITORES.getPropertyName();
        }
        if (enums != null && enums.equals(Enums.ECU911_ADMINISTRACION.getValue()) || enums.equals(Enums.TIPO_REPORTE_ECU.getValue()) || enums.contains(Enums.TIPO_REPORTE_ECU.getValue())) {
            titulo = Enums.TIPO_REPORTE_ECU.getPropertyName();
        }

        titulo = titulo.toLowerCase();
        titulo = titulo.substring(0, 1).toUpperCase() + titulo.substring(1);
        return titulo;
    }

    public static void ejecutarScript(String script) {
        try {

            RequestContext.getCurrentInstance()
                    .execute(script);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Date convertirToDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public static List<Producto> toProducto(List<ProductoRepuestoReporte> list) {

        return list.stream()
                .map(p -> p.getIdProducto())
                .collect(Collectors.toList());

    }

    public static String NumeroToString(Object numero) {
        String result = "";
        if (numero != null) {
            result = numero.toString();
        }
        return result;
    }

    public static String BooleanToXMarkString(Boolean value) {
        String result = "";
        if (value != null) {
            result = value ? "X" : "";
        }
        return result;
    }

    public void ejecutarJs(String funcion) {
        RequestContext.getCurrentInstance().execute(funcion);
    }

    @SuppressWarnings("unchecked")
    public static <T> T obtenerController(String nombre) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + nombre + "}", Object.class);
    }

    public static boolean esInvitadoConCliente(Usuarios usuarios) {

        boolean niben = usuarios.getUsuarioRolesList().stream().anyMatch((ur) -> (ur.getIdRol().getRol().equalsIgnoreCase(Enums.ROLE_INVITADO.getValue())));
        return niben && (usuarios.getIdCliente() != null);
    }

    public static boolean esInvitado(RolService rolService, List<Integer> roles) {
        Rol rol;
        for (Integer id : roles) {
            rol = new Rol();
            rol = rolService.getById(id);
            if (rol.getRol().equalsIgnoreCase(Enums.ROLE_INVITADO.getValue())) {
                return true;
            }
            break;
        }
        return false;
    }

    public static Map<String, String> getSubTiposReporte() {

        Map<String, String> subtipo = new HashMap<>();
        subtipo.put(Enums.TIPO_REPORTE_DIAGNOSTICO.getValue(), Enums.TIPO_REPORTE_DIAGNOSTICO.getValue());
        subtipo.put(Enums.PREVENTIVO.getValue(), Enums.PREVENTIVO.getValue());
        subtipo.put(Enums.CORRECTIVO.getValue(), Enums.CORRECTIVO.getValue());

        return subtipo;
    }

    public static String enlaceNuevoUsuario(String usuario, String clave, ParametrosService parametrosService) {
        String enlace = parametrosService.getByParametro("ENLACE_APP").getValor();
        String parametros = "?q=" + clave;

        enlace = enlace + "paginas/usuarios/usuarioInvitado.jsf";
        enlace = "  <a href=\"" + enlace + "\"> Enlace </a>";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table border=\"1\"> <tbody>").
                append("<tr><td>Enlace :   </td><td>").append(enlace).append("</td></tr>").
                append("<tr><td>Usuario :   </td><td>").append(usuario).append("</td></tr>").
                append("<tr><td>Clave :   </td><td>").append(clave).append("</td></tr>").
                append("</tbody></table>");

        return stringBuilder.toString();
    }

    public static HttpHeaders headers() {
        HttpHeaders hd = new HttpHeaders();
        hd.add("Access-Control-Allow-Origin", "*");
        hd.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        hd.add("Access-Control-Allow-Credentials", "true");

        hd.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEADs");
        hd.add("Content-Type", "application/json; charset=UTF-8");

        return hd;
    }

}
