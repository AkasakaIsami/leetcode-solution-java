# Offer10- II. 青蛙跳台阶问题
- 网址：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

- 日期：2022.03.27

  

## Description

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 `n` 级的台阶总共有多少种跳法。



## My Solution

没用递归写，用循环写的。

似乎DP能用循环也能用递归？我觉得递归就是把问题拆成小问题来做，DP也是，但DP带了缓存，所以DP就是带缓存的分而治之，可以用循环也可以用递归（我也不知道我在说什么
