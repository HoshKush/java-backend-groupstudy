package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 2798 블랙잭
 */
public class BlackJack {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int CARD_VOLUME;
        final int MAX_NUM;
        Integer[] cards;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        CARD_VOLUME = Integer.parseInt(st.nextToken());
        MAX_NUM = Integer.parseInt(st.nextToken());

        cards = new Integer[CARD_VOLUME];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < CARD_VOLUME; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards, Collections.reverseOrder());

        combine(cards, MAX_NUM, 0, 0, 1);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    //for문 중첩 이용할 시 뽑아야하는 카드가 많아지면 for문이 너무 많아지는 단점이 있다.
    private static void combine(Integer[] cards, final int MAX_NUM, int num, int startIdx, int rnd) {
        if(answer == 0) {
            if(rnd == 4 && MAX_NUM >= num) {
                answer = num;
            } else if(rnd < 4) {
                for(int i = startIdx; i < cards.length - 3 + rnd; i++) {
                    combine(cards, MAX_NUM, num + cards[i], i + 1, rnd + 1);
                }
            }
        }
    }
}
