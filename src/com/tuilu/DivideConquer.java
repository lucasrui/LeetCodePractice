package com.tuilu;

/**
 * Created by Administrator on 2015/12/30.
 */
public class DivideConquer {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        /*if (n == 0) return 1 % b;
        int ans = 1;
        a = a % b;
        while (n > 0) {
            if (n % 2 == 1)
                ans = (ans * a) % b;
            n = n / 2;
            a = (a * a) % b;
        }
        return ans;*/
        // write your code here
        if(n==0)
            return 1%b;
        if(n==1)
            return a%b;
        long temp = fastPower(a,b,n/2);
        if((n&1)>0)
            return (int) (((temp*temp)%b)*a%b);
        else
            return (int) (temp*temp%b);
    }
}
