package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 빠른피보나치 { // main으로 대체
    static int[][] matrixProduct(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]) % 1000;
                    C[i][j] %= 1000;
                }
            }
        }

        return C;
    }

    static int[][] matrixExponentation(int[][] A, int n) {
        int[][] temp;
        if (n == 1)
            return A;
        else if (n % 2 == 0) {
            temp = matrixExponentation(A, n / 2);
            return matrixProduct(temp, temp);
        } else {
            temp = matrixExponentation(A, (n - 1) / 2);
            temp = matrixProduct(temp, temp);
            return matrixProduct(A, temp);
        }
    }

    static int solve(int[][] mat, int n) {
        if (n <= 1)
            return n;
        int[][] arr = matrixExponentation(mat, n);
        return arr[0][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[][] base = { { 1, 1 }, { 1, 0 } };
            int n = Integer.parseInt(br.readLine());
            System.out.println(빠른피보나치.solve(base, n)); // main으로 대체
        }

        br.close();
    }
}

