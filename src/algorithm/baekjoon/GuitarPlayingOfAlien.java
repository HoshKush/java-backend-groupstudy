package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 외계인의 기타연주
 * 백준 2841
 * 스택
 */

/**
 * 1. 여러개의 프랫을 동시에 운지할 수 있다.
 * 2. 연주하고자 하는 프랫보다 높은 프랫을 운지하고 있는 경우, 높은 프랫의 손가락을 때는 것도 카운트해야한다.
 */
public class GuitarPlayingOfAlien {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.valueOf(st.nextToken());          //음의 수
        final int P = Integer.valueOf(st.nextToken());          //프랫의 수
        int answer = 0;


        Guitar guitar = new Guitar(6);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            answer += guitar.finger(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Guitar {
    private Stack<Integer>[] strings;

    Guitar(int howManyStrings) {
        strings = new Stack[howManyStrings + 1];
        for(int i = 1; i < strings.length; i++) {
            strings[i] = new Stack<>();
            strings[i].push(0);             //기타의 0번프렛은 항상 눌려있다
        }
    }

    int finger(int stringNo, int fret) {
        int cntMoveOfFinger = 0;
        Stack<Integer> string = strings[stringNo];

        while(string.peek() > fret) {
            string.pop();
            cntMoveOfFinger++;
        }

        if(string.peek() < fret) {
            string.push(fret);
            return cntMoveOfFinger + 1;
        }

        return cntMoveOfFinger;
    }
}
