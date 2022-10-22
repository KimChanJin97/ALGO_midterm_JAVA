package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class factorial { // main으로 대체
    static int fact(int n) {
        if (n == 0)
            return 1;
        else {
            int temp = n * fact(n - 1);
            while (temp % 10 == 0) {
                temp /= 10;
            }
            return temp % 10000;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(factorial.fact(n) % 1000); // main으로 대체
        }

        br.close();
    }
}
