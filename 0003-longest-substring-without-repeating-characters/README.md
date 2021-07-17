# 3.无重复字符的最长子串
网址：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/



## My Solution

我的解法，滑动窗口。最开始没考虑到左滑是要根据重复字符所在位置来滑可能很多个单位的，结果针对各种特殊情况写特殊处理代码，浪费了不少时间！

教训是：

- 在写代码前，要想清楚自己想写的算法到底是怎么运作的，想清楚了再下笔写，不能想到哪里写哪里。
- 当重复出现错误，提交很多次都有问题，要考虑自己的实现是不是哪里有问题！

拼接字符串的时候理所当然的想到了StringBuilder，搜了一下和StringBuffer的区别StringBuilder不是线程安全的，会快一点。



## Official Solution

和我的区别是我的tempStr存在StringBuilder里，官方的存在哈希集合里来判断重复，记录字符串的方法用了两个代表index的int来做指针。妙啊！我的办法始终会做StringBuilde的O(n)的遍历，但HashSet查找起来会快很多。