/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.util;

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

    public final static String DEVICE_ID = "f6bAZAXN6U0:APA91bHdMU2cvkB3I--wHD0WlDcSL6wB-RUwbb5uHL1oYGrY0sYc0QSaugbH4hnaCqWgvyAES9k_zOCREWoXov7T5KeJ4ktVqclywRtOEkjBqrqJK6BP-PPH5jZcmMnqUrGu6_W-AnjX";

    public static void main(String[] args) throws Exception {
        String title = "Notificación";
        String message = "Mensa de notifiaccion # ";

        for (int i = 1; i < 3; i++) {
            new clasemain().sendFirebaseNotification(i, AUTH_KEY_FCM, DEVICE_ID, title, (" (" + i + ") - " + message + i));
            System.out.println("MENSAJE " + i + "  ENVIADO ");
        }

    }

    public String sendFirebaseNotification(int id, String authKey, String DeviceIdKey, String title, String message) {

        String FMCurl = "https://fcm.googleapis.com/fcm/send";

        try {
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + authKey);
            conn.setRequestProperty("Content-Type", "application/json");
            System.out.println(DeviceIdKey);
            JSONObject data = new JSONObject();
            data.put("to", DeviceIdKey.trim());
            JSONObject info = new JSONObject();
            info.put("title", title); // Notification title
            info.put("message", message); // Notification body
            info.put("id", "" + id); // Notification title
            data.put("data", info);
            System.out.println(data.toString());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString());
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Resonse: " + response); // <= ADD THIS
            return "TRUE";
        } catch (Exception e) {
            System.out.println(e);
        }

        return "TRUE";
    }
}
