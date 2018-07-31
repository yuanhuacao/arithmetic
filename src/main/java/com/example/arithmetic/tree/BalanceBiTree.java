
package com.example.arithmetic.tree;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 当出现图2.1（b）中的情况时只需要进行一次右旋转操作，旋转后得到如图2.1（d）所示的平衡二叉树。
 * <p>
 * 当出现图2.1（c）中的情况时需要先对A的左子树B进行左旋操作，然后再进行右旋操作，旋转后得到如图2.1（e）所示的平衡二叉树。
 * <p>
 * 当出现图2.2（b）中的情况时只需要进行一次右旋转操作，旋转后得到如图2.1（d）所示的平衡二叉树。
 * <p>
 * 当出现图2.2（c）中的情况时需要先对A的右子树B进行右旋，然后再进行左旋操作，旋转后得到如图2.2（e）所示的平衡二叉树。
 * <p>
 * 单旋转是针对于左左和右右这两种情况的解决方案，这两种情况是对称的，只要解决了左左这种情况，右右就很好办了。图3是左左情况的解决方案，节点k2不满足平衡特性，
 * 因为它的左子树k1比右子树Z深2层，而且k1子树中，更深的一层的是k1的左子树X子树，所以属于左左情况。
 * <p>
 * <p>
 * <p>
 * 为使树恢复平衡，我们把k2变成这棵树的根节点，因为k2大于k1，把k2置于k1的右子树上，而原本在k1右子树的Y大于k1，小于k2，就把Y置于k2的左子树上，
 * 这样既满足了二叉查找树的性质，又满足了平衡二叉树的性质。
 * <p>
 * 这样的操作只需要一部分指针改变，结果我们得到另外一颗二叉查找树，它是一棵AVL树，因为X向上一移动了一层，Y还停留在原来的层面上，Z向下移动了一层。
 * 整棵树的新高度和之前没有在左子树上插入的高度相同，插入操作使得X高度长高了。因此，由于这颗子树高度没有变化，所以通往根节点的路径就不需要继续旋转了。
 * <p>
 * 右旋转代码
 * <p>
 * 复制代码
 * void R_rotate(BiTree *t)
 * {
 * BiTree s;
 * s = (*t)->lchild;                    //s指向t的左子树根结点
 * (*t)->lchild = s->rchild;          //s的右子树挂接为t的左子树
 * s->rchild = (*t);
 * t = s;                                //t指向新的根结点
 * }
 * 复制代码
 *
 * @param <T>
 */
public class BalanceBiTree<T> {

    private Node root;

    private int size;

    public void insert(T t) {
        if (root == null) {
            root = new Node();
            root.bf = 0;
            root.data = t;
            size++;
            return;
        }
        addNode(root, t);
    }

    private boolean addNode(Node nd, T t) {
        boolean taller = false;
        Comparable<T> cp = (Comparable<T>) nd.data;
        int i = cp.compareTo(t);
        if (i == 0) {
            return false;
        } else if (i > 0) {
            if (nd.lChild == null) {
                Node child = new Node();
                child.bf = 0;
                child.data = t;
                child.parent = nd;
                nd.lChild = child;
                size++;
                if (nd.bf == 0) {
                    nd.bf = 1;
                    return true;
                }
                nd.bf = 0;
            } else {
                taller = addNode(nd.lChild, t);
                if (taller) {
                    if (nd.bf == 1) {
                        leftBalance(nd);
                        taller = false;
                    } else if (nd.bf == 0) {
                        nd.bf = 1;
                        taller = true;
                    } else {
                        nd.bf = 0;
                        taller = false;
                    }
                }
            }
        } else {
            if (nd.rChild == null) {
                Node child = new Node();
                child.bf = 0;
                child.data = t;
                child.parent = nd;
                nd.rChild = child;
                size++;
                if (nd.bf == 0) {
                    nd.bf = -1;
                    return true;
                }
                nd.bf = 0;
            } else {
                taller = addNode(nd.rChild, t);
                if (taller) {
                    if (nd.bf == 1) {
                        nd.bf = 0;
                        taller = false;
                    } else if (nd.bf == 0) {
                        nd.bf = -1;
                        taller = true;
                    } else {
                        rightBalance(nd);
                        taller = false;
                    }
                }
            }
        }
        return taller;
    }

    public int getSize() {
        return size;
    }

    private void leftBalance(Node nd) {
        Node leftChild = nd.lChild;
        if (leftChild.bf == 1) {
            nd.bf = 0;
            leftChild.bf = 0;
            rightRotate(nd);
        } else if (leftChild.bf == -1) {
            Node rd = leftChild.rChild;
            switch (rd.bf) {
                case 1:
                    leftChild.bf = 0;
                    nd.bf = -1;
                    break;
                case 0:
                    leftChild.bf = 0;
                    nd.bf = 0;
                    break;
                case -1:
                    leftChild.bf = 1;
                    nd.bf = 0;
                    break;
            }
            rd.bf = 0;
            leftRotate(leftChild);
            rightRotate(nd);
        }
    }

