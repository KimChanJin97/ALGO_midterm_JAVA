import java.util.Scanner;

public class MCSS {
    static int[] numlist;
    static int size;
    static final int MIN_NUM = -1000;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int size = sc.nextInt();
            numlist = new int[size];
            for(int j = 0; j < size; j++)
            {
                numlist[j] = sc.nextInt();
            }
            System.out.println(find(0,size-1));
        }
    }
    private static int find(int left_idx, int right_idx) {
        if (left_idx == right_idx) return numlist[left_idx];

        int mid = (left_idx + right_idx) / 2;
        int left = find(left_idx, mid);
        int right = find(mid + 1, right_idx);

        int tmp = 0;
        int right_max = MIN_NUM;
        for (int i = mid+1; i < right_idx + 1; i++){
            tmp += numlist[i];
            right_max = max(right_max,tmp);
        }

        tmp = 0;
        int left_max = MIN_NUM;
        for (int i = mid; i > left_idx - 1; i--){
            tmp += numlist[i];
            left_max = max(left_max,tmp);
        }
        return max(max(left,right),left_max + right_max);
    }
    private static int max(int left, int right){
        if(left >= right) return left;
        else return right;
    }
}
