package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Palindrome2 {
    /**
     * 팰린드롬 만들기
     * 1254 그리디
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int answer = getPalindromeLength(br.readLine());

        String[] inputArr = {
//                "abab",
//                "abacaba",
//                "qwerty",
//                "abdfhdyrbdbsdfghjkllkjhgfds",
//                "ab",
//                "abaa",
//                "aaaaa",
//                "abaaa",
//                "abbb",
//                "abcdefg",
//                "aaabb"
                "aaabbbaa"
        };

        for(String s : inputArr) {
            solution2(s);
        }
//        for(String s : inputArr) {
//            bw.write(s + " : " + getPalindromeLength2(s) + "\n");
//        }

//        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution2(String in) {
        int e=in.length()-1;
        int s=0;
        int n=0;
        while(s<=e) {
            if(in.charAt(e)!=in.charAt(s)) {
                if(n<s+1)n=s+1;
                s++;
                e=in.length()-1;
            }else {
                s++;
                e--;
            }
        }
        System.out.println(in + " : " + (in.length()+n));

    }


    private static int getPalindromeLength2(String input) {
        int earliestIdx = input.length() - 1;
        for(int i = 0; i < input.length(); i++) {
            if(isPalindrome(input.substring(i))) {
                earliestIdx = i;
            }
        }

        return input.length() + earliestIdx;
    }

    private static boolean isPalindrome(String str) {
        if(str.length() == 1) return true;

        String reverse = new StringBuffer(str.substring(0, str.length() / 2)).reverse().toString();
        String restPartOfStr = str.substring(str.length() - reverse.length());
        return reverse.equals(restPartOfStr);
    }

    private static int getPalindromeLength(String input) {
        if(input.replace(input.substring(0, 1), "").length() == 0) {
            return input.length();
        }

        StringBuffer sb;
        String reverse;
        int startIdxOfReverse;
        int lastIdxOfReverse;
        int longest = -1;
        int til = input.length() % 2 == 0 ? input.length() / 2 : input.length() / 2 + 1;
        for(int i = input.length() - 1; i >= til; i--) {
            sb = new StringBuffer(input.substring(i));
            reverse = sb.reverse().toString();
            startIdxOfReverse = input.substring(0, i).lastIndexOf(reverse);
            lastIdxOfReverse = startIdxOfReverse + reverse.length() - 1;
            if(lastIdxOfReverse == i - 1 || lastIdxOfReverse == i - 2) {
                if(startIdxOfReverse > -1) {
                    longest = startIdxOfReverse;
                }
            }
        }

        return longest != -1 ? input.length() + longest : input.length() * 2 - 1;
    }

}
