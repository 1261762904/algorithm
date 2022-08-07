package com.yx.sort;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,0,6,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        buildHeap(array);
        System.out.println(Arrays.toString(array));
        //array = new int[]{6, 3, 1, 0, 2, 1,4};
        //upAdjust(array);
        //System.out.println(Arrays.toString(array));
        for(int i=array.length-1;i>0;i--){
            int temp = array[i];
            array[i]=array[0];
            array[0]=temp;
            downAdjust(array,0,i);
        }
        //System.out.println(Arrays.toString(array));
    }

    private static void buildHeap(int[] array) {
        for(int i=(array.length-2)/2;i>=0;i--){
            downAdjust(array,i,array.length);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int child = parentIndex*2+1;
        int temp = array[parentIndex];
        while (child<length) {
            if (child + 1 < length && array[child] < array[child + 1]) child++;
            if (temp >= array[child]) break;
            array[parentIndex] = array[child];
            parentIndex = child;
            child = parentIndex * 2 + 1;

        }
        array[parentIndex]=temp;
    }

    private static void upAdjust(int[] array){
        int child = array.length-1;
        int parentIndex = (child-1)/2;
        int temp = array[child];
        while (parentIndex>=0&&array[parentIndex]<temp){
            array[child]=array[parentIndex];
            child=parentIndex;
            parentIndex=(child-1)/2;
        }
        array[child]=temp;
    }
}
