package bs2024.array;

import java.util.Stack;

public class _84_largestRectangleArea {
    public static void main(String[] args) {
        _84_largestRectangleArea instance = new _84_largestRectangleArea();
        System.out.println(instance.largestRectangleArea(new int[]{2,1,5,6,2,3}));

    }

    public int largestRectangleArea(int[] heights) {
/*
        只做单调栈思路:参考"编程狂想曲"思路比较好理解
        1.核心思想:求每条柱子可以向左右延伸的长度->矩形最大宽度;矩形的高->柱子的高度,计算以每一根柱子高度为高的矩形面积,维护面积最大值
        2.朴素的想法:遍历每一根柱子的高度然后向两边进行扩散找到最大宽度
        3.单调栈优化:因为最终的目的是寻找对应柱子height[i]右边首个严格小于height[i]的柱子height[r]
            左边同理找到首个严格小于height[i]的柱子height[l]
            维护一个单调递增栈(栈底->栈顶),那么每当遇到新加入的元素<栈顶便可以确定栈顶柱子右边界
            而栈顶柱子左边界就是栈顶柱子下面的柱子(<栈顶柱子)
            左右边界确定以后就可以进行面积计算与维护最大面积
        时间复杂度:O(N),空间复杂度:O(N)
        */
        // 引入哨兵,哨兵的作用是 将最后的元素出栈计算面积 以及 将开头的元素顺利入栈
        // len为引入哨兵后的数组长度
        int len = heights.length + 2;
        int[] newHeight = new int[len];
        newHeight[0] = newHeight[len - 1] = 0;
        // [1,2,3]->[0,1,2,3,0]
        for(int i = 1; i < len - 1; i++) {
            newHeight[i] = heights[i - 1];
        }
        // 单调递增栈:存储每个柱子的索引,使得这些索引对应的柱子高度单调递增
        Stack<Integer> stack = new Stack<>();
        // 最大矩形面积
        int res = 0;
        // 遍历哨兵数组
        for(int i = 0; i < len; i++) {
            // 栈不为空且当前柱子高度<栈顶索引对应的柱子高度
            // 说明栈顶元素的右边界已经确定,就是索引为i的柱子(不含)
            // 此时将栈顶元素出栈,栈顶矩形左边界为栈顶元素下面的索引(首个小于栈顶)
            while(!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                // 栈顶索引出栈并记录
                int pop = stack.pop();
                // 计算出栈顶元素矩形的宽度如(0,1,2)->[1,2,1],两边都不包含
                // 因此右索引-左索引-1=矩形宽度
                int w = i - stack.peek() - 1;
                // 栈顶索引对应的柱子高度就是矩形的高度
                int h = newHeight[pop];
                // 计算矩形面积
                int area = w * h;
                // 维护矩形面积最大值
                res = Math.max(res, area);
            }
            // 每当弹出一个索引就计算一个矩形面积
            // 直到当前元素>=栈顶元素(或者栈为空)时,栈顶柱子的右边界还没确定
            // 因此当前元素索引入栈即可
            stack.push(i);
        }
        return res;
    }
}
