import java.util.Scanner;

public class combSort {
    static final int MAX_SIZE = 1000;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++)
        {
            int[] a = new int[MAX_SIZE];
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) a[j] = sc.nextInt();
            combSort(a,num);
        }
    }
    private static void combSort(int arr[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;

        double shrink = 1.3;
        boolean sorted = false;

        int gap = n;

        while (!sorted)
        {
            gap /= shrink;
            if (gap <= 1)
            {
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while(i + gap < n)
            {
                countCmpOps++;
                if(arr[i] > arr[i + gap]){
                    swap(arr, i, i + gap);
                    sorted = false;
                    countSwaps++;
                }
                i++;
            }
        }

        System.out.println(countCmpOps + " " + countSwaps);
    }
    private static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}