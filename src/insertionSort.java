
import java.util.Scanner;

public class insertionSort {
    static final int MAX_SIZE = 1000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++)
        {
            int[] a = new int[MAX_SIZE];
            int num;
            num = sc.nextInt();
            for(int j = 0; j < num; j++)
            {
                a[j] = sc.nextInt();
            }
            insertionSort(a, num);
        }
    }
    public static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    private static void insertionSort(int a[], int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        for (int i = 1; i < n; i++){
            int tmp = a[i];
            for(int j = i-1; j >= 0; j--)
            {
                countCmpOps++;
                if(a[j] > tmp){
                    swap(a,j+1, j);
                    countSwaps++;
                }
                else break;
            }
        }
        System.out.print(countCmpOps + " " + countSwaps + "\n");
    }
}
