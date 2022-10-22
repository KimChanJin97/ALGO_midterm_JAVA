import java.util.Scanner;

public class 빠른피보나치 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0; i < k; i++){
            int n = sc.nextInt();
            int fr[][] = {{1,1},{1,0}};
            if(n <= 1){
                System.out.println(n);
                continue;
            }
            System.out.println(fibo(n,fr)[0][1]);

        }
    }
    private static int[][] mul(int[][] a, int[][] b)
    {
        int[][] c = new int[2][2];
        c[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
        c[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
        c[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
        c[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];

        return div(c);
    }
    private static int[][] div(int[][] a){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                a[i][j] = a[i][j] % 1000;
            }
        }
        return a;
    }
    private static int[][] fibo(int n, int[][] ar){
        if (n > 1)
        {
            ar = fibo(n / 2, ar);
            ar = mul(ar,ar);
            if(n % 2 == 1){
                int na[][] = {{1,1},{1,0}};
                ar= mul(ar,na);
            }
        }
        return ar;
    }
}
