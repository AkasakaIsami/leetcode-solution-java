# Offer 13. 机器人的运动范围
- 网址：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

- 日期：2022.04.06

## My Solution

dfs，这次不用剪枝。和[offer12](https://github.com/AkasakaIsami/leetcode-solution-java/tree/main/offer12-ju-zhen-zhong-de-lu-jing)的区别在于offer12需要在每次递归的时候恢复状态：

```java
 record[x][y] = false;
```

因为它是回溯，这道题不是，遍历就完事了。摘录一下解释：

> 昨天那道题我们需要的是格子里的内容。比如格子里是a，我们的目标单词是akasaka，当前格子的a不一定是对应这个单词的哪一个a，每次遇到这个格子情况都不确定。
>
> 今天这道题我们只需要知道能访问到这个格子，并没有其它条件，每次遇到这个格子我们都知道是能访问它了，情况是确定的，因此不需要把visit状态复原。
