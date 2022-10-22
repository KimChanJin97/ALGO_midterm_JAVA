package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class reverseArray { // main으로 대체
    static void reverse(char[] str, int start, int end) {
        if (start >= end) {
            return;
        } else {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            reverse(str, start + 1, end - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();
            int n = str.length;

            reverseArray.reverse(str, 0, n - 1); // main으로 대체
            System.out.println(str);
        }

        br.close();
    }
}