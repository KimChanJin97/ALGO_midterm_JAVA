package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MCSS_Kadane { // main으로 대체
    static int mcssDC(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];

        int mid = (low + high) / 2;

        int centerLeft, centerRight, center, temp;
        centerLeft = centerRight = 0;

        temp = 0;
        for (int i = mid; i >= low; i--) {
            temp += arr[i];
            centerLeft = (centerLeft > temp) ? centerLeft : temp;
        }

        temp = 0;
        for (int j = mid + 1; j <= high; j++) {
            temp += arr[j];
            centerRight = (centerRight > temp) ? centerRight : temp;
        }

        center = centerLeft + centerRight;

        int left, right, side;

        left = mcssDC(arr, low, mid);
        right = mcssDC(arr, mid + 1, high);
        side = (left > right) ? left : right;

        return (center > side) ? center : side;
    }

    static int[] mcssKadane(int[] arr) {
        int maxSum = 0, thisSum = 0;
        int start = -1, end = -1;

        for (int i = 0, j = 0; j < arr.length; j++) {
            thisSum += arr[j];

            if (thisSum > maxSum) {
                maxSum = thisSum;
                if (arr[i] != 0)
                    start = i;
                else
                    start = i + 1;
                end = j;
            } else if (thisSum < 0) {
                i = j + 1;
                thisSum = 0;
            }
        }

        int[] result = { maxSum, start, end };
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // System.out.println("DC: " + mcssDC(arr, 0, n - 1));
            int[] result = mcssKadane(arr);
            // System.out.print("result: ");
            for (int elem : result)
                System.out.print(elem + " ");
            System.out.println();
        }

        br.close();
    }
}
