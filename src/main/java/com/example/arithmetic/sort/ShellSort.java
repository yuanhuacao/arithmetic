package com.example.arithmetic.sort;

public class ShellSort {

    /**
     * wiki
     * @param array
     * 分组插入排序，最后再合并
     *
     */
    public static void shellSort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] > temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
    }









    public static void main(String[] args)
    {


        System.out.println(5/2);

//        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };

        int [] a={2,1,4,5,3};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
//        shellSort(a);

        // 希尔排序
        int d = a.length;
        while (true)
        {
            d = d / 2;
            for (int x = 0; x < d; x++)
            {
                for (int i = x + d; i < a.length; i = i + d)
                {
                    int temp = a[i];
                    int j;
                    for (j=  i - d; j >= 0 && a[j] > temp; j = j - d)
                    {

                            a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1)
            {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }
}
