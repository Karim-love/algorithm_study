package com.karim.algorithm.baekJoon.picks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PartOne {
    /**
     * NOTE : 2501 약수 구하기
     * COMMAND : 백준 오랜만인가 보다 ㅜㅜ import까지 넣어야 한다는 걸 잊고 있었다니!!!
     */
    public void getDivisor(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        try {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            List<Integer> list = new ArrayList<>();
            int result;

            for ( int i = 1; i <= a + 1; i++ ){

                if ( a % i == 0 ){

                    list.add( i );
                }
            }

            if ( list.size() >= b ){

                result = list.get( b - 1 );
            }else {

                result = 0;
            }

            bufferedWriter.write(result + "\n");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NOTE : 3460 이진수
     * COMMAND : 나는 디버깅이 좋아
     */
    public void getBinaryNumber(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

            int count = Integer.parseInt(bufferedReader.readLine());

            for ( int i = 0; i < count; i++ ){

                int a = Integer.parseInt(bufferedReader.readLine());
                List<Integer> resultList = new ArrayList<>();
                StringBuilder result = new StringBuilder();

                // if 13 이면 1 0 1 1 로 이진수와 반대로 list에 들어감
                while ( true ){

                    resultList.add( a % 2 );

                    a = a / 2;

                    if ( a < 1 ){
                        break;
                    }
                }

                for (int k = 0; k < resultList.size(); k ++ ){

                    if ( resultList.get( k ) == 1 ) {
                        result.append(k).append(" ");
                    }
                }
                bufferedWriter.write( result.substring( 0, result.length()-1 ) + "\n");
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
