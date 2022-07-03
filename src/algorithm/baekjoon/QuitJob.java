package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QuitJob {
    /**
     * 14501 퇴사
     * 실버3 DP
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st;
        Counsel[] counsels = new Counsel[N + 1];

        counsels[0] = new Counsel(0, 0);
        for(int i = 1; i < counsels.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            counsels[i] = new Counsel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[N + 2];
        int finish;
        for(int i = 1; i < counsels.length; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            finish = counsels[i].day + i;
            if(finish >= dp.length) {
                continue;
            }
            dp[finish] = Math.max(dp[finish], dp[i] + counsels[i].pare);
        }

        bw.write(dp[dp.length -1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Counsel {
    int day;
    int pare;

    public Counsel(int day, int pare) {
        this.day = day;
        this.pare = pare;
    }
}
