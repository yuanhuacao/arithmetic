package com.example.arithmetic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BiSearch {

    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    public static int sort(int []array,int a,int lo,int hi){
        if(lo<=hi){
            int mid=(lo+hi)/2;
            if(a==array[mid]){
                return mid+1;
            }
            else if(a>array[mid]){
                return sort(array,a,mid+1,hi);
            }else{
                return sort(array,a,lo,mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("6", "1", "3", "1","2");

        Collections.sort(strings);//sort方法在这里

        for (String string : strings) {

            System.out.println(string);
        }
    }
}
