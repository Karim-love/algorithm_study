package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int a = Integer.parseInt(bufferedReader.readLine());
            int copy = a;
            int cycleCount = 0;
            while (true){
                a = (a % 10)*10 + (((a / 10) + (a % 10)) > 9 ? (((a / 10) + (a % 10)) % 10) : ((a / 10) + (a % 10)));

                cycleCount++;
                if (copy == a){
                    bufferedWriter.write(cycleCount + "\n");
                    break;
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
