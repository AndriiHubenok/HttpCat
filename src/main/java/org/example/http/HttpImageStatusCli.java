package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {

    private final HttpStatusImageDownloader downloader;
    private final Scanner scanner;

    public HttpImageStatusCli() {
        this.downloader = new HttpStatusImageDownloader();
        this.scanner = new Scanner(System.in);
    }

    public void askStatus() {
        System.out.print("Enter HTTP status code: ");
        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            downloader.downloadStatusImage(code);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
