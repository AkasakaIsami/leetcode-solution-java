# Offer06.从尾到头打印链表
- 网址：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

- 日期：2021.11.03

  

## Description

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



## My Solution

没什么精神，随便写写

用两个指针反转了链表，然后又遍历链表打印了数组，时间很快，但是空间不太行。看了题解，利用栈先进后出的特点，直接遍历两遍就可以了。为啥空间不太行呢，我就新建了两个listnode的指针……



## Stack Solution

就是先push再pop，也可以用递归写。说这题充分说明的递归的本质就是栈，现在不想思考，以后再说。
