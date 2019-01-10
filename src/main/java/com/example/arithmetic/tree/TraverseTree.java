package com.example.arithmetic.tree;

/**
 * @Description: 遍历二叉树
 * @Author: geeker (geek)
 * @Date: 2019/1/8 17:13
 */
public class TraverseTree {

	public void preOrderTraverse(Node root){
		System.out.println(root.iData);
		if (root.leftNode!=null){
			preOrderTraverse(root.leftNode);
		}
		if (root.rightNode!=null){
			preOrderTraverse(root.rightNode);
		}
	}
	public void inOrderTraverse(Node root){
		if (root.leftNode!=null){
			inOrderTraverse(root.leftNode);
		}
		System.out.println(root.iData);
		if (root.rightNode!=null){
			inOrderTraverse(root.rightNode);
		}
	}
	public void postOrderTraverse(Node root){
		if (root.leftNode!=null){
			postOrderTraverse(root.leftNode);
		}
		if (root.rightNode!=null){
			postOrderTraverse(root.rightNode);
		}
		System.out.println(root.iData);
	}

}
