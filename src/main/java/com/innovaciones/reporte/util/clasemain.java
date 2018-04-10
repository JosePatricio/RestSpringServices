/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovaciones.reporte.model.AsignacionReparacion;
import com.innovaciones.reporte.model.Cliente;
import com.innovaciones.reporte.model.ClienteSucursal;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.model.TipoVisita;
import com.innovaciones.reporte.model.Usuarios;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
import com.opensymphony.xwork2.Action;

import edocs.actions.PublicAction;*/
import net.sf.json.JSONObject;

public class clasemain {

    private static final long serialVersionUID = -8022560668279505764L;

    // Method to send Notifications from server to client end.
    public final static String AUTH_KEY_FCM = "AAAAnycIlKw:APA91bHgHpIdHujMG8RtQJmXWMFexPNJXRqRvlZzBM4hZB8_Ki8YJ-yI2R1PD-Uwpqo9kOIv7ioK8x_O9pSVg4NmNFchnaYBhr3_KUPe-QqyoVEvQEgkF2PKtlSbPQttrFSLvqk5mZzD";

    public static void main(String[] args) throws Exception {

        for (int i = 1; i < 3; i++) {
            AsignacionReparacion reparacion = new AsignacionReparacion();
            reparacion.setId(i);

            Usuarios usuario = new Usuarios();
            usuario.setUsuario("patrico user");
            usuario.setNombre("Jose Patricio");
            usuario.setApellido("Isama Penia");
            usuario.setId(23);

            Producto producto = new Producto();

            producto.setId(99);
            producto.setDescripcionCompra("Producto a PROCESAR");

            Cliente cliente = new Cliente();
            cliente.setId(5351);
            cliente.setCliente("CLIENTE MEGA SANTMARIA DESDE SERVER");
            cliente.setEmail("AFINE.COM!!! ");

            ClienteSucursal clienteSucursal = new ClienteSucursal();
            clienteSucursal.setId(25);
            clienteSucursal.setCiudad("KITU !");

            clienteSucursal.setIdCliente(cliente);

            reparacion.setProducto(producto);
            reparacion.setIdClienteSucursal(clienteSucursal);
            reparacion.setIdUsuarioAtencion(usuario);

            reparacion.setIdTipoVisita(new TipoVisita(2));
            reparacion.setObservacion("observaiocne prueba " + i);

            //  System.out.println("ENTIDAD  == " + reparacion);
            enviarNotificacion(reparacion);
            System.out.println("                               ");
        }

    }

    public static <T> boolean enviarNotificacion(T objecto) throws JsonProcessingException, Exception {
        String FMCurl = "https://fcm.googleapis.com/fcm/send";
        ObjectMapper mapper = new ObjectMapper();
        String DEVICE_ID = new clasemain().idDeviceDatabase();
        String jsonNotification = mapper.writeValueAsString(objecto);
        
          System.out.println("DISPOSITIVO " + DEVICE_ID);
            System.out.println("AUTH_KEY_FCM " + AUTH_KEY_FCM);
            
        System.out.println("JSONPARSED " + jsonNotification);
        try {
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject data = new JSONObject();
            data.put("to", DEVICE_ID.trim());
            JSONObject info = new JSONObject();
            info.put("jsonNotification", jsonNotification); // Notification body

            data.put("data", info);
            // System.out.println(data.toString());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString());
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            // System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // System.out.println("Response: " + response); // <= ADD THIS

            mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.toString());
            String valor = root.path("success").asText().trim();

            return ("1".equals(valor));

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String idDeviceDatabase() throws Exception {
        String valor = "";
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://192.168.0.31:3306/reportes_v2?"
                            + "user=root&password=Innovaciones2014.");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from parametros where parametro='DEVICE_ID_FIREBASE'");
            while (resultSet.next()) {

                valor = resultSet.getString("valor");

            }

            return valor;

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }

    }

}
