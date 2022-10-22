import java.util.Scanner;

public class shellSort {
    static final int MAX_SIZE = 1000;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++)
        {
            int[] a = new int[MAX_SIZE];
            int num = sc.nextInt();
            for(int j = 0; j < num; j++) a[j] = sc.nextInt();
            shellSort(a,num);
        }
    }
    public static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    private static void shellSort(int arr[], int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        int shrinkRatio = 2;
        int gap = n / shrinkRatio;

        while(gap > 0)
        {
            for(int i=0; i < n; i++)
            {
                int tmp = arr[i];
                int j;
                for(j = i; j >= gap; j-= gap){
                    countCmpOps++;
                    if(arr[j-gap] > tmp){
                        countSwaps++;
                        arr[j] = arr[j-gap];
                    }
                    else break;
                }
                arr[j] = tmp;
            }
            gap /= shrinkRatio;
        }

        System.out.println(countCmpOps + " " + countSwaps);
    }
}
