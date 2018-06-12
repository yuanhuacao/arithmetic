package com.example.arithmetic.structure;

import com.example.arithmetic.simple.Cat;
import com.example.arithmetic.simple.Pet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {

        Pet p1=new Pet("a");
        Pet p2=new Pet("b");
        Pet p3=new Pet("c");
        Pet p4=new Pet("d");
        Pet p5=new Pet("d","gg");

        Set<Pet> set=new TreeSet<>((a,b)->a.getType().compareTo(b.getType()));
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        for (Pet pet:set){
            System.out.println(pet.getType());
        }

        System.out.println(1>>1);
        System.out.println(2>>1);
        System.out.println(3>>1);
        System.out.println(4>>1);
        System.out.println(5>>1);
        System.out.println(6>>1);
        System.out.println(40>>1);
    }
}
