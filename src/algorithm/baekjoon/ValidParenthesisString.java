package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 9012 괄호
 * 1. 가장 처음은 여는 괄호가 와야한다.
 * 2. 가장 마지막은 닫는 괄호가 와야한다.
 * 3. 여는 괄호와 닫는 괄호의 수가 같아야한다.
 */
public class ValidParenthesisString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(br.readLine());
        List<String> cases = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            cases.add(br.readLine());
        }

        if(!cases.isEmpty()) {
            List<String> answers = cases.stream().map(ValidParenthesisString::checkValidationOfPS)
                    .collect(Collectors.toList());
            for (String answer : answers) {
                bw.write(answer + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String checkValidationOfPS(String parenthesis) {


        int p = 0;
        for(char c : parenthesis.toCharArray()) {
            if(c == '(') {
                p++;
            } else {
                p--;
            }

            if(p < 0) { //현재 진행 상황에서 닫는 괄호의 수가 여는 괄호의 수보다 많으면 짝이 맞을 수 없다.
                return "NO";
            }
        }

        if(p == 0) {
            return "YES";
        }

        return "NO";
    }
}
