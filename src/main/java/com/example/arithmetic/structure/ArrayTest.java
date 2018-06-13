package com.example.arithmetic.structure;

public class ArrayTest {
    Object [] elementData;

    public static void main(String[] args) {

        Integer [] elementData={1,2,3,4,5};
        int elementCount=elementData.length;
        int index=0;
        int j = elementCount - index - 1;

        System.arraycopy(elementData, index + 1, elementData, index, j);



        elementCount--;
        elementData[elementCount]=null;

        for(int i=0;i<elementCount;i++){
            System.out.println(elementData[i]);
        }
        System.out.println("array.length "+elementCount);



    }

}
