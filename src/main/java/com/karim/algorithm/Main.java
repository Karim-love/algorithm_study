package com.karim.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i=0; i<count; i++){
                String input = bufferedReader.readLine();
                int plus=0;
                int score=0;
                int j = 0;
                while (true){
                    if (input.charAt(j) == 'O'){
                        plus++;
                        score = score + plus;
                    }else {
                        plus = 0;
                    }
                    j++;
                    if (j == input.length()){
                        break;
                    }
                }
                bufferedWriter.write( score + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
