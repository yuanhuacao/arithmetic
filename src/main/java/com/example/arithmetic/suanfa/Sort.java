package com.example.arithmetic.suanfa;

public class Sort {

    void insert_sort(int array[],int n)
    {
        int i,j;
        int temp;
        for(i = 1;i < n;i++)
        {
            temp = array[i];
            for(j = i;j > 0&& array[j - 1] > temp;j--)
            {
                array[j]= array[j - 1];
            }
            array[j] = temp;
        }
    }
}
