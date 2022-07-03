package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * PPAP
 * 백준 16120
 * 스택
 */

public class PPAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "NP";
        String str = br.readLine();
        int p = 0;
        int a = 0;
        for(char c : str.toCharArray()) {
            if(a > 1) {
                break;
            }

            if(a == 1) {
                if(c == 'P' && p >= 2) {
                    p--;
                    a--;
                    continue;
                } else {
                    break;
                }
            }

            if(c == 'A') {
                a++;
            } else {
                p++;
            }
        }

        if(p == 1 && a == 0) {
            answer = "PPAP";
        }


        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
