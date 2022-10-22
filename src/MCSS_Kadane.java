import java.util.Scanner;

public class MCSS_Kadane {
    static final int MAX = 100;
    public static void main (String[] args)
    {
        int n,size;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int[] numList = new int[MAX];
            int[] start = new int[MAX];
            size = sc.nextInt();
            for(int j = 0; j < size; j++){
                numList[j] = sc.nextInt();
            }
            int globalMax = numList[0];
            int localMax = numList[0];
            int left = 0,right = 0;
            for(int k = 1; k < size; k++)
            {
                if(numList[k] > numList[k-1] + localMax) {
                    localMax = numList[k];
                    start[k] = k;
                }else{
                    localMax = numList[k] + localMax;
                    start[k] = start[k-1];
                }

                if(globalMax < localMax){
                    right = k;
                    left = start[k];
                    globalMax = localMax;
                }
            }
            if(globalMax >= 0 && numList[left] != 0) System.out.println(globalMax + " "+left+" " +right);
            else System.out.println("0 -1 -1");
        }
    }
}
