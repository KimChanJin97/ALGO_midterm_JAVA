package config;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Tower {
    int[] tower;
    int pointer;

    public Tower() {
        this(0);
    }

    public Tower(int size) {
        this.tower = new int[size];
        this.pointer = 0;
    }

    public int pop() {
        int temp = this.tower[pointer];
        this.tower[pointer--] = 0;
        return temp;
    }

    public void push(int val) {
        this.tower[++pointer] = val;
    }

    public int top() {
        return this.tower[pointer];
    }
}

class hanoi { // main으로 대체
    static Tower le, ce, ri;
    static int prev;

    static void solve2(int n, Tower l, Tower c, Tower r) {
        if (n > 0) {
            solve2(n - 1, l, r, c);
            r.push(l.pop());
            if (ri.top() != prev)
                System.out.print(ri.top() + " ");
            prev = ri.top();
            solve2(n - 1, c, l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            le = new Tower(n + 1);
            for (int j = n; j >= 1; j--)
                le.push(j);
            ce = new Tower(n + 1);
            ri = new Tower(n + 1);
            prev = 0;

            solve2(n, le, ce, ri);
            System.out.println();
        }

        br.close();
    }
}