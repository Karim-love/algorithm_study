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

}
