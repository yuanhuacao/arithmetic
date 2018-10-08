package com.example.arithmetic.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        // 冒泡排序
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1-i;j++){
                if (a[j]>a[j++]){
                    int temp=a[j];
                    a[j]=a[j++];
                    a[j++]=temp;
                }
            }
        }



        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}
