package oop.exception.throwsexception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import oop.exception.NoParenthesisException;

/**
 * throws를 이용한 Exception 처리
 */
public class ValidParenthesisString {
    public static void main(String[] args) throws IOException, NoParenthesisException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자가 입력되지 않을 시 NumberFormatException 발생
        final int T = Integer.parseInt(br.readLine());
        List<String> cases = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            cases.add(br.readLine());
        }

        for(String c : cases) {
            bw.write(checkValidationOfPS(c) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }

    private static String checkValidationOfPS(String parenthesis) throws NoParenthesisException {
        validateParenthesis(parenthesis);
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

    private static void validateParenthesis(String input) throws NoParenthesisException {
        if(input == null || input.trim().equals("")) {
            throw new NoParenthesisException("변수 parenthesis가 비어있습니다.");
        }

        if (!input.matches("^[()]&")) {
            throw new NoParenthesisException("변수 parenthesis에 괄호가 아닌 문자가 포함되어있습니다.");
        }
    }
}
