package com.karim.algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Level1_1_15 {

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
     * COMMAND : 문제 이해가 어려웠당
     * TIP :
     */
    public int method6( int k, int m, int[] score ) {

        int answer = 0;

        // 내림 차순 정렬
        Integer[] reverseScore = Arrays.stream( score ).boxed().toArray(Integer[]::new);
        Arrays.sort( reverseScore, Collections.reverseOrder() );

        for ( int i = m-1; i < reverseScore.length; i+=m ) { // 한 상자에 담긴 사과 개수 만큼 증가

            if (reverseScore[i] > k) { // 만약 점수가 최대 점수 k 보다 크면 k로 바꿔준다.

                reverseScore[i] = k;
            }

            // 최저 점수 * 한 상자에 담긴 사과 개수
            answer += ( reverseScore[i] * m );
        }

        return answer;
    }

    /**
     * NOTE : 푸드 파이트 대회
     * COMMAND :
     * TIP :
     */
    public String method7( int[] food ) {
        String answer = "";

        Deque<Integer> deque = new ArrayDeque<>();

        // 처음에 물을 넣는다
        deque.add( 0 );

        for ( int i = food.length -1 ; i > 0; i-- ){ // 작은 숫자 부터 먹을려면, 큰 숫자 부터 넣어야 하니깐 배열 크기 부터

            // 몫 값으로 넣는다 ( 나머지는 버려질 음식, 0 이면 넣지 않는다.)
            for ( int j = 0; j < food[i] / 2; j++ ) { // 나눈 갯수 만큼 넣기

                deque.addFirst( i );
                deque.addLast( i );
            }
        }

        for (Integer integer : deque) {

            answer += integer;
        }

        return answer;
    }

    /**
     * NOTE : 푸드 햄버거 만들기 대회
     * COMMAND : 처음에는 문자열로 풀다가 시간 초과 때매 집중하다 stack 으로 품...
     * TIP :
     */
    public int method8( int[] ingredient ) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < ingredient.length; i++ ){

            stack.push( ingredient[i] );

            if (  stack.size() > 3 ){ // 넣은 스텍 사이즈가 4 이상일 경우부터 체크

                int stackSize = stack.size();
                // 마지막 스텍 인덱스 부터 확인
                if ( stack.get( stackSize - 1 )  == 1 &&
                        stack.get( stackSize - 2 ) == 3  &&
                        stack.get( stackSize - 3 ) == 2  &&
                        stack.get( stackSize - 4 ) == 1 ){

                    // 다 맞으면 꺼냄
                    int j = 0;
                    while (j < 4){

                        stack.pop();
                        j ++;
                    }

                    // 햄버거 완성이니 count 올림
                    answer ++;

                }
            }
        }
        return answer;
    }

    /**
     * NOTE : 옹알이 (2)
     * COMMAND : 반례가 너무 많았다..
     * TIP :
     */
    public int method9( String[] babbling ) {
        int answer = 0;

        String[] matches = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) { //ayaye
            String signal = " ";

            int flag = 0;
            while ( true ){
                for ( int i = 0; i< 4; i++ ){

                    if ( s.startsWith( matches[i] ) ){

                        if ( signal.charAt( signal.length() - 1 ) == (char)(i +'0') ){ // 이전에 동일 값인지 체크

                            flag ++;
                        }else {

                            s = s.replaceFirst(matches[ i ], ""); // 처음 껏만 지우기
                            signal += i; // 해당 값 시그널에 넣기
                        }
                    }else {

                        flag ++;
                    }
                }

                if ( flag > 3){

                    break;
                }

                if ( s.length() == 0){

                    answer++;
                    break;
                }

                flag = 0; // 초기화
            }
        }

        return answer;
    }

    /**
     * NOTE : 콜라 문제
     * COMMAND :
     * TIP :
     */
    public int method10(int a, int b, int n) {
        int answer = 0;

        int mod = 0;
        while ( true ){

            mod = n % a;
            n = ( ( n / a ) * b );
            answer += n;
            n += mod; // 다음 계산을 위해 나머지 더하기

            if ( n < a ){

                break;
            }
        }

        return answer;
    }

    /**
     * NOTE : 삼총사
     * COMMAND :
     * TIP :
     */
    public int method11( int[] number ) {
        int answer = 0;

        for ( int i = 0; i < number.length; i++ ){

            for ( int j = 0; j <number.length; j++){

                if (i < j){ // 같은건 빼고 ( j 가 더 커야함 )

                    for ( int k = 0; k < number.length; k++ ){

                        if (i != k && j < k){ // 다 같은건 빼고 ( k가 더 커야함 )

                            if ( number[i] + number[j] + number[k] == 0 ){

                                answer++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    /**
     * NOTE : 숫자 짝꿍
     * COMMAND : 시간 초과... 터무니 없었다
     * TIP : 이중 for문 보단 숫자는 0부터 9까지니 그거에 갯수로 구하는게 시간 초과가 안난다..
     */
    public String method12( String X, String Y ) {
        StringBuffer answer = new StringBuffer();
        String[] x = X.split("");
        String[] y = Y.split("");
        int[] count = new int[10];
        int[] count2 = new int[10];
        List<Integer> a = new ArrayList<>();

        for ( int i = 0; i < 10; i ++ ){

            for (String s : x) {

                if ( Integer.toString(i).equals(s)){
                    count[i]++;
                }
            }
        }

        for ( int i = 0; i < 10; i ++ ){

            for (String s : y) {

                if ( Integer.toString(i).equals(s)){
                    count2[i]++;
                }
            }
        }

        for ( int i = 0; i < 10; i ++ ){

            if ( count[i] > 0 && count[i] > 0 ){ // 카운트가 둘 다 0보다 크면 있다는거니

                if ( count[i] > count2[i] ){

                    for ( int j = 0; j < count2[i]; j++){
                        a.add(i);
                    }
                }else {

                    for ( int j = 0; j < count[i]; j++){
                        a.add(i);
                    }
                }
            }
        }

        a.sort(Collections.reverseOrder());

        for (Integer integer : a) {
            answer.append(integer);
        }

        return a.size() == 0 ? "-1" : a.get(0) == 0 ?  "0" : answer.toString();
    }

    /**
     * NOTE : 성격 유형 검사하기
     * COMMAND : 간단한데 더럽당...
     * TIP :
     */
    public String method13(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] a;
        String[] initMbti = {"R","T","C","F","J","M","A","N"};
        Map< String, Integer > countMap = new HashMap<>();

        for (int i = 0; i < survey.length; i++ ){

            int checkFirst = 0; // 앞 mbti 에 점수를 매길 경우
            a = survey[i].split("");
            if ( choices[i] > 4 ){

                checkFirst = 1; // 뒤 mbti 에 점수를 매길 경우
            }

            if ( countMap.get( a[ checkFirst] ) != null ){

                countMap.put(  a[ checkFirst ], countMap.get( a[ checkFirst ] ) + getScore( choices[i] ) );
            }else {

                countMap.put(  a[ checkFirst ], getScore( choices[i] ) );
            }
        }

        // mbti 만들기
        for ( int i = 0; i < initMbti.length; i+=2 ){

            int k = countMap.get( initMbti[i + 1] ) == null ? 0 : countMap.get( initMbti[i + 1] );
            int g = countMap.get( initMbti[i] ) == null ? 0 : countMap.get( initMbti[i] );
            if ( k > g ){

                answer.append(initMbti[i + 1]);
            }else {

                answer.append(initMbti[i]);
            }
        }
        return answer.toString();
    }

    public int getScore( int choice ){
        int score = 0;
        if( choice == 1 || choice == 7 ){
            score = 3;
        }else if ( choice == 2 || choice == 6 ){
            score = 2;
        }else if ( choice == 3 || choice == 5 ){
            score = 1;
        }

        return score;
    }

    /**
     * NOTE : 신고 결과 받기
     * COMMAND :
     * TIP :
     */
    public int[] method14(String[] id_list, String[] report, int k) {
        int[] answer = new int[ id_list.length ];
        Map<String, List<String>> idListMap = new HashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        int count = 0;

        for (String s : report) {

            String[] ss = s.split(" ");
            count = 0; // 초기화

            List<String> checkList = idListMap.get( ss[0] );
            if ( checkList != null ){ // 해당 사용자가 두 번째 신고할 경우

                // 한 사람당 중복 없이 한 사람만 신고가 가능하니 이 부분 체크
                if ( !checkList.contains( ss[1] ) ){ // 없으면 넣고 카운트
                    
                    checkList.add( ss[1] );
                    idListMap.put( ss[0], checkList );
                    count = 1;
                }
            }else {
                // 처음 신고할 경우
                List< String > list = new ArrayList<>();
                list.add( ss[1] );
                idListMap.put( ss[0], list );
                count = 1;
            }

            // 신고 카운트
            if ( reportMap.get( ss[1] ) != null ){ // 이전 신고 기록 있을 때

                reportMap.put( ss[1], reportMap.get( ss[1] ) + count );
            }else { // 이전 신고 기록 없을 때

                reportMap.put( ss[1], count );
            }
        }

        // 확인
        for (int i = 0; i < id_list.length; i++ ) {

            // 해당에서 가져오고 들어있는 얘들이 카운트가 k보다 높으면 카운트
            if ( idListMap.get( id_list[i] ) != null ){

                for ( String check : idListMap.get( id_list[i] ) ){

                    if ( reportMap.get( check ) >= k ){

                        answer[i]++;
                    }
                }
            }else {

                answer[i] = 0;
            }
        }

        return answer;
    }

    /**
     * NOTE : 나머지가 1이 되는 수 찾기
     * COMMAND :
     * TIP :
     */
    public int method15(int n) {
        int answer = 0;

        for ( int i = 1; i <= n; i++ ){

            if ( n / i == 1 ){

                return i;
            }
        }
        return answer;
    }

    /**
     * NOTE : 최소직사각형
     * COMMAND :
     * TIP :
     */
    public int method16(int[][] sizes) {
        int answer = 1;
        int[] answerArray = {0,0}; //초기값
        int tmp = 0;

        for (int[] size : sizes) {

            // x보다 y가 클 경우 둘이 바꿔주기
            if ( size[0] < size[1] ){

                tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
            if ( size[0] > answerArray[0] ){

                answerArray[0] = size[0];
            }
            if ( size[1] > answerArray[1] ){

                answerArray[1] = size[1];
            }
        }

        for (int i : answerArray) {

            answer = answer * i;
        }

        return answer;
    }

    /**
     * NOTE : 없는 숫자 더하기
     * COMMAND :
     * TIP :
     */
    public int method15(int[] numbers) {
        int answer = 0;
        List<Integer> list = Arrays.stream( numbers )
                            .boxed()
                            .collect( Collectors.toList() );

        for ( int i = 0; i < 10; i++ ){

            if ( !list.contains( i ) ){

                answer += i;
            }
        }

        return answer;
    }
}