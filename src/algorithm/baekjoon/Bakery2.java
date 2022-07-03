package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Bakery2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int pipe = countPossiblePipe(map);
        bw.write(pipe + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int countPossiblePipe(char[][] map) {
        HashSet<Integer> connected = new HashSet<>();
        for(int i = 0; i < map.length; i++) {
            connect(map, i, 0, i, connected);
        }
        return connected.size();
    }

    private static void connect(char[][] map, int x, int y, int startIdx, HashSet<Integer> connected) {
        if(connected.contains(startIdx)) {
            return;
        }

        map[x][y] = 'x';

        if(y == map[x].length - 1) {
            connected.add(startIdx);
            return;
        }

        //순서가 상-중-하 바뀌면 안된다.
        if(x > 0 && map[x - 1][y + 1] == '.' ) {
            connect(map, x - 1, y + 1, startIdx, connected);
        }

        if(map[x][y + 1] == '.') {
            connect(map, x, y + 1, startIdx, connected);
        }

        if(x < map.length - 1 && map[x + 1][y + 1] == '.') {
            connect(map, x + 1, y + 1, startIdx, connected);
        }
    }
}
