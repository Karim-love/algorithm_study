package com.karim.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        b = b - 45;
        if (b < 0){
            b = 60 + b;
            a = a - 1;
            if (a < 0){
                a = 23;
            }
        }

        System.out.println(a + " " + b);
    }
}
