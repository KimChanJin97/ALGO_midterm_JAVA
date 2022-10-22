package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 스트링순열 { // main으로 대체
    static int ascii(char c) {
        return (int) c - (int) 'a';
    }

    static int weight(char[] str) {
        int weight = 0;

        for (int i = 0; i < str.length; i++)
            weight += (int) Math.pow(-1, i) * (ascii(str[i]));

        return weight;
    }

    static char[] swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        return arr;
    }

    static int cnt = 0;

    static void permutation(char[] str, int start, int end) {
        int range = end - start;
        if (range == 1) {
            if (weight(str) > 0)
                cnt++;
            // System.out.println(str);
            return;
        } else {
            for (int i = 0; i < range; i++) {
                swap(str, start, start + i);
                permutation(str, start + 1, end);
                swap(str, start, start + i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();

            스트링순열.cnt = 0; // main으로 대체
            스트링순열.permutation(str, 0, str.length); // main으로 대체
            System.out.println(스트링순열.cnt); // main으로 대체
        }

        br.close();
    }
}
