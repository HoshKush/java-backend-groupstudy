package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 펠린드롬만들기 1213
 * 그리디
 */
public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        String answer = makePalindrome(input);
        bw.write(answer);

        bw.flush();
        bw.close();
        br.close();
    }

    private static String makePalindrome(String input) {
        StringBuffer sb = new StringBuffer(input.length() / 2);
        int A = 65;
        int[] cntAlphabets = new int[26];
        String oddLetter = "";

        for(char c : input.toCharArray()) {
            cntAlphabets[c - A]++;
        }

        for(int i = 0; i < cntAlphabets.length; i++) {
            if(cntAlphabets[i] % 2 == 1) {
                if(!oddLetter.equals("")) {
                    return "I'm Sorry Hansoo";
                }
                oddLetter = String.valueOf((char)(i + A));
                cntAlphabets[i]--;
            }

            char[] cArr = new char[cntAlphabets[i] / 2];
            Arrays.fill(cArr, (char)(i + A));
            sb.append(String.valueOf(cArr));
        }

        String head = sb.toString();

        return head + oddLetter + sb.reverse();
    }
}
