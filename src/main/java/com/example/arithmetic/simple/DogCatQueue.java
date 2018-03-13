package com.example.arithmetic.simple;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQune> dogQueue;
    private Queue<PetEnterQune> catQueue;
    int count=0;

    public DogCatQueue() {
        dogQueue=new LinkedList();
        catQueue=new LinkedList();
    }

    public  void add(Pet pet){
        if (Objects.equals(pet.getType(),"cat")){
            dogQueue.add(new PetEnterQune(pet,count++));
        }else {
            catQueue.add(new PetEnterQune(pet,count++));
        }
    }
    public Pet pollAll(){
        if (dogQueue.isEmpty()){
            return catQueue.poll().getPet();
        }
        if (catQueue.isEmpty()){
            return  dogQueue.poll().getPet();
        }
        if (dogQueue.peek().getCount()<catQueue.peek().getCount()){
            return  dogQueue.poll().getPet();
        }else {
            return  catQueue.poll().getPet();
        }
    }

    public static void main(String[] args) {
        DogCatQueue dogCatQueue=new DogCatQueue();
        Dog dog=new Dog();
        dogCatQueue.add(dog);
        Cat cat=new Cat();
        dogCatQueue.add(cat);
        System.out.println(dogCatQueue.pollAll().getType());
        dogCatQueue.add(cat);
        dogCatQueue.add(dog);
        dogCatQueue.add(cat);
        System.out.println(dogCatQueue.pollAll().getType());
        System.out.println(dogCatQueue.pollAll().getType());
        System.out.println(dogCatQueue.pollAll().getType());
        System.out.println(dogCatQueue.pollAll().getType());

    }



}
