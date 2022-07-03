package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2240번
 * 자두나무
 * DP
 * 골드V
 */
public class PlumTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[1001];
        int rnd = 0;
        int treeNo = Integer.parseInt(br.readLine().trim());
        int curNo = treeNo;
        if(curNo == 1) {
            rnd++;
        }
        tree[rnd]++;
        for(int i = 1; i < T; i++) {
            treeNo = Integer.parseInt(br.readLine().trim());
            if(treeNo != curNo) rnd++;
            tree[rnd]++;
            curNo = treeNo;
        }

        int stay;
        int change;
        int[][][] dp = new int[rnd + 1][W + 1][2];
        dp[0][0][1] = 1;
        dp[0][1][0] = tree[0];
        dp[0][1][1] = 2;
        for(int i = 1; i < dp.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = 1;
            if(i % 2 == 1) {
                dp[i][0][0] += tree[i];
            }
            for(int j = 1; j < dp[i].length; j++) {
                stay = dp[i - 1][j][0];
                if((i + dp[i - 1][j][1]) % 2 == 0) {
                    stay += tree[i];
                }
                change = dp[i - 1][j - 1][0];
                if((i + dp[i - 1][j - 1][1]) % 2 == 1) {
                    change += tree[i];
                }

                if(change > stay) {
                    dp[i][j][0] = change;
                    dp[i][j][1] = dp[i - 1][j - 1][1] == 1 ? 2 : 1;
                    continue;
                }

                dp[i][j][0] = stay;
                dp[i][j][1] = dp[i - 1][j][1];
            }
        }

        bw.write(
                Arrays.stream(dp[rnd]).mapToInt(value -> value[0]).max().getAsInt() + ""
        );

        bw.flush();
        bw.close();
        br.close();
    }
}
