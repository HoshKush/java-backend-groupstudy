package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sack {
    /**
     * 평범한 배낭
     * DP 골드5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N + 1];

        for(int i = 1; i < items.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

//        Arrays.sort(items, (o1, o2) -> {
//            if(o1.weight == o2.weight) {
//                return Integer.compare(o2.value, o1.value);
//            }
//            return Integer.compare(o1.weight, o2.weight);
//        });

        int valuesInSack = fillSack(items, K);

        bw.write(valuesInSack + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int fillSack(Item[] items, int limit) {
        int[][] sack = new int[items.length][limit + 1];
        for(int i = 1; i < sack.length; i++) {
            for(int j = 1; j < sack[i].length; j++) {
                sack[i][j] = sack[i - 1][j];
                if(items[i].weight <= j) {
                    sack[i][j] = Math.max(sack[i][j], items[i].value + sack[i - 1][j - items[i].weight]);
                }
            }
        }

        return sack[items.length - 1][limit];
    }
}

class Item {
    int weight;
    int value;
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}