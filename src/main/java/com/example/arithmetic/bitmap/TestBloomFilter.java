package com.example.arithmetic.bitmap;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;

public class TestBloomFilter {

    static int sizeOfNumberSet = Integer.MAX_VALUE >> 16;

    static Random generator = new Random();

    public static void main(String[] args) {
        BitSet bitSet=new BitSet();

        System.out.println(0<<25);
        System.out.println(Integer.MAX_VALUE>>16);
        System.out.println(4>>>1);
        System.out.println(Integer.bitCount(55555));
        int a=400;
        a=~a;
        System.out.println(a);

        int error = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet);

        for (int i = 0; i < sizeOfNumberSet; i++) {
            int number = generator.nextInt();
            if (filter.mightContain(number) != hashSet.contains(number)) {
                error++;
            }
            filter.put(number);
            hashSet.add(number);
        }

        System.out.println("Error count: " + error + ", error rate = " + String.format("%f", (float) error / (float) sizeOfNumberSet));
    }
}
