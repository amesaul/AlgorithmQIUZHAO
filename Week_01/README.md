# 学习总结
##1.改写deque代码
- 原代码为：

		Deque<String> deque = new LinkedList<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);

- 改写后的代码为：

        Deque<String> deque = new LinkedList<>();

        deque.offerFirst("a");
        deque.offerFirst("b");
        deque.offerFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
##2.HashMap源码分析

###1.继承以及接口实现
---
- 继承关系：Object -> AbstractMap -> HashMap 
- 实现的接口：Map<K,V>,Cloneable,Serializable
####1.1 Map接口 ：
主要方法

- Size() :返回 K-V 键值对的数量。

- isEmpty() : Map是否为空。

- get(Object key) : 获取key所对应的值，返回值或Null。

- put(K,V) :将键值对放入Map，如果key存在则修改其value。

- cotainsKey(Object) : 是否包含某个Key。

- remove(Object key) : 移除key，返回Value。

- clear() : 清空Map。

####1.2 Cloneable 
- 标记性接口：实现了Cloneable接口且重写Object.clone方法的类的对象可以使用clone方法。

####1.3 Serializable
- 标记性接口：实现了接口的方法可以java.io中的序列化部分进行序列化与反序列化。

###2.主要实现：
###2.1 Node的实现

	    static class Node<K,V> implements Map.Entry<K,V> {
        	final int hash;
        	final K key;
       	 	V value;
       		Node<K,V> next;
		}
其中，Hash由HashMap重写的hash计算得到，源码如下：

		static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
查了一些资料，将key的哈希值右移16位与hash亦或操作是为了保留Hash值高位和低位的信息 更好的表征key的信息，这样能减少碰撞。

key,Value和nextNode，next保存在Node类中。

其中底层数据结构是数组成为哈希桶。当发生哈希碰撞时则因为每个节点采用链表结构所以可以用链表存储数目，当某个链表长度大于8时转化为红黑树（数组长度小于64）。

####2.2 Put方法

Code:

		final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }


1. table长度为0，resize()
2. 否则异或table.length-1得出key所在table的位置，如果位置为空，就放入元素，否则判断该位置的节点的key是否相同 如果相同，直接修改value。
3. 否则判断是否有树结构，如果没有，遍历链表结构，如果找到KEY就修改值，如果没有就创建Node存储该元素，否则更改为树结构。