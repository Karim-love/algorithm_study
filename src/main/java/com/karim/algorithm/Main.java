package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(bufferedReader.readLine());

            for (int i=1; i<=n; i++){

            }

            bufferedWriter.write( "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}