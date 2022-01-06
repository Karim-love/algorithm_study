package com.karim.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            //첫 번째 줄 입력
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int count = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());

            //두 번째 줄 입력
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int i=0; i<count; i++){
                int output = Integer.parseInt(stringTokenizer.nextToken());
                if (output < x){
                    bufferedWriter.write(output+" ");
                }
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
