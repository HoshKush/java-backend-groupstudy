package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 백준
 * 골드 IV
 * 9663 N-Queen
 */
public class NQueen {
    static boolean[] px;
    static int[] py;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        py = new int[N];

        Arrays.fill(py, Integer.MIN_VALUE);
        dfs(N, 0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int N, int x) {
        if(x == N) {
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!checkPos(x, i)) continue;
            py[i] = x;
            dfs(N, x + 1);
            py[i] = Integer.MIN_VALUE;
        }
    }

    private static boolean checkPos(int x, int y) {
        if(py[y] != Integer.MIN_VALUE) return false;
        for(int i = 0; i < py.length; i++) {
            if(py[i] + Math.abs(y - i) == x) return false;
        }
        return true;
    }
}
