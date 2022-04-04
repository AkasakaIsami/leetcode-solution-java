# Offer 11. 旋转数组的最小数字
- 网址：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
- 日期：2022.04.04


## What's New

我总结了两点二分的关键

- 为了保证最后剩两个元素的时候仍然能缩小区间，所以两个移动一定得是mid和mid-1或者mid和mid+1
- 要保证每次移动完，要找的那个数都在我的区间里

第一点上次写二分的时候疏忽了，二分的终止条件一定是左右指针相遇

## My Solution

遇到了两个问题：

- 为何是右指针和中间指针比
- 为什么左右移动区间的时候索引不一样

分别对应上面两点
