package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int fa = 0;
        int fb = 1;
        int f = 0;
        for (int i = 2; i < n; i++) {
            f = fa + fb;
            fa = fb;
            fb = f;
        }
        return f;
    }
}
