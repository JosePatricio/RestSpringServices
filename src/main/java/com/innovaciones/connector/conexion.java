/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.connector;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author pisama
 */
@ManagedBean
@ViewScoped
public class conexion implements Serializable{

    private String mensaje;

    private String url;
    private String user;
    private String password;

    private String destino;
    private String texto;

    /**
     * Creates a new instance of conexion
     */
    public void boton() {

        cone();
    }

    public conexion() {

    }

    void cone() {
        try {//  "jdbc:mysql://192.168.0.237:3306/reportes", "root", "Innovaciones2014");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    url, user, password);
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            String usuarios = "";
            while (rs.next()) {
                usuarios += rs.getString(2) + ", ";
            }

            mensaje = usuarios;
            con.close();
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(e);
        }
    }

    private static Session getSessionEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.live.com");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", 587);
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("correoinnovaciones@outlook.com", "contrase;a");
            }
        });
        return session;
    }

    public  void enviarMail( ) {

        try {
            //     byte[] bytes = archivo.toByteArray();
            // DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf"); 
            //  MimeBodyPart pdfBodyPart = new MimeBodyPart();
            //pdfBodyPart.setDataHandler(new DataHandler(dataSource)); 
            //pdfBodyPart.setFileName("reporte.pdf");

            InternetAddress iaSender = new InternetAddress("correoinnovaciones@outlook.com");

            MimeMessage mimeMessage = new MimeMessage(getSessionEmail());
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(getTexto());
            mimeMessage.setRecipients(Message.RecipientType.TO, convertRecipientsAddress(getDestino()));
            //InternetAddress iaRecipient = new InternetAddress(recipient);

            String cid = String.valueOf((new Date()).getTime());
            StringBuilder textEmail = new StringBuilder();
            /*  textEmail.append(getHeaderEmail(cid, "Nuevo Reporte Creado"));
            textEmail.append(footerMail());
             */
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(textEmail.toString(), "UTF-8", "html");

            MimeMultipart contentMultipart = new MimeMultipart("related");
            contentMultipart.addBodyPart(textPart);
            // contentMultipart.addBodyPart(putLogoInsideEmail(cid));
            //contentMultipart.addBodyPart(pdfBodyPart);
            mimeMessage.setContent(contentMultipart);
            Transport.send(mimeMessage);

        } catch (Exception ex) {
            System.out.println("Error enviarMail: " + ex.getMessage());
        } 
        

    }

    private static InternetAddress[] convertRecipientsAddress(String recipients) {
        String[] recipientList = recipients.split(";");
        InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
        try {
            int counter = 0;
            for (String recipient : recipientList) {

                if (!recipient.trim().isEmpty()) {
                    System.out.println("com.innovaciones.reporte.util.Utilities.convertRecipientsAddress(): " + recipient);
                    recipientAddress[counter] = new InternetAddress(recipient.trim());
                }
                counter++;
            }
        } catch (Exception e) {
            System.out.println("No se pudo convertir los destinatarios de emails: " + e.getMessage());
        }
        return recipientAddress;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
