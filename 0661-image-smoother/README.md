# 661.图片平滑器
网址：https://leetcode-cn.com/problems/image-smoother/
日期：2022.3.25


## My Solution

暴力解法，但blue case不会做条件判断而是直接计算9值的均值。red case会根据index判断哪些值越界。

理论上来思考，确实做了很多多余的越界判断与值求和，但是想不到怎么样去优化

## Other Solution

「二维前缀和」解决的是二维矩阵中的矩形区域求和问题。

详情：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/xia-ci-ru-he-zai-30-miao-nei-zuo-chu-lai-ptlo/

右下角的前缀和-左下角前缀和-右上角前缀和+左上角前缀和=当前3x3矩阵的和
