package com.karim.algorithm.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Level1_16_30 {

    /**
     * NOTE : 부족한 금액 계산하기
     * COMMAND : 리턴형이 long 인 이유가 있었네;;
     * TIP :
     */
    public long method16(int price, int money, int count) {
        long answer = -1;
        long tmp = 0L;
        Long xLong= (long) price;
        Long yLong= (long) money;

        for ( int i = 1; i <= count; i++ ){

            tmp += xLong * i;
        }

        if ( tmp > yLong ){

            answer = tmp - yLong;
        }else {

            answer = 0;
        }

        return answer;
    }

    /**
     * NOTE : 숫자 문자열과 영단어
     * COMMAND :
     * TIP :
     */
    public int method17(String s) {
        String[] matches = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0 ; i <matches.length; i++) {

            s = s.replaceAll( matches[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    /**
     * NOTE : 개인정보 수집 유효기간
     * COMMAND :
     * TIP :
     */
    public int[] method18(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar cal = Calendar.getInstance();
        Date dt;
        Date dt2 = null;

        try {

            dt2 = dtFormat.parse( today );
            
            for (String term : terms) {

                String[] a = term.split(" ");
                termsMap.put( a[0], Integer.parseInt( a[1] ));
            }

            for (int i = 1; i <= privacies.length; i++ ) {

                String[] a = privacies[ i - 1 ].split(" ");

                dt = dtFormat.parse( a[0] );
                cal.setTime(dt);
                cal.add(Calendar.DATE,  -1); // 범위가 하루 전
                cal.add(Calendar.MONTH,  termsMap.get( a[1] ) );

                if ( cal.getTime().before( dt2 ) ){ // 범위 초과
                    list.add(i);
                }
            }

            answer = new int[ list.size() ];
            for (int i = 0 ; i < list.size() ; i++) { // 범위 넘은거 보기
                
                answer[i] = list.get(i);
            }

        } catch (ParseException e) {

            throw new RuntimeException(e);
        }

        return answer;
    }

    /**
     * NOTE : 약수의 개수와 덧셈
     * COMMAND : 항상 말하지만 약수 = 제곱근 ( 제곱근이 0이면 홀수 ) 인데 난 왜 항상 이렇게 푸는지
     * TIP :
     */
    public int method19(int left, int right) {
        int answer = 0;

        for ( int i = left; i <= right; i++ ){
            int count = 0;

            for (int j = 1; j <= i; j++) {

                if ( i % j == 0) {

                    count++;
                }
            }

            if( count % 2 == 0 ){ // 갯수가 짝수면 더하고

                answer += i;
            }else { // 홀수면 뺴기

                answer -= i;
            }
        }

        return answer;
    }

    /**
     * NOTE : 로또의 최고 순위와 최저 순위
     * COMMAND :
     * TIP :
     */
    public int[] method20(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;

        for (int lotto : lottos) {

            if( lotto == 0 ){

                zero++;
            }else {

                for (int win_num : win_nums) {

                    if ( lotto == win_num ){

                        count++;
                    }
                }
            }
        }
        answer[0] = score( zero + count );
        answer[1] = score( count );

        return answer;
    }

    public static int score( int score ){

        if ( score == 6 ){
            return 1;
        }else if ( score == 5 ){
            return 2;
        }else if ( score == 4 ){
            return 3;
        }else if ( score == 3 ){
            return 4;
        }else if ( score == 2 ){
            return 5;
        }else {
            return 6;
        }
    }

    /**
     * NOTE : 폰켓몬
     * COMMAND :
     * TIP : set.size() > nums.length / 2 ? nums.length / 2 : set.size()
     *       to Math.min(set.size(), nums.length / 2)
     */
    public int method21(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            set.add( num );
        }

        return Math.min(set.size(), nums.length / 2);
    }

    /**
     * NOTE : 음양 더하기
     * COMMAND :
     * TIP :
     */
    public int method22(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for ( int i = 0; i < absolutes.length; i++ ){

            if ( signs[i] ){

                answer = answer + absolutes[i];
            }else {

                answer = answer - absolutes[i];
            }
        }

        return answer;
    }


    /**
     * NOTE : 신규 아이디 추천
     * COMMAND :
     * TIP :
     */
    public String method23(String new_id) {
        String answer = "";
        String[] aaa = { "~","!","@","#","\\$","%","\\^","&","\\*","\\(","\\)","=","\\+","\\[","\\{","\\]","\\}",":","\\?","<",">","/","," };

        // 대문자 -> 소문자
        new_id = new_id.toLowerCase(Locale.ROOT);


        //알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용
        for ( String s : aaa ) {

            new_id = new_id.replaceAll( s, "" );
        }

        // . 이 연속으로 사용 되면 한개로 치환
        for ( int j = 0; j < new_id.length() -1 ; j++ ){

            if ( (new_id.charAt(j) == 46) ){

                int k = j;
                while ( true ){
                    // k+1이 마지막이거나, 아니면 다음이 .이 아니면 브레이크
                    if ( k + 1 == new_id.length() ||( new_id.charAt( k + 1 ) != 46) ){

                        break;
                    }
                    k++;
                }

                new_id = new_id.substring( 0, j + 1 ) + new_id.substring( k + 1);
            }
        }

        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
        if ( new_id.length() > 0 &&  new_id.charAt( new_id.length() -1 ) == 46 ){ // 맨 문자

            new_id = new_id.substring( 0, new_id.length() -1 );
        }

        if ( new_id.length() > 0 && new_id.charAt(0) ==  46 ){ // 맨 앞에

            new_id = new_id.substring( 1 );
        }

        // new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if ( new_id.length() == 0 ){

            new_id = "a";
        }

        //new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if ( new_id.length() >= 16 ){

            new_id = new_id.substring( 0, 15 );

            if ( new_id.charAt( new_id.length() -1 ) == 46 ){ // 맨 문자

                new_id = new_id.substring( 0, new_id.length() - 1 );
            }
        }

        //new_id의 길이가 2자 이하 라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복 해서 끝에 붙입니다.
        if ( new_id.length() <= 2 ){

            String a = new_id.substring( new_id.length() -1 );
            while ( true ){

                new_id = new_id + a;

                if ( new_id.length() == 3 ){
                    break;
                }
            }
        }

        return new_id;
    }

    /**
     * NOTE : 내적
     * COMMAND :
     * TIP :
     */
    public int method24(int[] a, int[] b) {
        int answer = 0;

        for ( int i = 0; i < a.length; i++ ){

            answer += a[i] * b[i];
        }
        return answer;
    }

    /**
     * NOTE : 둘만의 암호
     * COMMAND :
     * TIP :
     */
    public String method25(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String[] originSpelling = {"a","b","c","d","e","f","g",
                "h","i","j","k","l","m","n",
                "o","p","q","r","s","t","u",
                "v","w","x","y","z"};
        List<String> spellingList = new ArrayList<>(Arrays.asList(originSpelling));

        // skip 선처리
        for ( char c : skip.toCharArray() ){
            spellingList.remove(c + "");
        }

        int spellingSize = spellingList.size();

        int trueSize;
        for ( char c : s.toCharArray()){

            int sIndex = spellingList.indexOf(c + "") + index;
            if ( spellingSize > sIndex ){ // 인덱스가 작으면 일반으로 넣기
                trueSize = sIndex;
            }else if ( spellingSize <= (sIndex - spellingSize) ){
                trueSize = (sIndex - spellingSize) - spellingSize;
            }else {
                trueSize = sIndex - spellingSize;
            }
            answer.append(spellingList.get(trueSize));
        }
        return answer.toString();
    }
    
    /**
     * NOTE : 3진법 뒤집기
     * COMMAND :
     * TIP :10진법에서 3진법으로 변환은 toString을 이용하여 Integer.toString(n,3);로 변경이 가능
     */
    public int method26(int n) {
        StringBuilder answer = new StringBuilder();

        // 10 -> 3 및 앞뒤 반전
        while ( n > 0 ){

            answer.append( n % 3 );
            n = n / 3;
        }

        // 3 -> 10
        return Integer.parseInt(String.valueOf(answer),3);
    }

    /**
     * NOTE : 두 개 뽑아서 더하기
     * COMMAND :
     * TIP :
     */
    public int[] method27(int[] numbers) {
        List<Integer> answerList = new ArrayList<>();

        for ( int i=0; i<numbers.length+1; i++ ){

            for ( int j=i+1; j<numbers.length; j++ ){

                answerList.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = answerList.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();

        return Arrays.stream(answer).distinct().sorted().toArray();
    }
}