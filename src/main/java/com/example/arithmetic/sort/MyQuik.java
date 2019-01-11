package com.example.arithmetic.sort;

/**
 * @Description: TODO
 * @Date: 2019/1/10 20:34
 */
public class MyQuik {

	public static void quikSort(int[] a,int low,int high){
		if (low>=high){
			return;
		}
		int pivot=getPivot(a,low,high);
		quikSort(a,low,pivot-1);
		quikSort(a,pivot+1,high);

	}
	public static int getPivot(int a[],int low,int high){
		int pivot=a[high];
		int i=low;
		for (int j = low; j <high ; j++) {
			if (a[j]<pivot){
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
			}
		}
		int temp=a[i];
		a[i]=pivot;
		a[high]=temp;
		return i;

	}
	public static void main(String[] args) {
		int[] a={1,5,3,4,7,2};
		quikSort(a,0,a.length-1);
		for (int i = 0; i <a.length ; i++) {
			System.out.println(a[i]);
		}
		String key="dididiidid";
		int h;
		int hash= (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(hash);

	}

}
