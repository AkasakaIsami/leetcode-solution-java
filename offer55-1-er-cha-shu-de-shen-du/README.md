# Offer 55 - I. 二叉树的深度
- 网址：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

- 日期：2022.04.05

  

## Description

输入一棵二叉树的根节点，求该树的深度。

## What's new

如何用递归写二叉树的dfs，[参考网址](https://www.bilibili.com/video/BV1Qa411t7NA?spm_id_from=333.337.search-card.all.click)给了一个解决这类问题的代码模版，需要满足两个条件：

- 二叉树有关问题
- 需要从根结点遍历到叶子节点

## Other Solution

网上有用一行代码写的

```java
class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

说本质上递归实现的是后序遍历（左右根）。这种递归是分而治之，最小问题就是叶子节点这这棵树的深度（1），然后分而治之，任何树的深度是它左子节点树深度和右子节点树深度的较大值+1。

下次可以先试着找一下递归的终止条件和最小问题，想不明白的话就试试看套模版。
