# Offer05.替换空格
- 网址：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

- 日期：2021.11.02

  

## Description

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。



## My Solution

本来想用StringBuilder做的，结果在网上搜有没有现成可用的接口，找到String类下的一个replaceAll()可以直接用，但是肯定不是最优解：

我看了下实现，好像是转成StringBuffer用java自带的正则做的，那肯定就复杂了啊因为本来只是换个空格而已不需要动用正则……而且线程安全的StringBuffer肯定多占了时间和空间。

最开始想在一个数组里直接替换，但感觉替换后由于数组长度变化，懒得搞索引就直接用了现成的接口，经验教训：不要投机取巧！不可以懒懒orz



## Official Solution

多搞个数组，或者搞个新的StringBuilder，来一个填一个，遇到空格填三个。这样空间复杂度有点低……

最优就是搞两个指针吧，空间时间复杂度都很低，在原来的数组上操作。明天写写看……

