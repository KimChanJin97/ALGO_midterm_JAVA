package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 빠른거듭제곱 { // main으로 대체
    static int exp(int base, int n) {
        if (n == 0) {
            return 1;
        } else {
            return base * exp(base, n - 1);
        }
    }

    static int fastExp(int base, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 != 0) {
            int temp = fastExp(base, (n - 1) / 2);
            return base * temp * temp;
        } else {
            int temp = fastExp(base, n / 2);
            return temp * temp;
        }
    }

    static int solve(int base, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 != 0) {
            int temp = solve(base, (n - 1) / 2) % 1000;
            return (base * temp * temp) % 1000;
        } else {
            int temp = solve(base, n / 2) % 1000;
            return (temp * temp) % 1000;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(빠른거듭제곱.solve(a, n)); // main으로 대체
            // System.out.println(Exponentiation.fastExp(a, n));
        }

        br.close();
    }
}
