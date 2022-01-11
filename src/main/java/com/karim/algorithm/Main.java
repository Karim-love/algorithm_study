package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int input = Integer.parseInt(bufferedReader.readLine());

            bufferedWriter.write(arithmeticSequenceCount(input) + "\n");
            bufferedWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int arithmeticSequenceCount(int number){
        int count = 0;

        if (number < 100){
            count = number;
        }else {
            count = 99;
            for (int i=100; i<=number; i++){
                String tmp = String.valueOf(i);
                int a = tmp.charAt(0)-'0';
                int b = tmp.charAt(1)-'0';
                int c = tmp.charAt(2)-'0';
                if ((b-a)==(c-b)){
                    count++;
                }
            }
        }
        return count;
    }
}
