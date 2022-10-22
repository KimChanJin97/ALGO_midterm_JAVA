package config;

import java.io.IOException;
import java.util.Scanner;

class Knight {
    public int x;
    public int y;

    public Knight() {
        this(0, 0);
    }

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class knightTour { // main으로 대체
    static final int MAXSIZE = 8;
    static final int MARK = 1;
    static final int UNMARK = 0;
    static final int[][] directions = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 },
            { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 } };

    static int[][] board, path;

    static int knightTour(int x, int y, Knight pos, int cnt) {
        Knight next = new Knight();

        // over
        if (cnt == x * y)
            return 1;

        // check 8 directions
        for (int i = 0; i < 8; i++) {
            next.x = pos.x + directions[i][0];
            next.y = pos.y + directions[i][1];

            // next is in the board, not MARK
            if ((next.x >= 0 && next.x < x) && (next.y >= 0 && next.y < y)
                    && board[next.y][next.x] != MARK) {
                board[next.y][next.x] = MARK;
                path[next.y][next.x] = cnt + 1;

                // recursive, when this way is finished start with current direction
                if (knightTour(x, y, next, cnt + 1) == 1)
                    return 1;

                board[next.y][next.x] = UNMARK;
            }
        }

        // 8 directions are UNMARK
        return 0;
    }

    static void printPath(int x, int y, int result) {
        System.out.println(result);
        if (result == 1) {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int m, n, s, t, result;

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            // StringTokenizer st = new StringTokenizer(br.readLine());

            // m = Integer.parseInt(st.nextToken()); // board row
            m = in.nextInt();
            // n = Integer.parseInt(st.nextToken()); // board col
            n = in.nextInt();
            // s = Integer.parseInt(st.nextToken()); // knight row num = board row + 1
            s = in.nextInt();
            // t = Integer.parseInt(st.nextToken()); // knight col num = board col + 1
            t = in.nextInt();

            board = new int[m][n];
            path = new int[m][n];
            Knight knight = new Knight(t - 1, s - 1);

            board[knight.y][knight.x] = MARK;
            path[knight.y][knight.x] = 1;

            result = knightTour(n, m, knight, 1);
            printPath(n, m, result);
        }

        in.close();
    }
}