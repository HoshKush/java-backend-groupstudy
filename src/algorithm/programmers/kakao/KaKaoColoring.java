package algorithm.programmers.kakao;

import java.util.Arrays;

/**
 * 2017 카카오코드 예선
 * 카카오프렌트 컬리링북
 */
public class KaKaoColoring {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int[] answer = new int[2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] > 0 && !visited[i][j]) {
                    answer[0]++;
                    answer[1] = Math.max(answer[1], dfs(picture, visited, i, j, picture[i][j]));
                }
            }
        }
        return answer;
    }

    private int dfs(int[][] picture, boolean[][] visited, int x, int y, int c) {
        int cnt = 1;
        visited[x][y] = true;
        int nx, ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length) continue;
            if(picture[nx][ny] != c) continue;
            if(visited[nx][ny]) continue;
            cnt += dfs(picture, visited, nx, ny, c);
        }
        return cnt;
    }

    public static void main(String[] args) {
        KaKaoColoring k = new KaKaoColoring();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        Arrays.stream(k.solution(m, n, picture)).forEach(System.out::println);
    }
}
