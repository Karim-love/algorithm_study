package com.karim.algorithm.baekJoon;

/**
 * Created by sblim
 * Date : 2021-12-24
 * Time : 오전 11:28
 */

import java.util.Scanner;

/**
 * NOTE : 입출력과 사칙연산
 */
public class Step1 {

    /**
     * NOTE : Hello World!를 화면에 출력하는 문제 (예제 출력과 똑같이 출력해야 합니다.)
     */
    public void helloWorld(){
        System.out.println("Hello World!");
    }

    /**
     * NOTE : 주어진 예제처럼 출력하는 문제 2
     */
    public void weLoveKriii(){
        System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");
    }

    /**
     * NOTE : 주어진 예제처럼 출력하는 문제 3
     */
    public void drawCat(){
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }

    /**
     * NOTE : 주어진 예제처럼 출력하는 문제 4
     */
    public void drawDog(){
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }

    /**
     * NOTE : 두 수를 입력받고 합을 출력하는 문제
     */
    public void plusAB(){
        int a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        scan.close();

        System.out.println(a+b);
    }

    /**
     * NOTE : 두 수를 입력받고 뺄셈을 한 결과를 출력하는 문제
     */
    public void subAB(){
        int a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        scan.close();

        System.out.println(a-b);
    }

    /**
     * NOTE : 곱셈 문제
     */
    public void multiAB(){
        int a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        scan.close();

        System.out.println(a*b);
    }

    /**
     * NOTE : 나눗셈 문제. 이 문제에는 "스페셜 저지" 표시가 붙어 있는데, 이것은 예제 출력과 꼭 똑같이 출력할 필요는 없고 조건에 맞는 답을 출력하면 된다는 뜻입니다.
     */
    public void divAB(){
        double a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        scan.close();

        System.out.println(a/b);
    }


    /**
     * NOTE : 모든연산
     */
    public void operateAB(){
        int a, b;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();

        scan.close();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }

    /**
     * NOTE : 네 개의 계산식을 계산하는 문제. 이 문제를 푼 다음에는 직접 입력을 만들어서 넣어 봅시다. 어떤 사실을 관찰할 수 있나요?
     */
    public void remainAB(){
        int a, b, c;
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        scan.close();

        System.out.println((a+b)%c);
        System.out.println((a%c + b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c * b%c)%c);
    }

    /**
     * NOTE : 빈 칸에 들어갈 수는?
     * **************************
     * char 값에서 -'0'을 해주면
     * 굳이 `char -> string -> int` 과정 없이
     * char 형태를 숫자형으로 쓸 수 있다 !!!
     * () 가로 필수 !!
     */
    public void div3AB(){
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
