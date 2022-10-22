import java.util.Scanner;

public class 빠른거듭제곱 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            int a = sc.nextInt(), n = sc.nextInt();
            if(n == 0) System.out.println(1);
            else if(n == 1) System.out.println(a);
            else System.out.println(power(n,a));
        }
    }
    public static int div(int k)
    {
        return k % 1000;
    }
    public static int power(int n , int a)
    {
        if(n == 0) return 1;
        if(n == 1) return a;
        int ans = div(power(n / 2, a));
        ans = div(ans * ans);
        if(n % 2 == 1)
        {
            ans *= a;
        }
        return div(ans);
    }
}