    private void rightBalance(Node nd) {
        Node rightChild = nd.rChild;
        if (rightChild.bf == 1) {
            Node ld = rightChild.lChild;
            switch (ld.bf) {
                case 1:
                    rightChild.bf = -1;
                    nd.bf = 0;
                    break;
                case 0:
                    rightChild.bf = 0;
                    nd.bf = 0;
                    break;
                case -1:
                    rightChild.bf = 0;
                    nd.bf = 1;
                    break;
            }
            ld.bf = 0;
            rightRotate(rightChild);
            leftRotate(nd);
        } else if (rightChild.bf == -1) {
            nd.bf = 0;
            rightChild.bf = 0;
            leftRotate(nd);
        }

    }

    /**
     * void L_Rotate(BiTree&T)
     * {
     * BiTree p;
     * p=T->rchild;     //假如此时T指向4，则p指向7.
     * T->rchild=p->lchild;  //让7的左子树挂接到4的右子树上·
     * p->lchild=T;    //让7的左孩子指向4
     * T=p;   //树根指向7
     * }
     *
     * @param nd
     */

    private void leftRotate(Node nd) {
        Node top = nd.rChild;
        nd.rChild = top.lChild;
        if (top.lChild != null)
            top.lChild.parent = nd;
        top.lChild = nd;
        top.parent = nd.parent;
        if (nd.parent != null) {
            if (nd.parent.lChild == nd)
                nd.parent.lChild = top;
            else
                nd.parent.rChild = top;
        } else {
            root = top;
        }
        nd.parent = top;
    }

    /**
     * 复制代码
     * void R_rotate(BiTree *t)
     * {
     * BiTree s;
     * s = (*t)->lchild;                    //s指向t的左子树根结点
     * (*t)->lchild = s->rchild;          //s的右子树挂接为t的左子树
     * s->rchild = (*t);
     * t = s;                                //t指向新的根结点
     * }
     *
     * @param nd
     */

    private void rightRotate(Node nd) {
        Node top = nd.lChild;
        nd.lChild = top.rChild;
        if (top.rChild != null)
            top.rChild.parent = nd;
        top.rChild = nd;
        top.parent = nd.parent;
        if (nd.parent != null) {
            if (nd.parent.lChild == nd)
                nd.parent.lChild = top;
            else
                nd.parent.rChild = top;
        } else {
            root = top;
        }
        nd.parent = top;
    }

    @Override
    public String toString() {
        return "BalanceBiTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    public void printTree() {
        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<Node>();
        ConcurrentLinkedQueue<Node> tempQueue = new ConcurrentLinkedQueue<Node>();
        queue.add(root);
        int offset = 0;
        int counter = 2;
        for (int i = 0; i < 50; i++)
            System.out.print(" ");
        while (queue.peek() != null) {
            Node node = queue.poll();
            String side = "L";
            if (node.parent != null && node.parent.rChild == node)
                side = "R";
            System.out.print(node.data + "(" + (node.parent == null ? "" : node.parent.data) + " " + side + ")");
            if (node.parent != null && node.parent.rChild != node)
                for (int i = 0; i < counter; i++)
                    System.out.print(" ");
            if (node.lChild != null)
                tempQueue.add(node.lChild);
            if (node.rChild != null)
                tempQueue.add(node.rChild);
            if (queue.isEmpty()) {
                offset += 3;
                //counter--;
                copyQueue(tempQueue, queue);
                System.out.println();
                for (int i = 0; i < 50 - offset; i++)
                    System.out.print(" ");
            }
        }


    }

    private void copyQueue(ConcurrentLinkedQueue<Node> source,
                           ConcurrentLinkedQueue<Node> target) {
        while (source.peek() != null) {
            target.add(source.poll());
        }
    }

    private class Node {

        public T data;

        public Node lChild;

        public Node rChild;

        public Node parent;

        public int bf;
    }

    public  static  void  test(int i){
        if(i<1){
            return;
        }
        System.out.printf("diidi"+i);

        test(--i);
        System.out.printf("我是"+i);

    }

    public static void main(String[] args) {
//        BalanceBiTree biTree = new BalanceBiTree();
//        biTree.insert("1");
//        biTree.insert("2");
//        biTree.insert("3");
//        biTree.insert("4");
//        biTree.insert("5");
//        biTree.insert("6");
////        System.out.println(biTree);
////        System.out.println(JSON.toJSONString(biTree.root));
//        biTree.printTree();

        test(10);

    }
}