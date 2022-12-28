package com.karim.algorithm.programmers;

import java.util.*;

public class Level1 {

    /**
     * NOTE : 크기가 작은 부분문자열
     * COMMAND : Integer.parseInt 는 런타임 에러나는데 Long.parseLong 이건 왜 안날까..
     */
    private int method1( String t, String p ){
        int answer = 0;
        t = "10203";
        p = "15";
        long pp = Long.parseLong(p);
        int pSize = p.length();

        for ( int i = 0; i <= t.length() - pSize; i++ ) {

            if (Long.parseLong(t.substring(i, i + pSize )) <= pp) {

                answer++;
            }
        }

        return answer;
    }

    /**
     * NOTE : 가장 가까운 같은 글자
     * COMMAND :
     */
    private int[] method2( String s ){
        s = "banana";

        String[] arr = new String[ s.length() ];
        int[] answer = new int[ s.length() ];

        for ( int i = 0; i < s.length(); i++) {

            String find = String.valueOf(s.charAt(i));

            if ( !Arrays.asList(arr).contains( find ) ){ // 없으면 -1

                answer[i] = -1;
                arr[i] = find;
            }else {

                int findCount = Arrays.asList( arr ).lastIndexOf( find );
                answer[i] = i - findCount;
                arr[i] = find;
            }
        }

        return answer;
    }

    /**
     * NOTE : 문자열 나누기
     * COMMAND :
     */
    public int method3( String s ){
        int answer = 0;

        char first = s.charAt(0);
        int countA = 0;
        int countB = 0;
        for ( int i = 0 ; i <  s.length(); i++ ){

            // 현재 값이랑 해당 값이 같은 경우 (처음은 무조건 같음)
            if ( first == s.charAt(i) ){

                countA ++; // 현재 값 카운트 ++
            }else {

                countB++; // 다른 경우우
            }

            // 현재 값 카운트 값이랑 다음 단어 카운트 값이 같거나 마지막이면 ++
            if ( countA == countB || i == s.length() -1 ){

                answer++;
                countA = 0;
                countB = 0; //초기화

                if ( i != s.length() -1 ){ // 해당 인덱스가 마지막이 아니면
                    first = s.charAt(i+1); // 비교 값을 해당 i 값으로 바꾼다
                }
            }
        }

        return answer;
    }

    /**
     * NOTE : 명예의 전당 (1)
     * COMMAND :
     */
    public int[] method4( int k, int[] score ) {

        int scoreLength = score.length;
        int[] answer = new int[ scoreLength ];
        List<Integer> room = new ArrayList<>();

        for( int i = 0; i< scoreLength; i++ ){

            room.add( score[i] );
            Collections.sort( room ); //정렬

            if ( k <= i ){

                room.remove(0);
            }

            answer[i] = room.get(0);
        }

        return answer;
    }

    /**
     * NOTE : 기사단원의 무기
     * COMMAND : 시간 초과가 제일 무섭다...
     * TIP : Math.sqrt( n ) n의 제곱근 ex ) Math.sqrt( 25 ) = 5
     * TIP : 약수는 제곱근을 제외한 나머지는 대칭을 이룬다! ( 시간 초과를 위해 외워두자 )
     */
    public int method5( int number, int limit, int power ) {

        int answer = 0;

        for ( int i = 1; i <= number ; i++ ){

            int count = 0;
            for ( int j = 1; j <= Math.sqrt( i ) ; j++ ){ // 제곱근

                if ( i % j == 0 ){ // 약수 이면

                    if ( i / j == j ){ // 해당 값의 제곱근 이면 한번만 카운트

                        count++;
                    }else { // 

                        count+=2;
                    }
                }
            }

            if ( count > limit ){ // 제한수치를 넘을 경우 정한 공격력으로 더하기

                answer += power;
            }else {

                answer += count; // 아닐경우 그냥 더하기
            }
        }

        return answer;

    }

    /**
     * NOTE : 과일 장수
     * COMMAND :
     * TIP :
     */
    public int method6( int k, int m, int[] score ) {

        int answer = 0;

        return answer;
    }
}
