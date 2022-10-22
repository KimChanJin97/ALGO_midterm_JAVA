import java.util.Scanner;

public class hanoi {
    static int[] disk_top;
    static int now_idx;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int k = sc.nextInt();
            disk_top = new int[k];
            now_idx = -1;
            hanoi(k,1,3,2);
            System.out.println();
        }
    }
    private static void move(int n , int start, int to)
    {
        if(to == 3) {
            disk_top[++now_idx] = n;
            System.out.print(n + " ");
        }
        else if (start == 3){
            if(now_idx <= 0) {
                System.out.print(0 + " ");
                now_idx = -1;
            }
            else System.out.print(disk_top[--now_idx]+ " ");
        }
    }
    private static void hanoi(int n, int start, int to, int via)
    {
        if (n == 1) move(n, start, to);
        else{
            hanoi(n-1, start, via, to);
            move(n, start,to);
            hanoi(n-1, via, to, start);
        }
    }

}
