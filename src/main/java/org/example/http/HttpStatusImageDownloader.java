package org.example.http;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {

    private final HttpStatusChecker checker;

    public HttpStatusImageDownloader() {
        this.checker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws Exception {
        String url = checker.getStatusImage(code);
        String filename = url.substring(url.lastIndexOf("/") + 1);
        Path path = Paths.get(filename);

        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, path);
        }
    }
}