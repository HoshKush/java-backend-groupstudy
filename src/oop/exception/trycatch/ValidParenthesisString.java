package oop.exception.trycatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import oop.exception.EmptyInputException;
import oop.exception.NoParenthesisException;

/**
 * try-catch문을 이용한 Exception처리
 */
public class ValidParenthesisString {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) {
        init();
        final int T = Integer.parseInt(readLine());

        List<String> cases = new ArrayList<>();

        String input;
        for(int i = 0; i < T; i++) {
            input = readLine();
            try {
                validateParenthesis(input);
            } catch (IllegalArgumentException | EmptyInputException e) {
                e.printStackTrace();
                System.out.println("값을 다시 입력해주세요.");
                input = readLine();
            }

            cases.add(input);
        }
        System.out.println("exception");
        if(!cases.isEmpty()) {
            for(String c : cases) {
                write(checkValidationOfPS(c) + "\n");
            }
        }
        Math.random();
        flush();
        finish();
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

    private static void validateParenthesis(String input) throws EmptyInputException {
        if(input == null || input.trim().equals("")) {
//            throw new IllegalArgumentException(new EmptyInputException("변수 parenthesis가 비어있습니다."));
            throw new EmptyInputException("변수 parenthesis가 비어있습니다.");
        }

        if(!input.matches("^[()]&")) {
            throw new IllegalArgumentException(new NoParenthesisException("변수 parenthesis에 괄호가 아닌 문자가 포함되어있습니다."));
        }
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static String readLine() {
        String input = null;
        try {
            input = br.readLine();  // 1.메소드 호출
        } catch (IOException e) {   //IOException Instance 생성
            e.printStackTrace();    // 2.IOException 발생 시 해당 구현부 실행
        }

        return input;
    }

    private static void write(String str) {
        try {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            flush();
            finish();
        }
    }

    private static void flush() {
        try {
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void finish() {
        try {
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
