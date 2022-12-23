package com.karim.algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}