# Offer 12. 矩阵中的路径
- 网址：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

- 日期：2022.03.27


## What's New

写递归要剪枝，用条件判断规避一些多余的运算，虽然我还是搞不懂

## My Solution

剪枝+dfs

优化方案是

- 全局计算两个维度长度
- 不是记录的状态，直接把当前board ij设成0
- string的访问改成char[]
