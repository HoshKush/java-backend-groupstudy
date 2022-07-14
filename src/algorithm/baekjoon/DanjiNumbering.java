package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DanjiNumbering {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};
    static int[][] map;
    static int cnt;
    static List<Integer> danji;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        danji = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0) continue;
                cnt = 0;
                dfs(i, j);
                danji.add(cnt);
            }
        }

        bw.write(danji.size() + "\n");
        Collections.sort(danji);
        for(int i : danji) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        cnt++;
        map[x][y] = 0;
        int nx, ny;
        for(int i = 0; i < 4; i++) {                            //4방향 탐색
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
            if(map[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}
