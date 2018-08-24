package com.example.arithmetic.sort;

public class DirectInsertSort {

    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("排序之前：");

        directInsertSort(a);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }

    public  static void directInsertSort(int [] array){

        for (int i=1;i<array.length;i++){
            int temp=array[i];
            int j;
            for ( j=i-1;j>=0;j--){
                if (array[j]>temp){
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            array[j+1]=temp;
        }

    }

}
