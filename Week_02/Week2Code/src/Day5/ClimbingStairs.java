package Day5;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {


    public int climbStairs(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        recur(3,n,result);
        return result[n];
    }

    private void  recur(int i, int n, int[] result) {
//        terminator
        if (i==n+1)
            return;
//        process current logic
        result[i] = result[i-1]+result[i-2];
//        drill down
        recur(i+1,n,result);
    }
}
