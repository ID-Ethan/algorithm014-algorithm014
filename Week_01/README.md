# 学习笔记

本周是开始学习的第一周，主要目的已经达成。在缺乏专业训练的情况下，我目前的学习还是感觉比较吃力。
从讨论区和群里的讨论内容到LeetCode上的论坛，深刻认识到自己应该加强的地方还有很多。  
了解了跳表（skiplist）这一数据结构，深入了解了双端队列，这都是以前从未有过的学习体验，但我深刻感觉到自己的不足。
底蕴不足造成了我目前刷题吃力的窘境，希望能在接下来的不断学习中不断成长，能够实现自己的目标。
也不枉费自己下一番苦功。

## 移动零
移动零这道题目本身不是很复杂，关键在于理解**同一个世界，同一个零**。  

在仔细分析并理解该题后，很容易就想到借助一个递增的外部变量j记录非零值并将其按照遍历顺序依次插入数组中，然后可以将数组再次遍历一遍（从j到height.nums.length）并将数组后面部分的所有元素的值全部置为0。  
其实上面的思路也还算可以，额外空间负责度O(1)，需要一个变量记录非零值；时间复杂度O(n)，貌似已经是最佳的算法了，但是代码写出来其实是比较挫的....
```java
    for(int i = 0;i<nums.length;i++){
        if(nums[i]!=0)...
    }
    
    for(int i = j;i<nums.length;i++){
        nums[i] = 0;
    }
``` 
面对此种场景，很自然就会想到是否有一种方式可以只遍历数组一次就能将所有元素放置在对应的位置上。（这也是视频和最佳题解中的玩法。）  
此处就必须要理解的一个点是：题目要求将数组后面的部分全部赋值为0，那么能不能在单次迭代中就将原本非零值的位置设置为0呢？答案是肯定的，在绝大多数情况下，我们可以直接将原先为非零值所在的位置填充为0，但在填充之前，必须把非零值放在他应该在的位置上（这个位置一般是在当前位置之前），而这个放置非零值的工作，恰恰是最初的思路中第一次循环做的事，因此我们可以修改原先的代码如下：
```java
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                j++;
            }
        }
    }
```
这样就可以实现一次遍历，完成赋值。
中间有一行非常重要的代码`if (i != j) nums[i] = 0;`，这行代码的意义在于仅仅在i、j不等的情况下，需要将当前的值设置为0；如果i、j相等的情况下依然赋值为0，那么结果就是刚刚摆放好非零值的位置，又重复的将其赋值为0，如此就会产生覆盖现象。
## 盛水最多的容器
盛水最多的容器这道题目看起来有种动态规划的感觉，读完题目在想解题思路时确实很慌，卧槽我碰到动态规划了怎么办...    
（虽然可以用嵌套循环的方式得到答案，但这种嵌套循环的方式在LeetCode上一定会被喷的体无完肤...）  

其实本题解法并不困难，使用的方法也是常见的双指针法（数组、链表题目中常用双指针法），难就难在无法很快就联想到使用双指针法来解决此问题。  
仔细读题并且分析后悲哀的发现我可能智商不足，果断看题解，此时会发现题解中充斥着大量的证明思路（基本都是证明为何要移动较短的一侧指针），然而看了十分钟左右就会发现这些证明虽然会让人不明觉厉，果断承认自己智商不够后，直接看代码才发现解题如此简单，ok这时候虽然觉得解题简单，但是还是没有理解解题思路和方法的，只知道用这种方法是最佳的，
那么就只能在不断的背诵和默写中一次又一次的理解了，默写两遍三遍后，大致就理解了正确的做法——双指针渐进法。至于为何要往较短的一侧移动，可以自己动手演算验证，也可以
死磕精品题解里的证明过程；一般来说，多演算几次就会发现规律所在。
```java
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i != j; ) {
            // 每次都移动高度较小的一端，返回值是较小的一端高度（类似木桶原理）
            int h = height[i] > height[j] ? height[j--] : height[i++];
            // 计算面积大小并和之前的值作比较
            max = Math.max(max, (j - i + 1) * h);
        }
        return max;
    }
```
下面是详细的思路：  
1. 定义一个max变量存储最大值。
2. 必须在每次指针移动中获取较短一侧的高度（矩形的高）。
3. 每次计算都必须和之前存储的max变量做比较，取最大值。
