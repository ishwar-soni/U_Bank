package com.upgrad.ubank.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void log (String message) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String timeStamp = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        String root = System.getProperty("catalina.base");
        String path = "\\..\\..\\src\\main\\java\\com\\upgrad\\ubank\\logs\\";
        String fileName = "logs " + date + ".log";
        String filePath = root + path + fileName;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(timeStamp + "\t" + message);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
