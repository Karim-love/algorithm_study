package com.karim.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a;
        String b;
        int firstLine = 0, secondLine = 0, thirdLine = 0, result = 0;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.next();

        if (a > 99 && b.length() > 2 ){
            firstLine = a * Integer.parseInt(String.valueOf(b.charAt(2)));
            secondLine = a * (b.charAt(1) -'0');
            thirdLine =  a * (b.charAt(0) -'0');

            result = a *  Integer.parseInt(b);
        } else {
            System.out.println("a , b 둘 다 3자리를 써주세요");
        }

        scan.close();

        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(result);
    }
}
