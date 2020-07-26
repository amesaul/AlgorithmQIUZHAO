Week2 Day2
## 堆的实现
### 1.简单粗暴直接研究一遍Heap的source code
#### 1.1 Heap的域

		private static final int d = 2 ;
		private int heap ;
		private int heapSize ;

- 其中d代表每个根节点包含的子树的个数
- heap表示存放元素的数组
- heapSize表示堆的尺寸。
 
#### 1.2 构造函数

		
		
		public BinaryHeap (int capacity) {
		    heapSize = 0 ;
		    heap = new int[capacity+1];
		    Arrays.fill(heap,-1);
		}
		
-  定义heap的最大大小为heapSize个(因为涉及插入时要额外存放要插入的长度，所以数组初始化为capacity+1)；
- 并且所有元素初始化为-1；

#### 1.3 基本方法。
		
		public boolean isEmpty() {
		    return this.heapSize == 0 ;
		}
		public boolean isFull() {
		    return heap.length == heap.length ;
		}
		public int parent(int k) {
		    return i-1/d ;
		}	
		public int kthChild(int i , int k) {
		    return d * i + k ;
		}
		
- 基本方法，判空、判满、获取根节点所在的数组索引、获取子节点的数组索引。

#### 1.4 主要实现方法 insert


		public void insert(int x) {
		    if(isFull()) {
		        throw new NoSuchElemntException("Heap is Full ,No space to insert new Element");
		    }
		    x = heap[heapSize++];
		    heapifyUp(heapSize-1);
		}
		private void heapifyUp (int i) {
		    int insertValue = heap[i];
		    while(i>0 && insertValue > heap[parent(i)) {
		        heap[i] = heap[parent[i]];
		        i = parent(i);
		    }
		    heap[i] = insertValue ;
		}

- 方法工作流程 
1. 在栈不满的情况下，在数组heap[heapSize]位置放置要添加的数。
2. 随后循环比较insertValue节点与其父节点的值，如果insertValue较大时，将其根节点的值放置在子节点的位置随后继续寻找根节点的位置，直至到达0索引位置（最大值）或者找到比insertValue值大的节点。
3. 最后将insertValue的值放置在中断点的位置。

- [ ] 由于写不好while循环 ，尝试根据这个逻辑自己写一下


		private void heapify(int insertIndex) {
		    int insertValue = heap[insertIndex];
		    while(insertValue>heap[parent(insertIndex))] {
		        if(insertIndex == 0 ) break;
		        heap[parent(insertIndex)] = heap[insertIndex];
		        insertIndex = parent(insertIndex);
		    }
		    heap[insertIndex] = insertValue ;
		}

- 需要分段思考，先考虑循环条件，随后思考主要工作逻辑，最后加入可能的循环中断边界条件。最好和递归一样分开写，不然感觉脑子不够用很乱。
#### 1.5 delete方法

	public int delete(int x) {
	    if(isEmpty()) {
	        throw new NoSuchEmlemntException ("Heap is Empty ,No element to delete");
	        int maxElement = heap[x];
	        heap [x] = heap[heapSize -1 ] ;
	        heapSize--;
	        heapifyDown(x);
	        return maxElement;
	    }
	}
	private void heapifyDown(int i) {
	    int child ;
	    int temp = heap[i];
	    while(kthChild(i,1)<heapSize) {
	        child = maxChild(i);
	        if (temp>=heap[child]) {
	            break;
	        }
	        heap[i] =heap[child];
	        i = child;
	    }
	    heap[i]=temp;
	}

## heap相关题目

### 1.最小的K个数 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

利用heap解决。


	class Solution {
	    public int[] getLeastNumbers(int[] arr, int k) {
	        PriorityQueue<Integer> heap = new PirorityQueue<>();
	        for(int i : arr) {
	            heap.add(i);
	        }
	        
	        int[] result = new int[k];
	        for( int i = 0 ; i < k ; ++ k ) {
	            ans[i] = heap.poll();
	        }
	    }
	}


## 今日复习内容
### 1. 栈，队列，双端队列，优先队列。


