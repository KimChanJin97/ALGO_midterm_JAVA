import java.util.Scanner;

public class GCD {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0; i < k; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b > a) System.out.println(gcd(b,a));
            else System.out.println(gcd(a, b));
        }
    }
    private static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}