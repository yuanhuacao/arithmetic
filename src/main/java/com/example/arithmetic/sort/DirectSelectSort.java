package com.example.arithmetic.sort;

public class DirectSelectSort {

    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        selectSort(a);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }

    public  static void selectSort(int [] array){

       for (int i=0;i<array.length;i++){
           int min=array[i];
           int temp=i;
           for (int j=i+1;j<array.length;j++){
               if (array[j]<min){
                   min=array[j];
                   temp=j;
               }
           }
           array[temp]=array[i];
           array[i]=min;

       }

    }



}
