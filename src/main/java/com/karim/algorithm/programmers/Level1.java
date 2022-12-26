package com.karim.algorithm.programmers;

import java.util.Arrays;

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

}
