# Offer 30. 包含min函数的栈
- 网址：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/

- 日期：2022.04.29

## What's New

stack的题用deque来代替，原因：

> Stack作为java语言的栈，是被诟病的地方，作为栈数据结构，却继承了vector，对外暴露了get(index)这样的方法，不是一种合理的实现方式，所以后来java开发提倡使用ArrayDeque

（虽然我用的是LinkedList）

### Deque双端队列介绍

Deque是Queue子接口，是双端队列。可以同时从两端(队列头部和尾部)添加、删除元素。所以可以用来实现栈的数据结构。

有两个实现类：

- ArrayDeque
  - ArrayDeque底层实现类似于ArrayList，都是通过动态、可分配的Object[]数组来实现元素存储，当集合元素超过数组容量，会重新分配一个新的数组来存储集合元素。
- LinkedList
  - LinkedList实现List，同时也实现了Deque，可以当做双端队列来使用，可以当做“栈”或“队列”使用。LinkedList与ArrayList、ArrayDeque不同之处在于底层实现，LinkedList底层是通过链表的形式存储元素，随机访问性能比较差，但是在插入、删除的时候性能比较好(只需要改变指针所指的地址就行)

## My Solution

我以为是自己用数组来实现一个栈，但其实可以用java自带的数据结构

写了一个arraylist实现的，又写了一个linkedlist实现的，后者时间表现更好（因为就插入、删除的性能而言，双向队列要优于arraylist，吧……）
