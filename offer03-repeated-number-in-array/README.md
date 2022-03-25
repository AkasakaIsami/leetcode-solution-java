# Offer03.数组中重复的数组
- 网址：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

- 日期：2021.11.01

  今天开始刷剑指offer，打算一天刷2-3道题。

  https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/duo-chong-jie-fa-xun-xu-jian-jin-yi-zhi-dao-zui-yo/ 这个答案写得好。

## Description

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。



## My Solution

第一直觉用HashMap，把时间复杂度压在O(n)，但是跑完以后速度只超过了36%的用户？而且这种解法没有利用到 0～n-1 范围的这个条件……

原来HashSet也是O(1)的查询！涨知识了。



## Other Solution

### 原地置换

主要用于重复出现的数，缺失的数等题目中。

> 题目说明尚未被充分使用，即 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内 。 此说明含义：数组元素的 索引 和 值 是 一对多 的关系。

原地置换的大体思路就是将我们指针对应的元素放到属于他的位置（索引对应的地方）。我们可以这样理解，每个人都有自己的位置，我们需要和别人调换回到属于自己的位置，调换之后，如果发现我们的位置上有人了，则返回。

时间复杂度也是O(n)，或许空间复杂度小一些？

用数组模拟哈希的话，用两个数组，还是空间复杂度还是比较高。指针的话直接对数组内元素进行置换，空间复杂度O(1)！