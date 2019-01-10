package com.example.arithmetic.geektime.wangzheng;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 堆排序
 * @Author: 曹远华 (yuanhua.cao@luckincoffee.com)
 * @Date: 2018/12/8 12:38
 */
public class Heap {
	private  int[] a;
	// 堆数组中最大个数
	private  int n;
	// 堆数组中已存在个数
	private  int count;

	public Heap(int capacity){
		n=capacity;
		a=new int[capacity+1];
		count=0;

	}

	public void insert(int data){
		if (count>=n){
			return;
		}
		++count;
		a[count]=data;
		int i=count;
		while (i/2>0&&a[i]>a[i/2]){
			swap(a,i,i/2);
			i=i/2;
		}
	}

	public void removeMax(){
		if(count==0){
			return;
		}
		a[1]=a[count];
		a[count]=0;
		--count;
		topHeapfiy(a,count,1);
	}

	public void topHeapfiy(int[] a,int n,int i){
		while (true){
			int maxPox=i;
			if (2*i<=n&&a[2*i]>a[i]){
				maxPox=i*2;
			}
			if ((2*i+1)<=n&&a[2*i+1]>a[i]){
				maxPox=i*2+1;
			}
			if (i==maxPox){
				break;
			}
			swap(a,i,maxPox);
			i=maxPox;

		}

	}


	private void swap(int b[] ,int x,int y){
		int temp=b[x];
		b[x]=b[y];
		b[y]=temp;
	}

	public int[] getA() {
		return a;
	}

	public static void main(String[] args) {
		Heap heap=new Heap(10);
		for (int i=1;i<6;i++){
			heap.insert(new Random().nextInt(100));
		}
		System.out.println(Arrays.toString(heap.getA()));
		heap.removeMax();
		System.out.println(Arrays.toString(heap.getA()));


	}

}
