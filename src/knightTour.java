import java.util.Scanner;

public class knightTour {
    static int MAX = 8;
    static int n,m,s, t;
    static int[][] move = {{1, -2}, {2, -1}, {2, 1}, {1, 2},
            {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            int ar[][] = new int[n][m];
            for(int q = 0; q < n; q++){
                for(int p = 0; p < m; p++)
                    ar[q][p] = 0;
            }
            ar[s-1][t-1] = 1;

            if(knightstour(1,s-1,t-1,ar)) {
                System.out.println(1);

                for (int q = 0; q < n; q++) {
                    for (int p = 0; p < m; p++)
                        System.out.print(ar[q][p] + " ");
                    System.out.println();
                }
            }
            else{
                System.out.println(0);
            }
        }
    }
    private static boolean knightstour(int idx, int x, int y, int[][] ar)
    {
        if(idx == n*m){
            ar[x][y] = idx;
            return true;
        }
        for(int i = 0; i < 8; i++)
        {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if((nx>=0&&nx<n)&&(ny>=0&&ny<m)&&ar[nx][ny]==0){
                ar[nx][ny] = idx + 1;
                if(knightstour(idx+1,nx,ny,ar))
                    return true;
                else
                    ar[nx][ny] = 0;
            }
        }
        return false;
    }
}
