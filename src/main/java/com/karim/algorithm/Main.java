package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            int a = Integer.parseInt(bufferedReader.readLine());

            for (int i=1; i < a+1; i++){
                String b = bufferedReader.readLine();
                int blank = b.indexOf(" ");

                int c = Integer.parseInt(b.substring(0,blank));
                int d = Integer.parseInt(b.substring(blank+1));

                bufferedWriter.write(c+d+"\n");
            }

            bufferedWriter.flush();

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
