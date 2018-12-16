package org.zj.LeetCode;

import java.util.List;

/**
 * @program: Algo
 * @description:刚刚copy来的代码，还没来得及研究，明天再看吧
 * @author: kasumi
 * @create: 2018-12-16 22:04
 **/

public class NQueens {
    int[] a;

    public List<List<String>> solveNQueens(int n) {
        a = new int[n];
        check_m(n);
        return null;
    }

    int check(int k)    //定义check函数
    {
        int i;
        for (i = 1; i < k; i++)    //将第k行与前面的第1~~k-1行进行判断
        {
            if ((a[i] == a[k]) || (a[i] - a[k] == k - i) || (a[i] - a[k] == i - k)) //检查是否有多个皇后在同一条直线上
            {
                return 0;
            }
        }
        return 1;
    }

    void check_m(int num)   //定义函数
    {
        int k = 1, count = 0;
        a[k] = 1;
        while (k > 0) {
            if (k <= num && a[k] <= num)//从第k行第一列的位置开始，为后续棋子选择合适位子
            {
                if (check(k) == 0)    //第k行的a[k]列不能放置皇后
                {
                    a[k]++;        //继续探测当前行的下一列：a[k]+1
                } else {
                    k++;        //第K行的位置已经确定了，继续寻找第k+1行皇后的位置
                    a[k] = 1;      //从第一列开始查找
                }
            } else {
                if (k > num)     //若满足输出数组的要求则输出该数组
                {
                    count++;
                }
                //如果k>num会执行下面两行代码，因为虽然找到了N皇后问题的一个解，但是要找的是所有解，需要回溯，从当前放置皇后的下一列继续探测
                //如果a[k]>num也会执行下面两行代码，就是说在当前行没有找到可以放置皇后的位置，于是回溯，从上一行皇后位置的下一列继续探测
                k--;      //棋子位置不符合要求，则退回前一步
                a[k]++;   //继续试探下一列位置
            }
        }
    }
    public static void main(String... args){
        new NQueens().solveNQueens(4);
    }
}
