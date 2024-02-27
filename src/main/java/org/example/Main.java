package org.example;

import org.example.http.HttpImageStatusCli;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}