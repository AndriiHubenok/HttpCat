package org.example.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws Exception {
        URL url = new URL(BASE_URL + code + ".jpg");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode != 404) {
            return url.toString();
        } else {
            throw new Exception("Image " + code + " not found");
        }
    }
}

