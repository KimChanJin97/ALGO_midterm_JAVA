package config;

import java.util.Scanner;

class fibonacci { // main으로 대체
    static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    static int[] arr = new int[31];

    static int fiboMemo(int n) {
        if (n <= 1) {
            arr[n] = n;
            return n;
        }

        if (arr[n] == 0)
            arr[n] = fibo(n - 1) + fibo(n - 2);

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            System.out.println(fibonacci.fiboMemo(n)); // main으로 대체
        }

        in.close();
    }
}