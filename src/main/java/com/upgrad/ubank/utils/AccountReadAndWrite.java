package com.upgrad.ubank.utils;

import com.upgrad.ubank.dtos.Account;

import java.io.*;

public class AccountReadAndWrite {

    public static void write () {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\projects\\U-Bank\\U-Bank\\src\\main\\java\\com\\upgrad\\ubank\\utils\\file.txt"))) {
            bw.write("1234, ishwar, 1000"); bw.newLine();
            bw.write("1235, srishti, 1000"); bw.newLine();
            bw.write("1236, akash, 1000"); bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read () {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\projects\\U-Bank\\U-Bank\\src\\main\\java\\com\\upgrad\\ubank\\utils\\file.txt"))) {
            String line = null;
            while ((line=br.readLine()) != null) {
                String[] tokens = line.split(", ");
                if (tokens.length != 3) {
                    break;
                }
                Account account = new Account(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
                System.out.println(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}
