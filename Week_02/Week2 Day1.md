#Week2 Day1
## 第六课：树，二叉树，二叉搜索树
### 1. 树Tree
- 由链表结构组成
- TreeNode的组成：


		Public class TreeNode{
		    public int val ;
		    public TreeNode left,right;
		    public TreeNode(int val){
		        this.val = val ;
		        this.left = null;
		        this.right = null;
		    }
		}

- 其中TreeNode.val 保存了该节点的值，left,right分别指向左右子Node；
#### 1.二叉树的遍历
1. 前序(Pre-Order)：根-左-右
2. 中序(In-Order)： 左-根-右
3. 后序(Post-order): 左-右-根

#### 2.利用recursion编写遍历函数 
- pre-Order
- 访问根节点
- 先根遍历左子树
- 先根遍历右子树
- 退出
- 使用recursion进行遍历操作。
1. 首先确定递归的中断条件：递归到所在的节点的不为null
2. 根据一个通用性的节点以及我们要完成的功能来确定每个迭代函数需要进行的操作。
3. 确定返回值 
![image](C:/Users/amesu/Desktop/TreeRecursion.png)
- 递归函数的功能为：
1. 输出本层的TreeNode节点的Val
2. 遍历左子树
3. 遍历右子树
4. 递归写法如下：

		```
		public void preOrder(BinaryTreeNode node) {
		    if (node!=null) {
		        System.out.println(node.getVal());
		        preOrder(node.getLeftChirld);
		        preOrder(node.getRightChirld);
		    }
		}
		```
- In-Order
- 遍历左子树
- 访问根节点
- 访问右子树
- 递归写法如下


		```
		public void inOrder(BinaryTreeNode node) {
		    if(node!=null) {
		        inOrder(node.getLeftChirld());
		        System.out.println(node.getVal());
		        inOrder(node.getRightChirld());
		    }
		}
		```

- Post-Order
- 遍历左子树
- 遍历右子树
- 访问根节点
- 递归写法如下

		```
		public void postOrder(BinaryTreeNode node) {
		    if(node!=null) {
		        postOrder(node.getLeftChirld());
		        postOrder(node.getRightChirld());
		        System.out.println(node.getVal());
		    }
		}
		```
## 2.二叉搜索树(Binary Search Tree)
二叉搜索树也叫二叉排序树，有序二叉树，排序二叉树 具有的性质：
- 左子树的所有节点的值均小于根节点
- 右子树的所有节点的值均大于根节点
- 使用中序排列将保证遍历的元素为升序。
- 
## HomeWork

- 二叉树的中序遍历  https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
- 二叉树的前序遍历  https://leetcode.com/problems/binary-tree-preorder-traversal/
- N叉树的后序遍历  https://leetcode.com/problems/n-ary-tree-postorder-traversal/
- N叉树的前序遍历 https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
## 今日复习题目：LinkdList
- 反转链表 https://leetcode.com/problems/reverse-linked-list/
- 两两交换链表中的节点 https://leetcode.com/problems/swap-nodes-in-pairs/
- K个一组交换节点 https://leetcode.com/problems/reverse-nodes-in-k-group/
- 两数之和 II - 输入有序数组(每日一题) https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
