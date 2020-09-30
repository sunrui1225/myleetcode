package cn.rainshell.myleetcode.generateParentheses;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @author jason
 * @date 2020/9/10
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        // 1，深度优先遍历
        dfs("", n, n, res);


        return res;
    }

    /**
     * 深度优先遍历：递归+剪枝
     * @param currentStr 当前已经生成的括号
     * @param remainLeft 左括号剩余数
     * @param remainRight 右括号剩余数
     * @param res 返回结果集
     */
    public void dfs(String currentStr, int remainLeft, int remainRight, List<String> res) {

        //terminator
        if(remainLeft == 0 && remainRight == 0) {
            res.add(currentStr);
            return;
        }
        // 剪枝
        if(remainLeft > remainRight) {
            return;
        }
        // 左括号生成：剩余左括号还有值
        if(remainLeft>0) {
            dfs(currentStr + "(", remainLeft-1, remainRight, res);
        }
        // 右括号生成：剩余的右括号数要严格大于左括号数
        if(remainRight > remainLeft) {
            dfs(currentStr + ")", remainLeft, remainRight-1, res);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        GenerateParentheses gp = new GenerateParentheses();

        System.out.println(new Gson().toJson(gp.generateParenthesis(n)));
    }
}
