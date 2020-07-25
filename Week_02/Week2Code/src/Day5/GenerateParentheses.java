package Day5;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0,0,n,"",res);
        return res ;
    }

    private void generate(int l, int r,int n, String s,List res) {
//        termenator
        if (l==n&&r==n){
            res.add(s);
            return;
        }
//        current logic
        String s1 = s+'(';
        String s2 = s+')';
        if (l<n){
            generate(l+1,r,n,s1,res);
        }
        if (l>r){
            generate(l,r+1,n,s2,res);
        }
//        drill down


    }

    public static void main(String[] args) {
        GenerateParentheses ge = new GenerateParentheses();
        ge.generateParenthesis(3);
    }
}
